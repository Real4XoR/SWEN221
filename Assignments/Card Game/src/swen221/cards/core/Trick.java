// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.cards.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Represents a trick being played. This includes the cards that have been
 * played so far, as well as what the suit of trumps is for this trick.
 *
 * @author David J. Pearce
 *
 */
public class Trick {
	private Card[] cards = new Card[4];
	private Player.Direction lead;
	private Card.Suit trumps;

	/**
	 * Contruct a new trick with a given lead player and suit of trumps.
	 *
	 * @param lead
	 *            --- lead player for this trick.
	 * @param trumps
	 *            --- maybe null if no trumps.
	 */
	public Trick(Player.Direction lead, Card.Suit trumps) {
		this.lead = lead;
		this.trumps = trumps;
	}

	/**
	 * Determine who the lead player for this trick is.
	 *
	 * @return The direction of the lead player.
	 */
	public Player.Direction getLeadPlayer() {
		return lead;
	}

	/**
	 * Determine which suit are trumps for this trick, or <code>null</code> if there
	 * are no trumps.
	 *
	 * @return The current suit of trumps
	 */
	public Card.Suit getTrumps() {
		return trumps;
	}

	/**
	 * Get the list of cards played so far in the order they were played.
	 *
	 * @return The list of cards played so far.
	 */
	public List<Card> getCardsPlayed() {
		ArrayList<Card> cs = new ArrayList<>();
		for(int i=0;i!=4;++i) {
			if(cards[i] != null) {
				cs.add(cards[i]);
			} else {
				break;
			}
		}
		return cs;
	}

	/**
	 * Get the card played by a given player, or null if that player has yet to
	 * play.
	 *
	 * @param p --- player
	 * @return The card played by the player.
	 */
	public Card getCardPlayed(Player.Direction p) {
		Player.Direction player = lead;
		for(int i=0;i!=4;++i) {
			if(player.equals(p)) {
				return cards[i];
			}
			player = player.next();
		}
		// deadcode
		return null;
	}

	/**
	 * Determine the next player to play in this trick.
	 *
	 * @return The next player to play.
	 */
	public Player.Direction getNextToPlay() {
		Player.Direction dir = lead;
		for(int i=0;i!=4;++i) {
			if(cards[i] == null) {
				return dir;
			}
			dir = dir.next();
		}
		return null;
	}

	/**
	 * Determine the winning player for this trick. This requires looking to see
	 * which player led the highest card that followed suit; or, was a trump.
	 *
	 * @return The winning player (thus far).
	 */
	public Player.Direction getWinner() {
		Player.Direction player = lead;
		Player.Direction winningPlayer = null;
		Card winningCard = cards[0];
		for (int i = 0; i != 4; ++i) {
			if (cards[i].suit() == winningCard.suit()
					&& cards[i].compareTo(winningCard) >= 0) {
				winningPlayer = player;
				winningCard = cards[i];
			} else if (trumps != null && cards[i].suit() == trumps
					&& winningCard.suit() != trumps) {
				// in this case, the winning card is a trump
				winningPlayer = player;
				winningCard = cards[i];
			}
			player = player.next();
		}
		return winningPlayer;
	}

	/**
	 * Player attempts to play a card. This method checks that the given player is
	 * entitled to play, and that the played card follows suit. If either of these
	 * are not true, it throws an IllegalMove exception.
	 *
	 * @param p The player who is playing the card.
	 * @param c The card being played.
	 * @throws IllegalMove If the player / card combination is invalid.
	 */
	public void play(Player p, Card c) throws IllegalMove {
		// FIXME: we need to checks here for attempts to make illegal moves.

		if (!p.getHand().contains(c)) {
			throw new IllegalMove(
					"The player at " + p.getDirection().toString() + " doesn't have " + c.toString() + " to play.");
		}

		// Only players whose turn it is can play
		if (getNextToPlay() != p.getDirection()) {
			throw new IllegalMove("It's not the turn for the player at " + p.getDirection().toString() + "to play.");
		}

		/*
		 * Must play the lead card otherwise trump rule is broken.
		 */
		if (p.getDirection() != lead) {
			Card.Suit leadSuit = getCardPlayed(lead).suit();
			Set<Card> cardsMatchesLead = p.getHand().matches(leadSuit);
			if (!cardsMatchesLead.isEmpty() && !cardsMatchesLead.contains(c)) {
				throw new IllegalMove(
						"The player at " + p.getDirection().toString() + " doesn't follow the lead suit.");
			}
		}

		// Finally, play the card.
		for (int i = 0; i != 4; ++i) {
			if (cards[i] == null) {
				cards[i] = c;
				p.getHand().remove(c);
				break;
			}
		}
	}
}

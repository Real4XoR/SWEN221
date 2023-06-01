// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.cards.util;

import swen221.cards.core.Card;
import swen221.cards.core.Player;
import swen221.cards.core.Trick;
import swen221.cards.core.Hand;

/**
 * Implements a simple computer player who plays the highest card available when
 * the trick can still be won, otherwise discards the lowest card available. In
 * the special case that the player must win the trick (i.e. this is the last
 * card in the trick), then the player conservatively plays the least card
 * needed to win.
 *
 * @author David J. Pearce
 *
 */
public class SimpleComputerPlayer extends AbstractComputerPlayer {

	/**
	 * Construct a new (simple) computer player with the given player information.
	 *
	 * @param player Key player informmation.
	 */
	public SimpleComputerPlayer(Player player) {
		super(player);
	}

	@Override
	public Card getNextCard(Trick trick) {
		// Get the cards played in the trick so far
		java.util.List<Card> cardsPlayed = trick.getCardsPlayed();

		// Check if this is the last card in the trick
		boolean lastCard = cardsPlayed.size() == 3;

		// Get the cards in the player's hand
		Hand hand = getPlayer().getHand();

		// Find the highest card that can be played
		Card highestCard = null;
		for (Card card : hand) {
			if (trick.getCardPlayed(getPlayer().getDirection()) != null) {
				// Check if the card follows suit
				if (card.suit() == trick.getCardPlayed(trick.getLeadPlayer()).suit()) {
					if (highestCard == null || card.compareTo(highestCard) > 0) {
						highestCard = card;
					}
				}
			} else {
				// The player leads the trick
				if (highestCard == null || card.compareTo(highestCard) > 0) {
					highestCard = card;
				}
			}
		}

		// If the player must win the trick, play the lowest card to win
		if (lastCard && highestCard != null) {
			for (Card card : hand) {
				if (card.suit() == trick.getTrumps() && card.compareTo(highestCard) < 0) {
					return card;
				}
			}
		}

		// If a highest card is found, play it
		if (highestCard != null) {
			return highestCard;
		}

		// If no card can win the trick, discard the lowest card
		Card lowestCard = null;
		for (Card card : hand) {
			if (lowestCard == null || card.compareTo(lowestCard) < 0) {
				lowestCard = card;
			}
		}

		return lowestCard;
	}
}

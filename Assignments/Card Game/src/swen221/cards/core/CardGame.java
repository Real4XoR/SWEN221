// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.cards.core;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Represents a Whist-like card game.
 *
 * @author David J. Pearce
 *
 */
public interface CardGame extends Cloneable {

	/**
	 * Get the name of the game being played (e.g. classic Whist).
	 *
	 * @return The name of the game.
	 */
	public String getName();

	/**
	 * Get the player sitting at the given direction.
	 *
	 * @param direction
	 * @return The player in a given direction.
	 */
	public Player getPlayer(Player.Direction direction);

	/**
	 * Return the current trick being played, or null if the game is finished.
	 *
	 * @return The current trick.
	 */
	public Trick getTrick();

	/**
	 * Check whether the game is finished or not.
	 *
	 * @return <code>true</code> if the game is finished, <code>false</code>
	 *         otherwise.
	 */
	public boolean isGameFinished();

	/**
	 * Check whether the hand is finished or not.
	 *
	 * @return <code>true</code> if the hand is finished, <code>false</code>
	 *         otherwise.
	 */
	public boolean isHandFinished();


	/**
	 * Return the winner(s) of this game. Note that there can be multiple
	 * winners in games where players form partnerships, or where there is a
	 * draw.
	 *
	 * @return The winners of the game.
	 */
	public Set<Player.Direction> getWinnersOfGame();

	/**
	 * Return the number of tricks each player has won in the current hand.
	 *
	 * @return The number of tricks won by each player.
	 */
	public Map<Player.Direction,Integer> getTricksWon();

	/**
	 * Return the overall score in the game as a whole.
	 *
	 * @return The over scores for each player.
	 */
	public Map<Player.Direction,Integer> getOverallScores();

	/**
	 * The given player plays the given card.
	 *
	 * @param player The player who is playing the card.
	 * @param card   The card being played.
	 * @throws IllegalMove If the player / card combination is invalid.
	 */
	public void play(Player.Direction player, Card card) throws IllegalMove;

	/**
	 * Start a new hand by dealing out the given deck.
	 *
	 * @param deck The deck of cards to be dealt.
	 */
	public void deal(List<Card> deck);

	/**
	 * Signal that the current hand is over. This is a useful opportunity to
	 * update player scores, etc.
	 */
	public void endHand();

	/**
	 * Signal that the current round is over. This is a useful opportunity to
	 * update player trick counts, etc.
	 */
	public void endRound();

	/**
	 * Start the current trick
	 */
	public void startRound();

	/**
	 * Clone this game
	 *
	 * @return An identical copy of this card game.
	 */
	public CardGame clone();

}

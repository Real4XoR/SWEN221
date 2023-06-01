// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.cards.core;

/**
 * Use to signal an illegal move has occurred. This typically happens when a
 * human play attempts to play out of turn and/or with a card that doesn't
 * follow suit, etc.
 *
 * @author David J. Pearce
 *
 */
public class IllegalMove extends Exception {
	/**
	 * Construct a new illegal move exception.
	 *
	 * @param description A description of the problem.
	 */
	public IllegalMove(String description) {
		super(description);
	}
}

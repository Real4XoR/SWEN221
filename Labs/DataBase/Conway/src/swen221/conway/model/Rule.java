// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.conway.model;

/**
 * Provides a concept of a rule for controlling cell creation / destruction in
 * the simulation.
 * 
 * @author David J. Pearce
 *
 */
public interface Rule {
	/**
	 * A constant for capturing the case when a rule does not apply.
	 */
	public final static int NOT_APPLICABLE = -1;
	
	/**
	 * Apply a given rule to a board to determine the cell's current state.
	 * 
	 * @param x
	 *            The horizontal position of the cell on the board whose state
	 *            we are calculating
	 * @param y
	 *            The vertical position of the cell on the board whose state we
	 *            are calculating
	 * @param view
	 *            The current state of the board
	 * @return The new state of the cell, or -1 if this rule could not apply.
	 */
	public int apply(int x, int y, BoardView view);
}

// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.model;

/**
 * A location represents the position of a cell on a board.
 *
 * @author betty
 *
 */
public class Location {
	/**
	 * Represents row (i.e. y) position of this location on the board.
	 */
	public final int row;
	/**
	 * Represents column (i.e. x) position of this location on the board.
	 */
	public final int col;

	/**
	 * Create a new Location for a given x and y position.
	 *
	 * @param x --- X position on board.
	 * @param y --- Y position on board.
	 */
	public Location(int x, int y) {
		this.row = y;
		this.col = x;
	}
}

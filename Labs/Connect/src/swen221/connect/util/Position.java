// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.connect.util;

/**
 * Represents an (x,y) position on the game board.
 *
 * @author David J. Pearce
 *
 */
public final class Position {
	private final int x;
	private final int y;

	/**
	 * Construct a position on the board
	 *
	 * @param x
	 * @param y
	 */
	public Position(int x, int y) {
		if(x < 0 || x >= 4) {
			throw new IllegalArgumentException("Invalid X component: " + x);
		}
		if(y < 0 || y >= 4) {
			throw new IllegalArgumentException("Invalid Y component: " + y);
		}
		this.x = x;
		this.y = y;
	}

	/**
	 * Get the X component associated with this position.
	 *
	 * @return
	 */
	public int getX() {
		return x;
	}

	/**
	 * Get the Y component associated with this position.
	 *
	 * @return
	 */
	public int getY() {
		return y;
	}

	/**
	 * Provide a human readable string representing this position.
	 */
	public String toString() {
		return "(" + x + "," + y + ")";
	}
}

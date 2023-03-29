// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.conway.model;

/**
 * Implements a view of the board, from which it is impossible to actually
 * change the board. This view can be passed to rules so they can "see" the
 * board, but not change it.
 * 
 * @author David J. Pearce
 *
 */
public interface BoardView {
	/**
	 * Get the width of the board (in cells)
	 * 
	 * @return
	 */
	public int getWidth();
	
	/**
	 * Get the height of the board (in cells)
	 * 
	 * @return
	 */
	public int getHeight();
	
	/**
	 * Get the state of a given cell on the board
	 * 
	 * @param x
	 *            Horizontal position of Cell
	 * @param y
	 *            Vertical position of Cell
	 * @return
	 */
	public int getCellState(int x, int y);
}

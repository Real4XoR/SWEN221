// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.cards.util;

import swen221.cards.core.*;

/**
 * Represents an computer player in the game. This class can be overriden with
 * different implementations that use different kinds of A.I. to determine
 * appropriate moves.
 *
 * @author David J. Pearce
 *
 */
public abstract class AbstractComputerPlayer {
	/**
	 * Records information about the computer player, such as their current hand and
	 * the location on the table where they are sitting.
	 */
	protected Player player;

    /**
	 * Construct a new computer player.
	 *
	 * @param player Player information
	 */
    public AbstractComputerPlayer(Player player) {
    	this.player = player;
    }

	public Player getPlayer() {
		return player;
	}

	/**
	 * Get the next card to be played by this computer player in a given trick. The
	 * method is abstract to allow subclasses to implement different algorithms for
	 * this.
	 *
	 * @param trick The trick being played.
	 * @return The card to play next.
	 */
	abstract public Card getNextCard(Trick trick);

	/**
	 * Set the current player information associated with this player.
	 *
	 * @param player The new information to use.
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
}

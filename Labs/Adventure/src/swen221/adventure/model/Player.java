// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.adventure.model;

import java.util.*;

/**
 * This class records various pieces of information about the game player,
 * including: their name, their current health and location, and what they're
 * carrying.
 * 
 * @author David J. Pearce
 * 
 */
public class Player {		
	/**
	 * Represents the current location of the player in the game.
	 */
	private Room location;

	/**
	 * Items the player is carrying
	 */
	private ArrayList<Item> inventory;
	
	public Player(Room location) {
		this.location = location;
		this.inventory = new ArrayList<Item>();
	}
	
	/**
	 * Return the players current location
	 * @return
	 */
	public Room getLocation() {
		return location;
	}
	
	/**
	 * Set the player to a new location in the game
	 * @return
	 */
	public void setLocation(Room location) {
		this.location = location;
	}
	
	public List<Item> getInventory() {
		return inventory;
	}
}

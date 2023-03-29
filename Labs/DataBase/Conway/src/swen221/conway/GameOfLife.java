// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.conway;

import swen221.conway.model.*;
import swen221.conway.rules.*;
import swen221.conway.view.BoardFrame;

public class GameOfLife {
	/**
	 * The standard rule set for Conway's "Game of Life".
	 */
	public static final Rule[] ConwaysOriginalRules = {
			new ConwaysUnderpopulationRule(),
			new ConwaysReproductionRule(),
			new ConwaysOverpopulationRule()
	};
	
	/**
	 * The entry point for the GameOfLife application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Board board = new Board(50,50);
		Simulation sim = new Simulation(board,ConwaysOriginalRules);
		new BoardFrame(sim);
	}
}

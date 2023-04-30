// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.connect;

import swen221.connect.core.Board;
import swen221.connect.core.Game;
import swen221.connect.view.GraphicalUserInterface;

public class Main {
	public static void main(String[] args) {
		Board board = new Board();
		Game game = new Game(board);
		GraphicalUserInterface gui = new GraphicalUserInterface(game);
	}
}

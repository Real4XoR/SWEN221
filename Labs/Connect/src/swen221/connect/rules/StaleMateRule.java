// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.connect.rules;

import swen221.connect.core.Game;
import swen221.connect.core.Rule;
import swen221.connect.core.Game.Status;

/**
 * Checks whether or not a stale mate has been reached.
 *
 * @author David J. Pearce
 *
 */
public class StaleMateRule implements Rule {

	@Override
	public Status apply(Game g) {
		// Here, we need to check how many tokens have been played so far. Since
		// each player starts with exactly eight tokens, there can be at most
		// eight tokens played by each player. After that point, we have reached
		// a stalemate. When this happens, we need to return the appropriate
		// status signal. And, yes, it is possible to reach stalemate.
		if (g.getMovesPlayed() >= 16 && g.getStatus() != Status.STALEMATE) {
			return Status.STALEMATE;
		} else {
			return g.getStatus();
		}
	}
}

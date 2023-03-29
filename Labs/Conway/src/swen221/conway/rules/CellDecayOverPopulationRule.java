package swen221.conway.rules;

import swen221.conway.model.*;
import swen221.conway.util.CellDecayAbstractRule;

/**
 * This should implements Cell Decay version of Conway's rule for
 * overproduction:
 *
 * "Any live cell with more than three live neighbours gets older, as if
 *  by over-population."
 *
 * @author David J. Pearce
 *
 */
public class CellDecayOverPopulationRule extends CellDecayAbstractRule {

  @Override
  public int apply(int x, int y, int neighbours) {
    if (neighbours > 3) {
      // This rule was applied in this case
      return CellDecayAbstractRule.board.getCellState(x, y) + GET_OLDER;
    } else {
      // This rule was not applied in this case
      return Rule.NOT_APPLICABLE;
    }
  }
}
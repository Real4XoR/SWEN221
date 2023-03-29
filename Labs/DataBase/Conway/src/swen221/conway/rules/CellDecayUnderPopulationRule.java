package swen221.conway.rules;

import swen221.conway.model.*;
import swen221.conway.util.CellDecayAbstractRule;

/**
 * "Any live cell with fewer than two live neighbours gets older, as if caused
 * by under-population."
 *
 * @author David J. Pearce
 *
 */
public class CellDecayUnderPopulationRule extends CellDecayAbstractRule {

  @Override
  public int apply(int x, int y, int neighbours) {
    if (neighbours < 2) {
      return CellDecayAbstractRule.board.getCellState(x, y) + GET_OLDER;
    } else {
      return Rule.NOT_APPLICABLE;
    }
  }
}
package swen221.conway.rules;

import swen221.conway.model.*;
import swen221.conway.util.CellDecayAbstractRule;

/**
 * "Any cell with exactly three live neighbours gets younger, as if by happiness."
 *
 * @author David J. Pearce
 *
 */
public class CellDecayReproductionRule extends CellDecayAbstractRule {

  @Override
  public int apply(int x, int y, int neighbours) {
    if (neighbours == 3) {
      // This rule was applied in this case
      return CellDecayAbstractRule.board.getCellState(x, y) + GET_YOUNGER;
    } else {
      // This rule was not applied in this case
      return Rule.NOT_APPLICABLE;
    }
  }
}
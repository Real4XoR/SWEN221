package swen221.conway.util;

import swen221.conway.model.*;

/**
 * Class for implementing Conway's Cell Decay rules
 */
public abstract class CellDecayAbstractRule implements Rule{
  public final static int GET_YOUNGER = -1;
  public final static int GET_OLDER = 1;
  public final static int DEAD = 9;

  public static BoardView board;

  @Override
  public int apply(int x, int y, BoardView board) {
    int count = 0;

    CellDecayAbstractRule.board = board;

    // top row
    count += getNumAlive(x-1,y-1,board);
    count += getNumAlive(x,y-1,board);
    count += getNumAlive(x+1,y-1,board);
    // middle row
    count += getNumAlive(x-1,y,board);
    count += getNumAlive(x+1,y,board);
    // bottom row
    count += getNumAlive(x-1,y+1,board);
    count += getNumAlive(x,y+1,board);
    count += getNumAlive(x+1,y+1,board);
    //
    return apply(x,y,count);
  }

  /**
   * Apply the rule
   */
  public abstract int apply(int x, int y, int neighbours);

  /**
   * Check the state of an adjacent cell
   */
  private int getNumAlive(int x, int y, BoardView board) {
    if (x < 0 || x >= board.getWidth()) {
      return 0;
    } else if (y < 0 || y >= board.getWidth()) {
      return 0;
    } else if (board.getCellState(x, y) >= DEAD) {
      return 0;
    } else {
      return 1;
    }
  }
}
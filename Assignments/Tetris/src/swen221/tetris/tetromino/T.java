package swen221.tetris.tetromino;

import swen221.tetris.logic.Color;

public class T extends Tetromino{

  /**
   * The idea is that a T looks like a cross without one of the 4 sides.
   * Numbers and sides are connected by the following diagram:
   *   0
   * 1 _ 3
   *   2
   *
   */
  int sideAbsent= 0;

  /**
   * When the absent side is asked, we return the center position,
   * otherwise, some math generates the right coordinate
   * */
  @Override
  public int x(int i) {
    if (i == sideAbsent || i == 0 || i == 2 ) { return centerX(); }
    if (i == 1) { return centerX() + 1; }
    return centerX() - 1;
  }

  /**
   * When the absent side is asked, we return the center position
   * otherwise, some math generates the right coordinate
   * */
  @Override
  public int y(int i) {
    if (i == sideAbsent || i == 1 || i == 3) { return centerY(); }
    if (i == 2) { return centerY() - 1; }
    return centerY() + 1;

  }

  public T(int x, int y, Color color) {
    super(x, y, color);
  }

  /**iterate over the 4 possibilities*/
  @Override
  public void rotateRight() {
    sideAbsent = (sideAbsent + 1) % 4;
  }
}

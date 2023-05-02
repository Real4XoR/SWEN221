package swen221.tetris.tetromino;

import swen221.tetris.logic.Color;

/**
 * I is the 'bar'.
 * It has only 2 possible orientations.
 * */
public class I extends Tetromino{
  /**a bar is either horizontal or vertical*/
  boolean horizontal= true;

  /**if is horizontal, then i indicate the distance from the center*/
  @Override
  public int x(int i) {
    if (horizontal) { return centerX() + i - 1; }
    return centerX();
  }

  /**if is vertical, then i indicate the distance from the center*/
  @Override
  public int y(int i) {
    if (!horizontal) { return centerY() + i - 1; }
    return centerY();
  }

  public I(int x, int y, Color color) {
    super(x, y, color);
  }

  /**iterate between the two possibilities*/
  @Override
  public void rotateRight() {
    horizontal =! horizontal;
  }
}

package swen221.tetris.tetromino;

import swen221.tetris.logic.Color;

public class O extends Tetromino{
  public O(int x, int y, Color color) {
    super(x, y, color);
  }

  @Override
  public int x(int i) {
    return (i % 2 == 0) ? centerX() - 1 : centerX();
  }

  @Override
  public int y(int i) {
    return (i < 2) ? centerY() : centerY() - 1;
  }

  @Override
  public void rotateRight() {/*TODO: complete this code*/
    //A circle doesn't rotate
  }
  //TODO: add more methods if needed
}

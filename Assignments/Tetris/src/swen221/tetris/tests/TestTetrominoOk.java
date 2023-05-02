package swen221.tetris.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import swen221.tetris.logic.Color;
import swen221.tetris.tetromino.I;
import swen221.tetris.tetromino.J;
import swen221.tetris.tetromino.L;
import swen221.tetris.tetromino.O;
import swen221.tetris.tetromino.S;
import swen221.tetris.tetromino.T;
import swen221.tetris.tetromino.Tetromino;
import swen221.tetris.tetromino.Z;

public class TestTetrominoOk {
  public static boolean equalTetromino(Tetromino t1,Tetromino t2) {
    if (t1.centerX() != t2.centerX()) { return false; }
    if (t1.centerY() != t2.centerY()) { return false; }
    
    if (t1.x(0) != t2.x(0)) { return false; }
    if (t1.x(1) != t2.x(1)) { return false; }
    if (t1.x(2) != t2.x(2)) { return false; }
    if (t1.x(3) != t2.x(3)) { return false; }

    if (t1.y(0) != t2.y(0)) { return false; }
    if (t1.y(1) != t2.y(1)) { return false; }
    if (t1.y(2) != t2.y(2)) { return false; }
    if (t1.y(3) != t2.y(3)) { return false; }
    return true;
  }

  void testTRotate(Tetromino t1, Tetromino t2, boolean isO) {
    testT(t1, t2, isO);
    if (isO) { return; }
    t1.rotateLeft();
    t2.rotateLeft();
    testT(t1, t2, isO);
    t1.rotateLeft();
    t2.rotateLeft();
    testT(t1, t2, isO);
    t1.rotateLeft();
    t2.rotateLeft();
    testT(t1, t2, isO);
    t1.rotateLeft();
    t2.rotateLeft();
    testT(t1, t2, isO);
  }
  void testT(Tetromino t1, Tetromino t2, boolean isO) {
    assertTrue(equalTetromino(t1, t1));
    assertTrue(equalTetromino(t1, t2));
    assertTrue(equalTetromino(t2, t2));
    t2.moveDown();
    assertFalse(equalTetromino(t1, t2));
    t2.moveUp();//up down
    assertTrue(equalTetromino(t1, t2));
    t2.moveUp();
    assertFalse(equalTetromino(t1, t2));
    t2.moveDown();//down up
    assertTrue(equalTetromino(t1, t2));
    t2.moveLeft();//left right
    assertFalse(equalTetromino(t1, t2));
    t2.moveRight();
    assertTrue(equalTetromino(t1, t2));
    t2.moveRight();//right left
    assertFalse(equalTetromino(t1, t2));
    t2.moveLeft();
    assertTrue(equalTetromino(t1, t2));
    t2.rotateLeft();//rotate left right
    if (!isO) { assertFalse(equalTetromino(t1, t2)); }
    t2.rotateRight();
    assertTrue(equalTetromino(t1, t2));
    t2.rotateRight();//rotate right left
    if (!isO){ assertFalse(equalTetromino(t1, t2)); }
    t2.rotateLeft();
    assertTrue(equalTetromino(t1, t2));
    t2.rotateLeft();//rotate 360
    t2.rotateLeft();
    t2.rotateLeft();
    t2.rotateLeft();
    assertTrue(equalTetromino(t1, t2));
  }

  @Test
  void testI() {
    testTRotate(new I(5, 5, Color.BLUE), new I(5, 5, Color.BLUE), false);
  }
  @Test
  void testO() {
    testTRotate(new O(5, 5, Color.BLUE), new O(5, 5, Color.BLUE), true);
  }
  @Test
  void testJ() {
    testTRotate(new J(5, 5, Color.BLUE), new J(5, 5, Color.BLUE), false);
  }
  @Test
  void testL() {
    testTRotate(new L(5, 5, Color.BLUE), new L(5, 5, Color.BLUE), false);
  }
  @Test
  void testS() {
    testTRotate(new S(5, 5, Color.BLUE), new S(5, 5, Color.BLUE), false);
  }
  @Test
  void testZ() {
    testTRotate(new Z(5, 5, Color.BLUE), new Z(5, 5, Color.BLUE), false);
  }
  @Test
  void testT() {
    testTRotate(new T(5, 5, Color.BLUE), new T(5, 5, Color.BLUE), false);
  }
}

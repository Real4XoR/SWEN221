package swen221.tetris.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Color;
import swen221.tetris.tetromino.O;
import swen221.tetris.tetromino.Tetromino;

public class OTest {

  @Test
  void testPut() {
    Board b= new Board();
    new O(5, 5, Color.BLUE).copyOnBoard(b);
    assertEquals("""
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|b|b|_|_|_|
      |_|_|_|_|_|b|b|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      """,
      b.toString());
  }
  @Test
  void testRotate() {
    Board b= new Board();
    Tetromino t= new O(5, 5, Color.BLUE);
    t.rotateLeft();
    t.copyOnBoard(b);
    assertEquals("""
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|b|b|_|_|_|
      |_|_|_|_|_|b|b|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      """,
      b.toString());
  }
  @Test
  void testRotateMany() {
    Tetromino t1= new O(5, 5, Color.BLUE);
    Tetromino t2= new O(5, 5, Color.BLUE);
    t1.rotateLeft();
    assertTrue(TestTetrominoOk.equalTetromino(t1, t2));
    t1.rotateLeft();
    assertTrue(TestTetrominoOk.equalTetromino(t1, t2));
    t1.rotateLeft();
    assertTrue(TestTetrominoOk.equalTetromino(t1, t2));
    t1.rotateLeft();
    assertTrue(TestTetrominoOk.equalTetromino(t1, t2));
    t2.rotateLeft();//just to be sure is not valid only for the default orientation
    assertTrue(TestTetrominoOk.equalTetromino(t1, t2));
    t1.rotateLeft();
    assertTrue(TestTetrominoOk.equalTetromino(t1, t2));
    t1.rotateLeft();
    assertTrue(TestTetrominoOk.equalTetromino(t1, t2));
    t1.rotateLeft();
    assertTrue(TestTetrominoOk.equalTetromino(t1, t2));
    t1.rotateLeft();
    assertTrue(TestTetrominoOk.equalTetromino(t1, t2));
  }
}

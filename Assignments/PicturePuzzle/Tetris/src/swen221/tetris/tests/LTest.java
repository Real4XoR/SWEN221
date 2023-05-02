package swen221.tetris.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Color;
import swen221.tetris.tetromino.J;
import swen221.tetris.tetromino.L;
import swen221.tetris.tetromino.Tetromino;

public class LTest {

  @Test
  void testPut() {
    Board b= new Board();
    new L(5, 5, Color.BLUE).copyOnBoard(b);
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
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|b|b|b|_|_|_|
      |_|_|_|_|b|_|_|_|_|_|
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
    Tetromino t= new L(5, 5, Color.BLUE);
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
      |_|_|_|_|_|b|_|_|_|_|
      |_|_|_|_|_|b|_|_|_|_|
      |_|_|_|_|_|b|b|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      """,
      b.toString());
    
  }

  @Test
  void testRotate2() {
    Board b= new Board();
    Tetromino t= new L(5, 5, Color.BLUE);
    t.rotateLeft();
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
      |_|_|_|_|_|_|b|_|_|_|
      |_|_|_|_|b|b|b|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      """,
      b.toString());
  }

  @Test
  void testRotate3() {
    Board b= new Board();
    Tetromino t= new L(5, 5, Color.BLUE);
    t.rotateLeft();
    t.rotateLeft();
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
      |_|_|_|_|b|b|_|_|_|_|
      |_|_|_|_|_|b|_|_|_|_|
      |_|_|_|_|_|b|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      """,
      b.toString());
  }

  @Test
  void testRotateTwice() {
    Tetromino t1= new L(5, 5, Color.BLUE);
    Tetromino t2= new L(5, 5, Color.BLUE);
    t1.rotateLeft(); t1.rotateLeft();
    assertFalse(TestTetrominoOk.equalTetromino(t1, t2));
    t1 = new L(5, 5, Color.BLUE);
    t2 = new L(5, 5, Color.BLUE);
    t1.rotateLeft(); t1.rotateLeft(); t1.rotateLeft();
    t2.rotateLeft();
    assertFalse(TestTetrominoOk.equalTetromino(t1, t2));
  }
  @Test
  void testSingleMethodAdded() {
    Class<?>c= L.class;
    assertEquals(J.class, c.getSuperclass());
    assertEquals(1, c.getDeclaredMethods().length);
  }
}

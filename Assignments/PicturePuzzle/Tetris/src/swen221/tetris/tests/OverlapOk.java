package swen221.tetris.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Color;
import swen221.tetris.logic.Game;
import swen221.tetris.tetromino.Tetromino;

public class OverlapOk {

  @Test void testNoOverlapAlone0(){ testNoOverlapAloneTall(0); }
  @Test void testNoOverlapAlone1(){ testNoOverlapAloneTall(0); }
  @Test void testNoOverlapAlone2(){ testNoOverlapAlone(2); }
  @Test void testNoOverlapAlone3(){ testNoOverlapAlone(3); }
  @Test void testNoOverlapAlone4(){ testNoOverlapAloneTall(4); }
  @Test void testNoOverlapAlone5(){ testNoOverlapAloneTall(5); }
  @Test void testNoOverlapAlone6(){ testNoOverlapAlone(6); }
  
  void testNoOverlapAloneTall(int i){
    Board b= new Board();
    Tetromino t= Game.nextTetromino
      .get(0).apply(Color.BLUE);
    assertFalse(t.overlap(b));
    assertFalse(t.touch(b));
    t.rotateLeft();
    assertTrue(t.overlap(b)); //out from the top
    assertTrue(t.touch(b));
    t.rotateLeft();
    assertFalse(t.overlap(b));
    assertFalse(t.touch(b));
    t.rotateLeft();
    assertTrue(t.overlap(b));
    assertTrue(t.touch(b));
  }
  void testNoOverlapAlone(int i){
    Board b= new Board();
    Tetromino t= Game.nextTetromino
      .get(i).apply(Color.BLUE);
    assertFalse(t.overlap(b));
    assertFalse(t.touch(b));
    t.rotateLeft();
    assertFalse(t.overlap(b));
    assertFalse(t.touch(b));
    t.rotateLeft();
    assertFalse(t.overlap(b));
    assertFalse(t.touch(b));
    t.rotateLeft();
    assertFalse(t.overlap(b));
    assertFalse(t.touch(b));
  }
  @Test void testOverlapWithBar1(){ testOverlapWithBar(1); }
  @Test void testOverlapWithBar2(){ testOverlapWithBar(2); }
  @Test void testOverlapWithBar3(){ testOverlapWithBar(3); }
  @Test void testOverlapWithBar4(){ testOverlapWithBar(4); }
  @Test void testOverlapWithBar5(){ testOverlapWithBar(5); }
  @Test void testOverlapWithBar6(){ testOverlapWithBar(6); }
  
  void testOverlapWithBar(int i){
    Board b= new Board();
    Tetromino bar= Game.nextTetromino//the I bar
        .get(0).apply(Color.RED);
    bar.copyOnBoard(b);
    Tetromino t= Game.nextTetromino
      .get(i).apply(Color.BLUE);
    //below you can see how to get a printout of the board if the test fails
    assertTrue(t.overlap(b),()->{ t.copyOnBoard(b); return b.toString(); });
    assertFalse(t.touch(b)); //the bar just stays on the very top
    t.rotateLeft();
    assertTrue(t.overlap(b));
    t.rotateLeft();
    assertTrue(t.overlap(b));
    t.rotateLeft();
    assertTrue(t.overlap(b));
  }
  @Test void testOverlapWithBarBar(){
    Board b= new Board();
    Tetromino bar= Game.nextTetromino//the I bar
        .get(0).apply(Color.RED);
    bar.copyOnBoard(b);
    Tetromino t= Game.nextTetromino
      .get(0).apply(Color.BLUE);
    assertTrue(t.overlap(b));
    assertFalse(t.touch(b));//the second bar, if moved down would be safe
    t.rotateLeft();
    assertTrue(t.overlap(b));
    assertTrue(t.touch(b));
    t.rotateLeft();
    assertTrue(t.overlap(b));
    assertFalse(t.touch(b));
    t.rotateLeft();
    assertTrue(t.overlap(b));
    assertTrue(t.touch(b));
  }
}
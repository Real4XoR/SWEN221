package swen221.tetris.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Color;
import swen221.tetris.logic.Game;
import swen221.tetris.tetromino.I;
import swen221.tetris.tetromino.Tetromino;

public class ITest {

  @Test
  void testPut() {
    Board b= new Board();
    new I(5, 5, Color.BLUE).copyOnBoard(b);
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
      |_|_|_|_|b|b|b|b|_|_|
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
    Tetromino t= new I(5, 5, Color.BLUE);
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
      |_|_|_|_|_|b|_|_|_|_|
      |_|_|_|_|_|b|_|_|_|_|
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
    Tetromino t1= new I(5, 5, Color.BLUE);
    Tetromino t2= new I(5, 5, Color.BLUE);
    t1.rotateLeft(); t1.rotateLeft();
    assertTrue(TestTetrominoOk.equalTetromino(t1, t2));
    t1.rotateLeft(); t1.rotateLeft(); t1.rotateLeft();
    t2.rotateLeft();
    assertTrue(TestTetrominoOk.equalTetromino(t1, t2));
  }
  @Test
  void testMoveLeft() {
    Game g= new Game(){//This is testing technique called 'Mocking'
      @Override 
      public Tetromino nextTetromino(){
        return Game.nextTetromino.get(0).apply(Color.BLUE);
      }
    };
    g.moveLeft();
    g.active().copyOnBoard(g.board());
    assertEquals("""
      |_|_|_|b|b|b|b|_|_|_|
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
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      """,
      g.board().toString());
  }
  @Test
  void testMoveLeftTwice() {
    Game g= new Game(){//This is testing technique called 'Mocking'
      @Override 
      public Tetromino nextTetromino() {
        return Game.nextTetromino.get(0).apply(Color.BLUE);
      }
    };
    g.moveLeft();
    g.moveLeft();
    g.active().copyOnBoard(g.board());
    assertEquals("""
      |_|_|b|b|b|b|_|_|_|_|
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
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      """,
      g.board().toString());
  }

  @Test
  void testLanding() {
    Game g= new Game(){//This is testing technique called 'Mocking'
      @Override 
      public Tetromino nextTetromino() {
        return Game.nextTetromino.get(0).apply(Color.BLUE);
      }
    };
    g.landing();
    g.active().copyOnBoard(g.board());
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
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|b|b|b|b|_|_|
      """,
      g.board().toString());
  }
  
  @Test
  void testLeftLanding() {
    Game g= new Game(){//This is testing technique called 'Mocking'
      @Override 
      public Tetromino nextTetromino(){
        return Game.nextTetromino.get(0).apply(Color.BLUE);
      }
    };
    g.moveLeft();
    g.moveLeft();
    g.landing();
    g.active().copyOnBoard(g.board());
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
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|_|_|_|_|_|_|_|_|
      |_|_|b|b|b|b|_|_|_|_|
      """,
      g.board().toString());
  }

}

package swen221.tetris.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Color;

public class BoardTest {

  
  @Test
  void testClear1() {
    Board b= new Board();
    for(int i= 0; i < 10; i++) {
      for(int j= 0; j < 10; j++) {
        b.write(i, j, Color.BLUE);
      }
    }
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
      |b|b|b|b|b|b|b|b|b|b|
      |b|b|b|b|b|b|b|b|b|b|
      |b|b|b|b|b|b|b|b|b|b|
      |b|b|b|b|b|b|b|b|b|b|
      |b|b|b|b|b|b|b|b|b|b|
      |b|b|b|b|b|b|b|b|b|b|
      |b|b|b|b|b|b|b|b|b|b|
      |b|b|b|b|b|b|b|b|b|b|
      |b|b|b|b|b|b|b|b|b|b|
      |b|b|b|b|b|b|b|b|b|b|
      """,
      b.toString());
    b.clearFullRows();
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
      |_|_|_|_|_|_|_|_|_|_|
      """,
      b.toString());
    }

int round= 0;
Board testBoard(int mod1, int mod2){
  Board b= new Board();
  round = 0;
  Board.rangeY().forEach(y->
    Board.rangeX().forEach(x->{
      round += 1;
      var c= Color.values()[round % mod2 + 1];
      if (round % mod1 != 0) { b.write(x, y, c); }
    }));
  return b;
  }
@Test
void testClear2() {
  Board b= testBoard(13, 3);
  assertEquals("""
    |b|r|b|b|_|b|b|r|b|b|
    |b|_|r|b|b|r|b|b|r|b|
    |r|b|b|r|b|b|r|b|b|r|
    |b|r|b|b|r|b|b|r|_|b|
    |b|b|r|b|b|_|b|b|r|b|
    |r|b|_|r|b|b|r|b|b|r|
    |b|r|b|b|r|b|b|r|b|b|
    |b|b|r|b|b|r|b|b|r|_|
    |r|b|b|r|b|b|_|b|b|r|
    |b|r|b|_|r|b|b|r|b|b|
    |_|b|r|b|b|r|b|b|r|b|
    |r|b|b|r|b|b|r|b|b|r|
    |b|r|b|b|r|b|b|_|b|b|
    |b|b|r|b|_|r|b|b|r|b|
    |r|_|b|r|b|b|r|b|b|r|
    |b|r|b|b|r|b|b|r|b|b|
    |b|b|r|b|b|r|b|b|_|b|
    |r|b|b|r|b|_|r|b|b|r|
    |b|r|_|b|r|b|b|r|b|b|
    |b|b|r|b|b|r|b|b|r|b|
    """,
    b.toString());
  b.clearFullRows();
  assertEquals("""
    |_|_|_|_|_|_|_|_|_|_|
    |_|_|_|_|_|_|_|_|_|_|
    |_|_|_|_|_|_|_|_|_|_|
    |_|_|_|_|_|_|_|_|_|_|
    |_|_|_|_|_|_|_|_|_|_|
    |b|r|b|b|_|b|b|r|b|b|
    |b|_|r|b|b|r|b|b|r|b|
    |b|r|b|b|r|b|b|r|_|b|
    |b|b|r|b|b|_|b|b|r|b|
    |r|b|_|r|b|b|r|b|b|r|
    |b|b|r|b|b|r|b|b|r|_|
    |r|b|b|r|b|b|_|b|b|r|
    |b|r|b|_|r|b|b|r|b|b|
    |_|b|r|b|b|r|b|b|r|b|
    |b|r|b|b|r|b|b|_|b|b|
    |b|b|r|b|_|r|b|b|r|b|
    |r|_|b|r|b|b|r|b|b|r|
    |b|b|r|b|b|r|b|b|_|b|
    |r|b|b|r|b|_|r|b|b|r|
    |b|r|_|b|r|b|b|r|b|b|
    """,
    b.toString());
  }
@Test
void testClear3() {
  Board b= testBoard(14, 4);
  assertEquals("""
    |b|r|b|b|b|_|b|b|b|r|
    |b|_|b|r|b|b|b|r|b|b|
    |b|r|b|b|b|r|b|b|b|r|
    |b|b|b|r|b|b|b|_|b|b|
    |b|r|b|_|b|r|b|b|b|r|
    |b|b|b|r|b|b|b|r|b|b|
    |b|r|b|b|b|r|b|b|b|_|
    |b|b|b|r|b|_|b|r|b|b|
    |b|_|b|b|b|r|b|b|b|r|
    |b|b|b|r|b|b|b|r|b|b|
    |b|r|b|b|b|r|b|_|b|r|
    |b|b|b|_|b|b|b|r|b|b|
    |b|r|b|b|b|r|b|b|b|r|
    |b|b|b|r|b|b|b|r|b|_|
    |b|r|b|b|b|_|b|b|b|r|
    |b|_|b|r|b|b|b|r|b|b|
    |b|r|b|b|b|r|b|b|b|r|
    |b|b|b|r|b|b|b|_|b|b|
    |b|r|b|_|b|r|b|b|b|r|
    |b|b|b|r|b|b|b|r|b|b|
    """,
    b.toString());
  b.clearFullRows();
  assertEquals("""
    |_|_|_|_|_|_|_|_|_|_|
    |_|_|_|_|_|_|_|_|_|_|
    |_|_|_|_|_|_|_|_|_|_|
    |_|_|_|_|_|_|_|_|_|_|
    |_|_|_|_|_|_|_|_|_|_|
    |_|_|_|_|_|_|_|_|_|_|
    |b|r|b|b|b|_|b|b|b|r|
    |b|_|b|r|b|b|b|r|b|b|
    |b|b|b|r|b|b|b|_|b|b|
    |b|r|b|_|b|r|b|b|b|r|
    |b|r|b|b|b|r|b|b|b|_|
    |b|b|b|r|b|_|b|r|b|b|
    |b|_|b|b|b|r|b|b|b|r|
    |b|r|b|b|b|r|b|_|b|r|
    |b|b|b|_|b|b|b|r|b|b|
    |b|b|b|r|b|b|b|r|b|_|
    |b|r|b|b|b|_|b|b|b|r|
    |b|_|b|r|b|b|b|r|b|b|
    |b|b|b|r|b|b|b|_|b|b|
    |b|r|b|_|b|r|b|b|b|r|
    """,
    b.toString());
  }
@Test
void testClear4() {
  Board b= testBoard(15, 5);
  assertEquals("""
    |b|b|b|b|_|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|_|
    |b|b|b|b|_|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|_|
    |b|b|b|b|_|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|_|
    |b|b|b|b|_|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|_|
    |b|b|b|b|_|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|_|
    |b|b|b|b|_|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|_|
    |b|b|b|b|_|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|r|
    """,
    b.toString());
  b.clearFullRows();
  assertEquals("""
    |_|_|_|_|_|_|_|_|_|_|
    |_|_|_|_|_|_|_|_|_|_|
    |_|_|_|_|_|_|_|_|_|_|
    |_|_|_|_|_|_|_|_|_|_|
    |_|_|_|_|_|_|_|_|_|_|
    |_|_|_|_|_|_|_|_|_|_|
    |_|_|_|_|_|_|_|_|_|_|
    |b|b|b|b|_|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|_|
    |b|b|b|b|_|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|_|
    |b|b|b|b|_|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|_|
    |b|b|b|b|_|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|_|
    |b|b|b|b|_|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|_|
    |b|b|b|b|_|b|b|b|b|r|
    |b|b|b|b|r|b|b|b|b|_|
    |b|b|b|b|_|b|b|b|b|r|
    """,
    b.toString());
  }
}
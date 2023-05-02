package swen221.tetris.logic;

/**
 * Color represent cells on the Tetris board.
 * Empty represent the absence of a piece, while
 * the other colors represents the color of such piece.
 * Both a string and an awt.Color representation is provided.
 * */
public enum Color {
  EMPTY("_", java.awt.Color.WHITE), 
  RED("r", java.awt.Color.RED), 
  ORANGE("b", java.awt.Color.ORANGE), 
  YELLOW("b", java.awt.Color.YELLOW), 
  GREEN("b", java.awt.Color.GREEN), 
  BLUE("b", java.awt.Color.BLUE), 
  MAGENTA("b", java.awt.Color.MAGENTA);
  Color(String s, java.awt.Color c) {
    this.s= s;
    this.color= c;
  }

  public final String s;
  public final java.awt.Color color;
}
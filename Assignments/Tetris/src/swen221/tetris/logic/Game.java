package swen221.tetris.logic;

import java.util.List;
import java.util.Random;
import java.util.function.Function;

import swen221.tetris.tetromino.Tetromino;

/**
 * A Game instance represents a running game of Tetris.
 * It takes care of handling the commands from the GUI,
 * to store the map, to check if the map is full (game over)
 * and to create a new Tetromino when needed.
 *
 * If the GUI ask for an invalid command, such request is
 * simply ignored.
 * */
public class Game {
  /**@return the current board*/
  public Board board() { return b; }

  /**@return the current Tetromino*/
  public Tetromino active() { return active; }

  /**@return a randomized color*/
  Color newColor(){
    createdNum += 1;
    return Color.values()[1 + createdNum % (Color.values().length - 1)];
  }

  /**the current board*/
  private Board b= new Board();

  /**a Random object needed to generate random new tetrominos*/
  final Random r= new Random();

  /**the number of created tetrominos, used to iterate over the colors*/
  int createdNum= 0;

  /**True if the active tetromino is
   * valid and does not overlap with the board
   * */
  public boolean activeValid() {
    return active.valid() && !active.overlap(b);
  }

  /**handles down movements. The movement is invalid if
   * it would make the tetromino invalid or overlapping with
   * other cells on the board.
   * In such cases, the action is reversed by calling moveUp()
   * */
  public void moveDown() {
    active.moveDown();
    if (!activeValid()) { active.moveUp(); }
  }

  /**see {@link Game.moveDown()}*/
  public void moveLeft() {//TODO: fix here
    active.moveLeft();
    if (!activeValid()) {
      active.moveRight();
    }
  }
  /**see {@link Game.moveDown()}*/
  public void moveRight() {
    active.moveRight();
    if (!activeValid()) { active.moveLeft(); }
  }
  /**see {@link Game.moveDown()}*/
  public void rotateLeft() {
    active.rotateLeft();
    if (!activeValid()) { active.rotateRight(); }
  }
  /**see {@link Game.moveDown()}*/
  public void rotateRight() {
    active.rotateRight();
    if (!activeValid()) { active.rotateLeft(); }
  }


  /**This operation moves down until it is possible
   * That is, it stops calling moveDown over and over again
   * when the position of the active tetromino stops changing
   * */
  public void landing() {
    while (activeValid()) {
      active.moveDown();
    }
    active.moveUp();
  }//TODO: complete this code

  /**@return a new Tetromino chosen at random*/
  public Tetromino nextTetromino() {
    try { return nextTetromino.get(r.nextInt(7)).apply(newColor()); }
    catch (Error e) { return nextTetromino(); }
    //This code is needed to support an incomplete assignment.
    //Some tetromino will not be able to be created:
    //at the start only I T and S will be available.
  }

  /**map numbers into tetromino instances*/
  public static final List<Function<Color, Tetromino>> nextTetromino= List.of(
    c-> new swen221.tetris.tetromino.I(5, 19, c),
    c-> new swen221.tetris.tetromino.T(5, 19, c),
    c-> new swen221.tetris.tetromino.S(5, 18, c),
    c-> new swen221.tetris.tetromino.O(5, 18, c),
    c-> new swen221.tetris.tetromino.J(5, 19, c),
    c-> new swen221.tetris.tetromino.L(5, 19, c),
    c-> new swen221.tetris.tetromino.Z(5, 18, c)
    );

  /**In each moment, there is exactly one tetromino moving on the board*/
  private Tetromino active= nextTetromino();


  /**
   * When the Tetromino touches any other cell on the board:
   * - it is copied on the board and (possibly) full rows are cleared.
   * - a new Tetromino is added on the board
   * - is such Tetromino compenetrates any other cell on the board,
   *   the board is restated.
   * */
  public void commitMove() {
    if (!active.touch(b)) { return; }
    active.copyOnBoard(b);
    b.clearFullRows();
    active = nextTetromino();
    if (active.overlap(b)) { b = new Board(); }
  }
}
package swen221.tetris.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

import javax.swing.*;

import swen221.tetris.logic.Board;
import swen221.tetris.logic.Color;
import swen221.tetris.logic.Game;


/**
 * Tetris Define a Gui allowing to play.
 * This code is quite advanced and uses features that you will learn in the later
 * part of Swen221; do no worry if there are certain parts that you can not understand.
 *
 * */
@SuppressWarnings("serial")
public class Tetris extends JFrame {
  /**
   * Key bindings, as a map from characters to actions
   * */
  public static final Map<Character, Consumer<Game>> keys= Map.of(
    '7', Game::rotateLeft,
    '9', Game::rotateRight,
    '4', Game::moveLeft,
    '6', Game::moveRight,
    '5', Game::moveDown,
    ' ', Game::landing
    );

  public static void main(String[] args) {
    ClassLoader.getSystemClassLoader()
      .setDefaultAssertionStatus(true);
    SwingUtilities.invokeLater(Tetris::makeGui);
  }  
  private static class Top extends JPanel {
    final Game g= new Game();
    final WindowAdapter winA= new WindowAdapter(){
      public void windowOpened(WindowEvent e){ requestFocus(); }
    };
    final KeyAdapter keyA= new KeyAdapter(){
      public void keyTyped(KeyEvent e){ handleKey(e); }
    };
    void handleKey(KeyEvent e) {
      Optional.ofNullable(keys.get(e.getKeyChar()))
        .ifPresent(c->{
          c.accept(g);
          g.commitMove();
          revalidate();
        });
    }
    Top() {
      setLayout(new GridLayout(20, 10, 1, 1));
      setFocusable(true);
      addKeyListener(keyA);
      Board.reverseRangeY().forEach(row->
        Board.rangeX().forEach(col->
          add(cell(col, row, g))
        ));
    }
  }
  private static void makeGui() {
    Top top= new Top();
    Tetris t= new Tetris();
    t.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    t.getRootPane().setLayout(new FlowLayout());
    t.getRootPane().add(top);
    t.addWindowListener(top.winA);
    t.pack();
    t.setVisible(true);
    //to make the cells update their color
    top.revalidate();
  }
  /**
   * Create cells in the Tetris visualization. They use the Game
   * to chose their color.
   * */
  public static JPanel cell(int col, int row, Game g) {
    return new JPanel() {
      @Override public void validate() {
        setBackground(g.board()
          .read(col, row)
          .orElse(Color.EMPTY)
          .color);
        Board.rangeT()
          .filter(i-> g.active().x(i) == col && g.active().y(i) == row)
          .forEach(i-> setBackground(g.active().color().color));
        super.validate();
      }
      @Override public Dimension getPreferredSize() {
        return new Dimension(30, 30);
      }
    };
  }
}
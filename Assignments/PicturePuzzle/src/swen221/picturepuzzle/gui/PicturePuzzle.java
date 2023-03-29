// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a SWEN221 assignment.
// You may not distribute it in any other way without permission.
package swen221.picturepuzzle.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import swen221.picturepuzzle.model.Game;

/**
 * PicturePuzzle defines a GUI allowing to play.
 *
 * @author betty
 *
 */
@SuppressWarnings("serial")
public class PicturePuzzle extends JFrame {
	/**
	 * Panel holding items of the GUI.
	 */
	private static final JPanel panel = new JPanel();
	/**
	 * Canvas where tiles are drawn.
	 */
	private static JPanel displayCanvas = new JPanel();
	/**
	 * Default number of cells
	 */
	private static int numCells = 3;
	/**
	 * Game instance.
	 */
	private static Game game;
	/**
	 * Image file to use for the game.
	 */
	private static File image;

	/**
	 * Main method used to start a PicturePuzzle game.
	 *
	 * @param args Command-line arguments are ignored by this method.
	 */
	public static void main(String[] args) {
		final String[] sizeString= {"2X2", "3X3", "4X4", "5X5", "6X6"};
		final JComboBox<String> num = new JComboBox<>(sizeString);
		final JButton OpenButton = new JButton("Open");
		final JButton StartButton = new JButton("Start");
		//
		SwingUtilities.invokeLater(() -> {
			PicturePuzzle p = new PicturePuzzle();
			p.setTitle("Picture Puzzle");
			p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			p.setResizable(false);
			panel.setLayout(new FlowLayout());
			panel.add(new JLabel("Num of cells:"));
			panel.add(num);
			panel.add(OpenButton);
			panel.add(StartButton);
			p.getContentPane().add(panel, BorderLayout.NORTH);

			p.pack();
			p.setLocationRelativeTo(null);
			p.setVisible(true);
			//
			num.setSelectedIndex(1);
			// Add event handlers
			num.addActionListener((ActionEvent e) -> {
				setPuzzleDimensions(e);
			});

			OpenButton.addActionListener((ActionEvent e) -> {
				openImageFile(p);
			});

			StartButton.addActionListener((ActionEvent e) -> {
				startPicturePuzzle(p);
			});
		});

	}

	/**
	 * Set the dimensions of the puzzle.
	 *
	 * @param e Event containing key information about what the dimension should be.
	 */
	private static void setPuzzleDimensions(ActionEvent e) {
		String num = (String) ((JComboBox<?>) e.getSource()).getSelectedItem();
		numCells = Character.getNumericValue(num.charAt(0));
	}

	/**
	 * Start a new game of picture puzzle!
	 *
	 * @param p The PicturePuzzle object to use.
	 */
	private static void startPicturePuzzle(PicturePuzzle p) {
		p.getContentPane().removeAll();
		p.getContentPane().add(panel, BorderLayout.NORTH);
		game.start();
		displayCanvas = new GamePanel(game);
		displayCanvas.revalidate();
		p.getContentPane().add(displayCanvas, BorderLayout.CENTER);
		// Show the original image
		JLabel label = new JLabel();
		try {
			label.setIcon(new ImageIcon(ImageIO.read(image)));
			// Show the original image
			p.pack();
			p.setVisible(true);
		} catch (IOException e1) {
			// Indicates a problem loading the image
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}

	/**
	 * Open a given image file and pass it to the given instance of PicturePuzzle.
	 *
	 * @param p PicturePuzzle game where this image is being loaded.
	 */
	private static void openImageFile(PicturePuzzle p) {
		try {
			JFileChooser fileChooser = new JFileChooser();
			FileFilter filter = new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes());
			fileChooser.setFileFilter(filter);
			File pwd = new File(System.getProperty("user.dir"));
			fileChooser.setCurrentDirectory(pwd);

			if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				image = fileChooser.getSelectedFile();
				p.getContentPane().removeAll();
				p.getContentPane().add(panel, BorderLayout.NORTH);
				game = new Game(image, numCells);
				JLabel label = new JLabel();
				label.setIcon(new ImageIcon(ImageIO.read(image)));
				displayCanvas.removeAll();
				displayCanvas.add(label);
				displayCanvas.revalidate();
				p.getContentPane().add(displayCanvas, BorderLayout.CENTER);
				p.pack();
				p.setVisible(true);
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

}

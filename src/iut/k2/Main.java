package iut.k2;

import iut.k2.gui.Game;
import iut.k2.gui.Window;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Test");
		Window fen = new Window(700, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(fen);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
	}
	
}

package iut.k2;

import java.util.Random;

import iut.k2.gui.Window;
import javax.swing.JFrame;

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

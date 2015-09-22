package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Test");
		Fenetre fen = new Fenetre(500, 700);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(fen);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
	}
	
}

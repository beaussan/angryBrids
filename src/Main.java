import javax.swing.JFrame;

import main.Fenetre;
import main.Jeu;

public class Main {

	public static void main(String[] args) {
		JFrame f = new JFrame("Test");
		Jeu j = new Jeu();
		Fenetre fen = new Fenetre(700, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(fen);
		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		
	}
	
}

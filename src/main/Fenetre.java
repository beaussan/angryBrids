package main;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Fenetre extends JPanel{

	public Fenetre(int largeur, int hauteur){
		setPreferredSize(new Dimension(largeur, hauteur));
	}
}

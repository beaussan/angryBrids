package iut.k2.gui;

import iut.k2.data.Pecker;
import iut.k2.physics.Coordinate2D;

import javax.swing.*;

import java.awt.*;

public class Window extends JPanel {
	
	private Game game;

	public Window(int largeur, int hauteur) {
		game= new Game();
		setPreferredSize(new Dimension(largeur, hauteur));
	}
	
    public void paint(Graphics g) {
		Pecker pek = new Pecker(new Coordinate2D(10, 450));
        g.drawOval ((int)pek.getCoordinate().getX(), (int)pek.getCoordinate().getY(), 20, 20);  
		g.setColor(Color.GREEN);
		g.fillOval((int)pek.getCoordinate().getX(), (int)pek.getCoordinate().getY(), 20, 20);
	    int[] x = new int[]{10,200};
	    int[] y = new int[]{10,300};
	    g.drawPolygon (x, y, x.length); 
        
        
        add(pek);
	   }
	
	
}

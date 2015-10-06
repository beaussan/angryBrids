package iut.k2.gui;

import iut.k2.data.Obstacle;
import iut.k2.data.Pecker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.List;

import javax.swing.JPanel;

public class Window extends JPanel {
	
	private Game game;

	public Window(int largeur, int hauteur) {
		game= new Game();
		setPreferredSize(new Dimension(largeur, hauteur));
		setBackground(Color.BLUE);
	}
	
    public void paint(Graphics g) {

    	//Dessin de l'oiseau
    	Pecker p = game.getPecker();
        g.drawOval ((int)p.getCoordinate().getX(),(int)p.getCoordinate().getY(), 20, 20);  
		g.setColor(Color.GREEN);
		g.fillOval((int)p.getCoordinate().getX(),(int)p.getCoordinate().getY(), 20, 20);
		
    	//Dessin des obstacles
    	for(Obstacle o : game.getListObstacles()){
    		g.drawOval ((int)o.getCoordinate().getX(),(int)o.getCoordinate().getY(), 20, 20);  
    		g.setColor(Color.BLUE);
    		g.fillOval((int)o.getCoordinate().getX(),(int)o.getCoordinate().getY(), 20, 20);
    	}
	}
	
	
}

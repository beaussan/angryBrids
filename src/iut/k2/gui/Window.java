package iut.k2.gui;

import iut.k2.data.Obstacle;
import iut.k2.data.Pecker;

import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {
	
	private Game game;

	public Window(int largeur, int hauteur) {
		game= new Game();
		setPreferredSize(new Dimension(largeur, hauteur));
		setBackground(Color.BLUE);
	}

	/**
	 * {@inheritDoc}
	 */
	public void paint(Graphics g) {
		//TODO "Painting the window while changing the coordinate"
		super.paint(g);
		double max = 100;

    	//Dessin des obstacles
		for (Obstacle o : game.getListObstacles()) {
			g.drawOval((int) o.getCoordinate().getX(), (int) o.getCoordinate().getY(), 20, 20);
			g.setColor(Color.BLUE);
			g.fillOval((int) o.getCoordinate().getX(), (int) o.getCoordinate().getY(), 20, 20);
		}

    	for(double i = 0; i < max; i += 1){
			update(i);
			System.out.println(game.getPecker().getCoordinate());
	    	//Dessin de l'oiseau
	    	Pecker p = game.getPecker();
			g.drawOval((int) p.getCoordinate().getX(), (int) p.getCoordinate().getY(), 20, 20);
			g.setColor(Color.GREEN);
			g.fillOval((int)p.getCoordinate().getX(),(int)p.getCoordinate().getY(), 20, 20);

			update(i);
		}

    	g.setColor(Color.WHITE);
	}

	public void update(double t) {
		game.update(t);
		repaint();
	}
	
	
}

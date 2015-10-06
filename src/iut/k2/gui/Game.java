package iut.k2.gui;

import iut.k2.data.Obstacle;
import iut.k2.data.Pecker;
import iut.k2.physics.Coordinate2D;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Pecker pecker;
	private List<Obstacle> listeObstacles;
	
	/**
	 * Initialize the elements on the window 
	 */
	public Game(){
		pecker = new Pecker(new Coordinate2D(20, 20));
		listeObstacles = new ArrayList<Obstacle>();
		int nbObstacle = 7;
		for(int i = 0; i < nbObstacle; i++){
			listeObstacles.add(new Obstacle(null));
		}
		
	}

	public Pecker getPecker() {
		return pecker;
	}

	public List<Obstacle> getListObstacles() {
		return listeObstacles;
	}
	
	/**
	 * Updates the position of the elements on the window
	 */
	public void update(){
		//TODO 
		pecker.updateBec(0);
	}
	
	/**
	 * Launch the pecker into the air
	 */
	public void launch(){
		//TODO
		int x = (int)pecker.getCoordinate().getX();
		for(int i = x ; i < x ; i++){
			
		}
	}
	
}

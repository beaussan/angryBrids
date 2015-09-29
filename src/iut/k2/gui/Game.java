package iut.k2.gui;

import iut.k2.data.Obstacle;
import iut.k2.data.Pecker;
import iut.k2.physics.Coordinate2D;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private Pecker pecker;
	private List<Obstacle> listeObstacles;
	
	public Game(){
		pecker = new Pecker(new Coordinate2D(20, 20));
		listeObstacles = new ArrayList<Obstacle>();
	}

	public Pecker getPecker() {
		return pecker;
	}

	public List<Obstacle> getListeObstacles() {
		return listeObstacles;
	}
	
	
}

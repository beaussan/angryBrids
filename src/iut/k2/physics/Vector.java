package iut.k2.physics;

/**
 * Contains the methods related to vectorial movements
 * @author dhoopb
 *
 */
public class Vector {
	
	/**	Vectorial movement */
	private int x;
	private int y;
	
	public Vector(int xDep, int yDep){
		x = xDep;
		y = yDep;
	}
	
	public Coordinate2D move(Coordinate2D coord){
		Coordinate2D cNew = new Coordinate2D(coord.getX()+x, coord.getY()+y);
		coord.add(cNew);
		return coord;
	}
	
	/**
	 * Update the vector with the result of the pametrical function
	 */
	public void update(){
		
	}
}

package iut.k2.data;


import iut.k2.physics.Coordinate2D;

public abstract class Entity {

    private Coordinate2D c;
    private double positionBec;

    public Entity(Coordinate2D c) {
        this.c = c;
    }

    public void move(int x, int y) {
        int tmpX = getCoordinate().getX();
        int tmpY = getCoordinate().getY();

        setCoordinate(new Coordinate2D(tmpX + x, tmpY + y));
    }

    public Coordinate2D getCoordinate() {
        return c;
    }

    public void setCoordinate(Coordinate2D c) {
        this.c = c;
    }

}

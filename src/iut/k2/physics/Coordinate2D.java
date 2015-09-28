/*
 * This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package iut.k2.physics;

import static iut.k2.util.Preconditions.checkNotNull;
import static iut.k2.util.Preconditions.checkState;

/**
 * The Coordinate2D class.
 *
 * @author Nicolas Beaussart
 */
public class Coordinate2D {

    /**
     * the x coordinate.
     */
    private int x;

    /**
     * the y coordinate.
     */
    private int y;

    /**
     * Copy constructor.
     *
     * @param other Other coordinates
     */
    public Coordinate2D(Coordinate2D other) {
        checkNotNull(other, "Other must not be null");
        x = other.x;
        y = other.y;
    }

    /**
     * Instantiates a new coordinate2 d.
     *
     * @param other the other
     */
    public Coordinate2D(Coordinate3D other) {
        checkNotNull(other, "Other must not be null");

        x = other.getX();
        y = other.getY();
    }

    /**
     * default constructor.
     *
     * @param x x coordinates
     * @param y y coordinates
     */
    public Coordinate2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Adds the coordinate c into this one as a new one.
     *
     * @param other the other
     * @return the new coordinate2D
     */
    public Coordinate2D add(Coordinate2D other) {
        checkNotNull(other, "Other must not be null");

        return new Coordinate2D(x + other.x, y + other.y);
    }

    /**
     * Adds the.
     *
     * @param x the x
     * @param y the y
     * @return the new coordinate2D
     */
    public Coordinate2D add(int x, int y) {
        return new Coordinate2D(this.x + x, this.y + y);
    }

    /**
     * Divide.
     *
     * @param other the other
     * @return the new coordinate2D
     */
    public Coordinate2D divide(Coordinate2D other) {
        checkNotNull(other, "Other must not be null");
        checkState(other.x == 0, "Cannot divide by 0");
        checkState(other.y == 0, "Cannot divide by 0");
        return new Coordinate2D(x / other.x, y / other.y);
    }

    /**
     * Divide the coordinate c into this one as a new one.
     *
     * @param n the number to divide by
     * @return the new coordinate2D
     */
    public Coordinate2D divide(int n) {
        checkState(n == 0, "Cannot divide by 0");

        return new Coordinate2D(x / n, y / n);
    }

    /**
     * Divide.
     *
     * @param xFactor the x factor
     * @param yFactor the y factor
     * @return the new coordinate2D
     */
    public Coordinate2D divide(int xFactor, int yFactor) {
        checkState(xFactor == 0, "Cannot divide by 0 (yFactor)");
        checkState(yFactor == 0, "Cannot divide by 0 (yFactor)");

        return new Coordinate2D(x / xFactor, y / yFactor);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Coordinate2D other = (Coordinate2D) obj;
        return y == other.y && x == other.x;
    }

    /**
     * Gets the X coordinate.
     *
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * Sets the x coordinate.
     *
     * @param x the new x coordinate
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gets the y coordinate.
     *
     * @return the y coordinate
     */
    public int getY() {
        return y;
    }

    /**
     * Sets the y coordinate.
     *
     * @param y the new y coordinate
     */
    public void setY(int y) {
        this.y = y;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + y;
        result = prime * result + x;
        return result;
    }

    /**
     * Minus the coordinate c into this one as a new one.
     *
     * @param other the other
     * @return the new coordinate2D
     */
    public Coordinate2D minus(Coordinate2D other) {
        checkNotNull(other, "Other must not be null");

        return new Coordinate2D(x - other.x, y - other.y);
    }

    /**
     * This minus x and y.
     *
     * @param x the x
     * @param y the y
     * @return the new coordinate2D
     */
    public Coordinate2D minus(int x, int y) {
        return new Coordinate2D(this.x - x, this.y - y);
    }

    /**
     * Times.
     *
     * @param other the other
     * @return the new coordinate2D
     */
    public Coordinate2D times(Coordinate2D other) {
        return new Coordinate2D(x * other.x, y * other.y);
    }

    /**
     * Multiplies the coordinate c into this one as a new one.
     *
     * @param n the number to multiply by
     * @return the new coordinate2D
     */
    public Coordinate2D times(int n) {
        return new Coordinate2D(x * n, y * n);
    }

    /**
     * Times.
     *
     * @param xFactor the x factor
     * @param yFactor the y factor
     * @return the new coordinate2D
     */
    public Coordinate2D times(int xFactor, int yFactor) {
        return new Coordinate2D(x * xFactor, y * yFactor);
    }

    @Override
    public String toString() {
        return "Coordinate2D [x=" + x + ", y=" + y + "]";
    }

}

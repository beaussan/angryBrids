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
 * The Coordinate3D Class.
 *
 * @author Nicolas Beaussart
 */
public class Coordinate3D {

    /**
     * the x coordinate.
     */
    private double x;

    /**
     * the y coordinate.
     */
    private double y;

    /**
     * The z coordinate.
     */
    private double z;

    /**
     * default constructor.
     *
     * @param coord2D the coord2 d
     */
    public Coordinate3D(Coordinate2D coord2D) {
        checkNotNull(coord2D, "Other must not be null");
        x = coord2D.getX();
        y = coord2D.getY();
        z = 0;
    }

    /**
     * default constructor.
     *
     * @param coord2D the coord2 d
     * @param z       the z
     */
    public Coordinate3D(Coordinate2D coord2D, double z) {
        checkNotNull(coord2D, "Other must not be null");
        x = coord2D.getX();
        y = coord2D.getY();
        this.z = z;
    }

    /**
     * Copy constructor.
     *
     * @param other Other coordinates
     */
    public Coordinate3D(Coordinate3D other) {

        checkNotNull(other, "Other must not be null");
        x = other.x;
        y = other.y;
        z = other.z;
    }

    /**
     * default constructor.
     *
     * @param x x coordinates
     * @param y y coordinates
     * @param z the z
     */
    public Coordinate3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Adds the coordinate c doubleo this one as a new one.
     *
     * @param other the other
     * @return the new coordinate2D
     */
    public Coordinate3D add(Coordinate3D other) {

        checkNotNull(other, "Other must not be null");
        return new Coordinate3D(x + other.x, y + other.y, z + other.z);
    }

    /**
     * Adds the.
     *
     * @param x the x
     * @param y the y
     * @param z the z
     * @return the new coordinate2D
     */
    public Coordinate3D add(double x, double y, double z) {
        return new Coordinate3D(this.x + x, this.y + y, this.z + z);
    }

    /**
     * Divide.
     *
     * @param other the other
     * @return the new coordinate2D
     */
    public Coordinate3D divide(Coordinate3D other) {

        checkNotNull(other, "Other must not be null");
        checkState(other.x == 0, "Cannot divide by 0");
        checkState(other.y == 0, "Cannot divide by 0");
        checkState(other.z == 0, "Cannot divide by 0");
        return new Coordinate3D(x / other.x, y / other.y, z / other.z);
    }

    /**
     * Divide the coordinate c doubleo this one as a new one.
     *
     * @param n the number to divide by
     * @return the new coordinate2D
     */
    public Coordinate3D divide(double n) {
        checkState(n == 0, "Cannot divide by 0");

        return new Coordinate3D(x / n, y / n, z / n);
    }

    /**
     * Divide.
     *
     * @param xFactor the x factor
     * @param yFactor the y factor
     * @param zFactor the z factor
     * @return the new coordinate2D
     */
    public Coordinate3D divide(double xFactor, double yFactor, double zFactor) {
        checkState(xFactor == 0, "Cannot divide by 0 (yFactor)");
        checkState(yFactor == 0, "Cannot divide by 0 (yFactor)");
        checkState(zFactor == 0, "Cannot divide by 0 (zFactor)");
        return new Coordinate3D(x / xFactor, y / yFactor, z / zFactor);
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
        Coordinate3D other = (Coordinate3D) obj;
        return x == other.x && y == other.y && z == other.z;
    }

    /**
     * Gets the X coordinate.
     *
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * Sets the x coordinate.
     *
     * @param x the new x coordinate
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Gets the y coordinate.
     *
     * @return the y coordinate
     */
    public double getY() {
        return y;
    }

    /**
     * Sets the y coordinate.
     *
     * @param y the new y coordinate
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Gets the z.
     *
     * @return the z
     */
    public double getZ() {
        return z;
    }

    /**
     * Sets the z.
     *
     * @param z the new z
     */
    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    /**
     * Minus the coordinate c doubleo this one as a new one.
     *
     * @param other the other
     * @return the new coordinate2D
     */
    public Coordinate3D minus(Coordinate3D other) {
        checkNotNull(other, "Other must not be null");

        return new Coordinate3D(x - other.x, y - other.y, z - other.z);
    }

    /**
     * This minus x and y.
     *
     * @param x the x
     * @param y the y
     * @param z the z
     * @return the new coordinate2D
     */
    public Coordinate3D minus(double x, double y, double z) {
        return new Coordinate3D(this.x - x, this.y - y, this.z - z);
    }

    /**
     * Times.
     *
     * @param other the other
     * @return the new coordinate2D
     */
    public Coordinate3D times(Coordinate3D other) {
        return new Coordinate3D(x * other.x, y * other.y, z * other.z);
    }

    /**
     * Multiplies the coordinate c doubleo this one as a new one.
     *
     * @param n the number to multiply by
     * @return the new coordinate2D
     */
    public Coordinate3D times(double n) {
        return new Coordinate3D(x * n, y * n, z * n);
    }

    /**
     * Times.
     *
     * @param xFactor the x factor
     * @param yFactor the y factor
     * @param zFactor the z factor
     * @return the new coordinate2D
     */
    public Coordinate3D times(double xFactor, double yFactor, double zFactor) {
        return new Coordinate3D(x * xFactor, y * yFactor, z * zFactor);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Coordinate3D [x=" + x + ", y=" + y + ", z=" + z + "]";
    }

}

package iut.k2.gui.renderfunc;

import iut.k2.physics.Coordinate2D;
import iut.k2.physics.functions.ParamCurve;

import java.awt.*;
import java.util.Timer;

public class Drawing {

	public final int NB_STEPS = 300;
	private final int SIZE_BALL = 8;
	private double x0, y0;
	private double xScale, yScale;
	private int currMaxPoints = 1;
	private Timer timer;

    public Drawing(Dimension area, ParamCurve curve) {
        defineCoords(area, curve);
    }

    public Drawing(Dimension area, ParamCurve... curve) {
        defineCoords(area, curve);
    }

    public void defineCoords(Dimension dim, ParamCurve curve) {
        // recherche des extremas de la courbe
        double xMin = Double.MAX_VALUE;
        double xMax = Double.MIN_VALUE;
        double yMin = Double.MAX_VALUE;
        double yMax = Double.MIN_VALUE;
        double dt = (curve.getTMax() - curve.getTMin()) / NB_STEPS;
        for (double t = curve.getTMin(); t <= curve.getTMax(); t += dt) {
            if (curve.x(t) < xMin) xMin = curve.x(t);
            if (curve.x(t) > xMax) xMax = curve.x(t);
            if (curve.y(t) < yMin) yMin = curve.y(t);
            if (curve.y(t) > yMax) yMax = curve.y(t);
        }
        // calcul du syst�me de coordonn�es: origine et �chelle
        xScale = (dim.width - 1) / (xMax - xMin);
        yScale = (dim.height - 1) / -(yMax - yMin);
        x0 = -xScale * xMin;
        y0 = -yScale * yMax;
    }

    public void defineCoords(Dimension dim, ParamCurve... curves) {
        // recherche des extremas de la courbe
        double xMin = Double.MAX_VALUE;
        double xMax = Double.MIN_VALUE;
        double yMin = Double.MAX_VALUE;
        double yMax = Double.MIN_VALUE;
        for (ParamCurve curve : curves) {
            double dt = (curve.getTMax() - curve.getTMin()) / NB_STEPS;
            for (double t = curve.getTMin(); t <= curve.getTMax(); t += dt) {
                if (curve.x(t) < xMin) xMin = curve.x(t);
                if (curve.x(t) > xMax) xMax = curve.x(t);
                if (curve.y(t) < yMin) yMin = curve.y(t);
                if (curve.y(t) > yMax) yMax = curve.y(t);
            }
        }

        // calcul du syst�me de coordonn�es: origine et �chelle
        xScale = (dim.width - 1) / (xMax - xMin);
        yScale = (dim.height - 1) / -(yMax - yMin);
        x0 = -xScale * xMin;
        y0 = -yScale * yMax;
    }

    public void drawCurve(Graphics g, ParamCurve curve) {
        double t = curve.getTMin();
        double dt = (curve.getTMax() - curve.getTMin()) / NB_STEPS;
        Coordinate2D pt1 = new Coordinate2D(0, 0);
        Coordinate2D pt2 = new Coordinate2D(x(curve.x(t)), y(curve.y(t)));
        int curr = 0;
        while (t <= curve.getTMax() && curr <= currMaxPoints) {
            pt1 = pt2;
            pt2 = new Coordinate2D(x(curve.x(t)), y(curve.y(t)));
            g.fillOval(round(pt1.getX()) - (SIZE_BALL / 2), round(pt1.getY()) - (SIZE_BALL / 2), SIZE_BALL, SIZE_BALL);
            //g.drawLine(pt1.x, pt1.y, pt2.x, pt2.y);
            t += dt;
            curr++;
        }
        pt2 = new Coordinate2D(x(curve.x(t)), y(curve.y(t)));

        DrawBird.drawBird(g, pt1.getX(), pt1.getY(), pt2.getX(), pt2.getY());

    }

    public void drawCurve(Graphics g, ParamCurve curve, Color color) {
        double t = curve.getTMin();
        double dt = (curve.getTMax() - curve.getTMin()) / NB_STEPS;
        Coordinate2D pt1 = new Coordinate2D(0, 0);
        Coordinate2D pt2 = new Coordinate2D(x(curve.x(t)), y(curve.y(t)));
        int curr = 0;
        Color oldColor = g.getColor();
        g.setColor(color);
        while (t <= curve.getTMax() && curr <= currMaxPoints) {
            pt1 = pt2;
            pt2 = new Coordinate2D(x(curve.x(t)), y(curve.y(t)));
            g.fillOval(round(pt1.getX()) - (SIZE_BALL / 2), round(pt1.getY()) - (SIZE_BALL / 2), SIZE_BALL, SIZE_BALL);
            t += dt;
            curr++;
        }
        pt2 = new Coordinate2D(x(curve.x(t)), y(curve.y(t)));
        g.setColor(oldColor);
        DrawBird.drawBird(g, pt1.getX(), pt1.getY(), pt2.getX(), pt2.getY());

    }

    /**
     * Getter for property 'currMaxPoints'.
     *
     * @return Value for property 'currMaxPoints'.
     */
    public int getCurrMaxPoints() {
        return currMaxPoints;
    }

    /**
     * Setter for property 'currMaxPoints'.
     *
     * @param currMaxPoints Value to set for property 'currMaxPoints'.
     */
    public void setCurrMaxPoints(int currMaxPoints) {
        this.currMaxPoints = currMaxPoints;
    }

    public int round(double z) {
        return (int) Math.round(z);
    }

	private double x(double z) {
		return x0 + xScale * z;
	}

	private double y(double z) {
		return y0 + yScale * z;
	}

}
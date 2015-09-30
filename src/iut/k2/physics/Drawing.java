package iut.k2.physics;

import java.awt.*;

public class Drawing {

	private double x0, y0;
	private double xScale, yScale;

	private final int NB_STEPS = 600;

	public Drawing(Dimension area, ParamCurve curve) {
		defineCoords(area, curve);
	}

	private void defineCoords(Dimension dim, ParamCurve curve) {
		// recherche des extremas de la courbe
		double xMin = Double.MAX_VALUE;
		double xMax = Double.MIN_VALUE;
		double yMin = Double.MAX_VALUE;
		double yMax = Double.MIN_VALUE;
		double dt = (curve.tMax - curve.tMin) / NB_STEPS;
		for (double t = curve.tMin; t <= curve.tMax; t += dt) {
			if (curve.x(t) < xMin)
				xMin = curve.x(t);
			if (curve.x(t) > xMax)
				xMax = curve.x(t);
			if (curve.y(t) < yMin)
				yMin = curve.y(t);
			if (curve.y(t) > yMax)
				yMax = curve.y(t);
		}
		// calcul du système de coordonnées: origine et échelle
		xScale = (dim.width - 1) / (xMax - xMin);
		yScale = (dim.height - 1) / -(yMax - yMin);
		x0 = -xScale * xMin;
		y0 = -yScale * yMax;
	}

	public void drawCurve(Graphics g, ParamCurve curve) {
		double t = curve.tMin;
		double dt = (curve.tMax - curve.tMin) / NB_STEPS;
		Point pt1;
		Point pt2 = new Point(x(curve.x(t)), y(curve.y(t)));
		while (t <= curve.tMax) {
			pt1 = pt2;
			pt2 = new Point(x(curve.x(t)), y(curve.y(t)));
			g.drawLine(pt1.x, pt1.y, pt2.x, pt2.y);
			t += dt;
		}
	}

	private int x(double z) {
		return (int) Math.round(x0 + xScale * z);
	}

	private int y(double z) {
		return (int) Math.round(y0 + yScale * z);
	}

}
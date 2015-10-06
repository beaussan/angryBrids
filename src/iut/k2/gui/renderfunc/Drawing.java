package iut.k2.gui.renderfunc;

import iut.k2.physics.functions.ParamCurve;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class Drawing {

	public final int NB_STEPS = 300;
	private final int SIZE_BALL = 8;
	private final double TIMER_DELLAY = 0.5;
	private double x0, y0;
	private double xScale, yScale;
	private int currMaxPoints = 1;
	private Timer timer;

	public Drawing(Dimension area, ParamCurve curve) {
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

		if (timer != null) {
			timer.purge();
			timer.cancel();
			currMaxPoints = 1;
		}

		timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				currMaxPoints++;
			}
		}, (long) TIMER_DELLAY, (long) (TIMER_DELLAY * NB_STEPS + 1));


	}

	public void drawCurve(Graphics g, ParamCurve curve) {
		double t = curve.getTMin();
		double dt = (curve.getTMax() - curve.getTMin()) / NB_STEPS;
		Point pt1 = new Point(0, 0);
		Point pt2 = new Point(x(curve.x(t)), y(curve.y(t)));
		int curr = 0;
		while (t <= curve.getTMax() && curr <= currMaxPoints) {
			pt1 = pt2;
			pt2 = new Point(x(curve.x(t)), y(curve.y(t)));
			g.fillOval(pt1.x - (SIZE_BALL / 2), pt1.y - (SIZE_BALL / 2), SIZE_BALL, SIZE_BALL);
			//g.drawLine(pt1.x, pt1.y, pt2.x, pt2.y);
			t += dt;
			curr++;
		}
		pt2 = new Point(x(curve.x(t)), y(curve.y(t)));

		DrawBird.drawBird(g, pt1.x, pt1.y, x(curve.xPrim(t)), y(curve.yPrim(t)));

	}

	public int getCurrMaxPoints() {
		return currMaxPoints;
	}

	public void setCurrMaxPoints(int currMaxPoints) {
		this.currMaxPoints = currMaxPoints;
	}


	private int x(double z) {
		return (int) Math.round(x0 + xScale * z);
	}

	private int y(double z) {
		return (int) Math.round(y0 + yScale * z);
	}

}
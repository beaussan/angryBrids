package iut.k2.gui.renderfunc;

import iut.k2.physics.Coordinate2D;
import iut.k2.util.Tools;

import java.awt.*;
import java.awt.geom.Ellipse2D;


/**
 * Created by PROPRIETAIRE on 29/09/2015.
 */
public class DrawBird {

    public static final int SIZE_BIRD = 20;
    public static final int SIEE_ARROW = 30;
    public static final int SIZE_SIDE = 10;
    public static final Color COLOR_ARROW = Color.ORANGE;
    public static final Color COLOR_BODY = Color.RED;
    public static boolean IS_SKELETON = false;

    public static Ellipse2D drawBird(Graphics g, Coordinate2D cordsFrom, Coordinate2D cordsTo) {
        return drawBird(g, cordsFrom, cordsTo, COLOR_BODY, COLOR_ARROW);
    }


    public static Ellipse2D drawBird(Graphics g, Coordinate2D cordsFrom, Coordinate2D cordsTo, Color colorBody) {
        return drawBird(g, cordsFrom, cordsTo, colorBody, COLOR_ARROW);
    }

    public static Ellipse2D drawBird(Graphics g, Coordinate2D cordsFrom, Coordinate2D cordsTo, Color colorBody, Color colorArrow) {
        Coordinate2D fromTransf = Tools.getSwingCords(cordsFrom);
        Coordinate2D transfTo = Tools.getSwingCords(cordsTo);
        return drawBird(g, fromTransf.getX(), fromTransf.getY(), transfTo.getX(), transfTo.getY(), colorBody, colorArrow);
    }

    public static Ellipse2D drawBird(Graphics g, double x, double y, double xNext, double yNext) {
        return drawBird(g, x, y, xNext, yNext, COLOR_BODY, COLOR_ARROW);
    }

    public static Ellipse2D drawBird(Graphics g, double x, double y, double xNext, double yNext, Color colorBody) {
        return drawBird(g, x, y, xNext, yNext, colorBody, COLOR_ARROW);
    }

    public static Ellipse2D drawBird(Graphics g, double x, double y, double xNext, double yNext, Color colorBody, Color colorArrow) {
        Color c = g.getColor();


        double angle;
        angle = getAngle(x, y, xNext, yNext);

        //LOG.fine(angle);

        int xTo = (int) x + (int) (SIEE_ARROW * Math.cos(angle));
        int yTo = (int) y + (int) (SIEE_ARROW * Math.sin(angle));


        int lineX = (int) x;
        int lineY = (int) y;


        // Point2D h = new Point(xTo, yTo);
        //Point2D i = new Point(lineX, lineY);

        double ex = topoints(xTo, yTo, lineX, lineY)[0];
        double ey = topoints(xTo, yTo, lineX, lineY)[1];
        double fx = topoints(xTo, yTo, lineX, lineY)[2];
        double fy = topoints(xTo, yTo, lineX, lineY)[3];


        double ang = getAngle(x, y, ex, ey);

        int xBot = (int) x + (int) (SIZE_SIDE * Math.cos(ang));
        int yBot = (int) y + (int) (SIZE_SIDE * Math.sin(ang));

        double ang2 = getAngle(x, y, fx, fy);

        int xTop = (int) x + (int) (SIZE_SIDE * Math.cos(ang2));
        int yTop = (int) y + (int) (SIZE_SIDE * Math.sin(ang2));

        //int xTo = (int) x + (int) (40 * Math.cos(angle));
        //int yTo = (int) y + (int) (40 * Math.sin(angle));
        g.setColor(colorArrow);
        if (IS_SKELETON) {
            g.drawLine(lineX, lineY, xTo, yTo);
            g.drawLine(xBot, yBot, xTop, yTop);
            g.drawPolygon(new int[]{xTo, xTop, xBot}, new int[]{yTo, yTop, yBot}, 3);
        } else {
            g.fillPolygon(new int[]{xTo, xTop, xBot}, new int[]{yTo, yTop, yBot}, 3);
        }

        g.setColor(colorBody);
        Ellipse2D el = new Ellipse2D.Double(x - (SIZE_BIRD / 2), y - (SIZE_BIRD / 2), SIZE_BIRD, SIZE_BIRD);
        if (IS_SKELETON) {
            g.drawOval((int) x - (SIZE_BIRD / 2), (int) y - (SIZE_BIRD / 2), SIZE_BIRD, SIZE_BIRD);
        } else {
            g.fillOval((int) x - (SIZE_BIRD / 2), (int) y - (SIZE_BIRD / 2), SIZE_BIRD, SIZE_BIRD);
        }

        g.setColor(c);
        return el;
    }


    public static double getAngle(double x, double y, double xNext, double yNext) {
        return Math.atan2(yNext - y, xNext - x);
    }

    public static double getAngleRev(double x, double y, double xNext, double yNext) {
        return Math.atan2(xNext - x, yNext - y);
    }
    
    	
	public static double[] getPerpendiculaire(double x1, double y1, double x2, double y2) {
        //LOG.fine(getPerpendiculaire(lineEquation(x1, y1, x2, y2), x2, y2)[1]);
        return getPerpendiculaire(lineEquation(x1, y1, x2, y2), x2, y2);
	}

	public static double[] getPerpendiculaire(double eq, double x2, double y2) {
		double coef = -1 / eq;
		double pos  = y2 - coef * x2;
		return new double[] { coef, pos };
	}
	
	public static double lineEquation(double x1, double y1, double x2, double y2) {
		/*if (p1.getX() == p2.getX()) return (Double) null;*/
        //LOG.fine((x2+1 - x1));
        if((x2-x1!=0.0) && ((y2-y1!=0.0)))
		return (y2 - y1) / (x2 - x1);
		
		else
		return (y2+0.1 - y1) / (x2+0.1 - x1);

    }

  
		
	public static double[] topoints(double x1, double y1, double x2, double y2){
			
		double a;
		double b;
		a=getPerpendiculaire(x1, y1, x2, y2)[0];
		b=getPerpendiculaire(x1, y1, x2, y2)[1];
		
		double x=(x2+5);
		double xx=(x2-5);
		
		double y= a*x+b;
		double yy= a*xx+b;

		return new double[]{x,y,xx,yy};
			
	}
	

}

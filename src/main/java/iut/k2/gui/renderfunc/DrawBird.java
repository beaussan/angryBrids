package iut.k2.gui.renderfunc;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import iut.k2.data.objects.Shapes.Circle;
import iut.k2.data.objects.Shapes.Polygon;
import iut.k2.physics.Coordinate2D;
import iut.k2.util.Tools;


/**
 * Created by PROPRIETAIRE on 29/09/2015.
 */
public class DrawBird {

    public static final int SIZE_BIRD = 23;
    public static final int SIZE_ARROW = 35;
    public static final int SIZE_SIDE = 20;
    public static final Color COLOR_ARROW = Color.ORANGE;
    public static final Color COLOR_BODY = Color.RED;
    public static boolean IS_SKELETON = false;

    public static Circle drawBird(Graphics g, Coordinate2D cordsFrom, Coordinate2D cordsTo) {
        return drawBird(g, cordsFrom, cordsTo, COLOR_BODY, COLOR_ARROW);
    }


    public static Circle drawBird(Graphics g, Coordinate2D cordsFrom, Coordinate2D cordsTo, Color colorBody) {
        return drawBird(g, cordsFrom, cordsTo, colorBody, COLOR_ARROW);
    }

    public static Circle drawBird(Graphics g, Coordinate2D cordsFrom, Coordinate2D cordsTo, Color colorBody, Color colorArrow) {
        Coordinate2D fromTransf = Tools.getSwingCords(cordsFrom);
        Coordinate2D transfTo = Tools.getSwingCords(cordsTo);
        return drawBird(g, fromTransf.getX(), fromTransf.getY(), transfTo.getX(), transfTo.getY(), colorBody, colorArrow);
    }
    
    public static Circle drawBird(Graphics g, double x, double y, double xNext, double yNext, Color colorBody, Color colorArrow) {
        Color c = g.getColor();

        
        Circle el = getCircle(x,y);
        Polygon poly = getArrow(el.getCoordCenter().getX(),el.getCoordCenter().getY(),xNext, yNext);
        
        g.setColor(colorArrow);
        g.fillPolygon(new java.awt.Polygon(poly.getArrayX(), poly.getArrayY(), poly.getNbPoints()));
        g.setColor(colorBody);
        ((Graphics2D)g).fill(new Ellipse2D.Double(el.getCoordTL().getX(), el.getCoordTL().getY(), el.getRadius()*2, el.getRadius()*2));


        g.setColor(c);
        return el;
    }

    public static Circle getCircle(Coordinate2D cordsFrom) {
        return getCircle(cordsFrom.getX(), cordsFrom.getY());
    }

    public static Circle getSwingCircle(Coordinate2D cordsFrom) {
        Coordinate2D trasf = Tools.getSwingCords(cordsFrom);
        return getCircle(trasf.getX(), trasf.getY());
    }

    public static Circle getCircle(double x, double y){
        return new Circle(x, y, SIZE_BIRD);
    }


    public static Polygon getArrow(Coordinate2D cordsFrom, Coordinate2D cordsTo) {
        return getArrow(cordsFrom.getX(), cordsFrom.getY(), cordsTo.getX(), cordsTo.getY());
    }

    public static Polygon getSwingArrow(Coordinate2D cordsFrom, Coordinate2D cordsTo) {
        Coordinate2D trasf = Tools.getSwingCords(cordsFrom);
        Coordinate2D transfTo = Tools.getSwingCords(cordsTo);
        return getArrow(trasf.getX()-SIZE_BIRD, trasf.getY()-SIZE_BIRD, transfTo.getX()-SIZE_BIRD, transfTo.getY()-SIZE_BIRD);
    }


    public static Polygon getArrow(double x, double y, double xNext, double yNext){

        double angle;
        angle = getAngle(x, y, xNext, yNext);

        //LOG.fine(angle);

        int xTo = (int) x + (int) (SIZE_ARROW * Math.cos(angle));
        int yTo = (int) y + (int) (SIZE_ARROW * Math.sin(angle));


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

        return new Polygon(new int[]{xTo, xTop, xBot}, new int[]{yTo, yTop, yBot}, 3);
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

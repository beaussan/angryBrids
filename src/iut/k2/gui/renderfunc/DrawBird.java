package iut.k2.gui.renderfunc;

import java.awt.*;
import java.awt.geom.Point2D;


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

    public static void drawBird(Graphics g, double x, double y, double xNext, double yNext) {
        Color c = g.getColor();
        g.setColor(COLOR_BODY);


        double angle;
        angle = getAngle(x, y, xNext, yNext);

        //System.out.println(angle);

        int xTo = (int) x + (int) (SIEE_ARROW * Math.cos(angle));
        int yTo = (int) y + (int) (SIEE_ARROW * Math.sin(angle));

  /*      if (xTo < x) {
            xTo = x + (int) (40 * Math.cos(angle + Math.PI));
            yTo = y + (int) (40 * Math.sin(angle + Math.PI));
        }*/

        int lineX = (int) x;
        int lineY = (int) y;
        
        /*int[] x2={(int)x,(int)x,(int)x+10};
		int[] y2={(int)(y-20),(int)y,(int)(y-10)};
		g.drawPolygon(x2,y2,x2.length);
		g.fillPolygon(x2,y2,x2.length);*/


        Point2D h = new Point(xTo, yTo);
		Point2D i = new Point(lineX, lineY);
				
		Point2D e = topoints(h,i)[0];
		Point2D f = topoints(h,i)[1];

        double ang = getAngle(x, y, e.getX(), e.getY());

        int xBot = (int) x + (int) (SIZE_SIDE * Math.cos(ang));
        int yBot = (int) y + (int) (SIZE_SIDE * Math.sin(ang));

        double ang2 = getAngle(x, y, f.getX(), f.getY());

        int xTop = (int) x + (int) (SIZE_SIDE * Math.cos(ang2));
        int yTop = (int) y + (int) (SIZE_SIDE * Math.sin(ang2));

        //int xTo = (int) x + (int) (40 * Math.cos(angle));
        //int yTo = (int) y + (int) (40 * Math.sin(angle));
        g.setColor(COLOR_ARROW);
        if (IS_SKELETON) {
            g.drawLine(lineX, lineY, xTo, yTo);
            g.drawLine(xBot, yBot, xTop, yTop);
            g.drawPolygon(new int[]{xTo, xTop, xBot}, new int[]{yTo, yTop, yBot}, 3);
        } else {
            g.fillPolygon(new int[]{xTo, xTop, xBot}, new int[]{yTo, yTop, yBot}, 3);
        }

       /* g.drawLine((int) x - (SIZE_BIRD / 2), (int) y - (SIZE_BIRD / 2), (int)x, (int)y);*/


   		/*double a = (i.getY()-h.getY()) / (i.getX()-h.getX());
        double coef = -1 / a;
    	double pos  = i.getY() - coef * i.getX();

    	double y3= coef*(i.getX()+10)+pos;
		double y4= coef*(i.getX()-10)+pos;

        g.drawLine((int)(i.getX()+10), (int)y3, (int)(i.getX()-10), (int)y4);*/

        /*double angle2 = getAngle((int)e.getX(), (int)e.getY(), (int)f.getX(), (int)f.getY());


		int[] x2={(int)h.getX(),(int)e.getX(),(int)f.getX()};
		int[] y2={(int)h.getY(),(int)e.getY(),(int)f.getY()};*/
		/*g.drawPolygon(x2,y2,x2.length);
		g.fillPolygon(x2,y2,x2.length);*/
        g.setColor(COLOR_BODY);
        if (IS_SKELETON) {
            g.drawOval((int) x - (SIZE_BIRD / 2), (int) y - (SIZE_BIRD / 2), SIZE_BIRD, SIZE_BIRD);
        } else {
            g.fillOval((int) x - (SIZE_BIRD / 2), (int) y - (SIZE_BIRD / 2), SIZE_BIRD, SIZE_BIRD);
        }

        g.setColor(c);
    }

    public static double getAngle(double x, double y, double xNext, double yNext) {
        return Math.atan2(yNext - y, xNext - x);
    }

    public static double getAngleRev(double x, double y, double xNext, double yNext) {
        return Math.atan2(xNext - x, yNext - y);
    }
    
    	
	public static double[] getPerpendiculaire(Point2D a, Point2D b) {
		return getPerpendiculaire(lineEquation(a, b), b);
	}

	public static double[] getPerpendiculaire(double eq, Point2D b) {
		double coef = -1 / eq;
		double pos  = b.getY() - coef * b.getX();
		return new double[] { coef, pos };
	}
	
	public static double lineEquation(Point2D p1, Point2D p2) {
		/*if (p1.getX() == p2.getX()) return (Double) null;*/
        return (p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
    }

  
		
	public static Point2D[] topoints(Point2D A, Point2D B){
			
		double a;
		double b;
		a=getPerpendiculaire(A, B)[0];
		b=getPerpendiculaire(A, B)[1];
		
		double x=(B.getX()+5);
		double x2=(B.getX()-5);
		
		double y= a*x+b;
		double y2= a*x2+b;

		return new Point2D[]{new Point((int) x,(int) y),new Point((int) x2,(int) y2)};
			
	}
	

}

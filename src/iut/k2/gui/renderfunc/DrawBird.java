package iut.k2.gui.renderfunc;

import java.awt.*;

/**
 * Created by PROPRIETAIRE on 29/09/2015.
 */
public class DrawBird {

    public static final int SIZE_BIRD = 20;

    public static void drawBird(Graphics g, double x, double y, double xNext, double yNext) {
        Color c = g.getColor();
        g.setColor(Color.RED);


        g.drawOval((int) x - (SIZE_BIRD / 2), (int) y - (SIZE_BIRD / 2), SIZE_BIRD, SIZE_BIRD);
        double angle;
        angle = getAngle(x, y, xNext, yNext);

        //System.out.println(angle);

        int xTo = (int) x + (int) (40 * Math.cos(angle));
        int yTo = (int) y + (int) (40 * Math.sin(angle));

  /*      if (xTo < x) {
            xTo = x + (int) (40 * Math.cos(angle + Math.PI));
            yTo = y + (int) (40 * Math.sin(angle + Math.PI));
        }*/

        int lineX = (int) (x - (40 * Math.cos(angle)));
        int lineY = (int) (y - (40 * Math.sin(angle)));
        g.drawLine(lineX, lineY, xTo, yTo);

        g.setColor(c);
    }

    public static double getAngle(double x, double y, double xNext, double yNext) {
        return Math.atan2(yNext - y, xNext - x);
    }

    public static double getAngleRev(double x, double y, double xNext, double yNext) {
        return Math.atan2(xNext - x, yNext - y);
    }
}

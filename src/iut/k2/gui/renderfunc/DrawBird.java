package iut.k2.gui.renderfunc;

import java.awt.*;

/**
 * Created by PROPRIETAIRE on 29/09/2015.
 */
public class DrawBird {

    public static final int SIZE_BIRD = 20;

    public static void drawBird(Graphics g, int x, int y, int xNext, int yNext) {
        Color c = g.getColor();
        g.setColor(Color.RED);


        g.drawOval(x - (SIZE_BIRD / 2), y - (SIZE_BIRD / 2), SIZE_BIRD, SIZE_BIRD);
        double angle;
        angle = getAngle(x, y, xNext, yNext);

        System.out.println(angle);

        int xTo = x + (int) (40 * Math.cos(angle));
        int yTo = y + (int) (40 * Math.sin(angle));

  /*      if (xTo < x) {
            xTo = x + (int) (40 * Math.cos(angle + Math.PI));
            yTo = y + (int) (40 * Math.sin(angle + Math.PI));
        }*/

        g.drawLine(x-(int) (40 * Math.cos(angle)), y-(int) (40 * Math.sin(angle)), xTo, yTo);

        g.setColor(c);
    }

    public static double getAngle(int x, int y, int xNext, int yNext) {
        return Math.atan2(yNext - y, xNext - x);
    }

    public static double getAngleRev(int x, int y, int xNext, int yNext) {
        return Math.atan2(xNext - x, yNext - y);
    }
}

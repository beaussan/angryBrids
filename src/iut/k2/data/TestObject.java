package iut.k2.data;

import iut.k2.data.objects.Entity;
import iut.k2.physics.Coordinate2D;
import iut.k2.util.loggin.UtilLog;

import java.awt.*;
import java.util.Random;
import java.util.logging.Logger;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public class TestObject extends Entity {

    private final static Logger LOG = UtilLog.getLog(TestObject.class.getName());
    private static final Color ON = Color.GREEN;
    private static final Color OFF = Color.RED;
    private final Coordinate2D dirr;
    private int cpt = 0;
    private Color curr;

    public TestObject(Coordinate2D c) {
        super(c);
        curr = ON;
        Random r = new Random();
        dirr = new Coordinate2D(r.nextInt(40) / 2, r.nextInt(20) / 2);
    }

    @Override
    public void render(Graphics batch) {
        batch.setColor(curr);
        batch.fillOval((int) getCoordinate().getX(), (int) getCoordinate().getY(), 10, 10);
    }

    @Override
    public void update(float deltaTime) {
        LOG.fine("Delta time : " + deltaTime);
        cpt++;
        setCoordinate(c.add(dirr.times(deltaTime).divide(1000)));
        if (cpt % 20 < 10) {
            curr = ON;
        } else {
            curr = OFF;
        }
    }
}

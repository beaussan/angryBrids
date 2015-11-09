package iut.k2.data.objects;

import iut.k2.physics.Coordinate2D;
import iut.k2.util.Tools;
import iut.k2.util.loggin.UtilLog;

import javax.annotation.Nonnull;
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
        this(c, true);
    }

    public TestObject(@Nonnull Coordinate2D c, boolean isMoving) {
        super(c);
        int maxSpeed = 200 * 5;
        curr = ON;
        Random r = new Random();
        if (isMoving) {
            dirr = new Coordinate2D(r.nextInt(maxSpeed) - maxSpeed / 2, r.nextInt(maxSpeed) - maxSpeed / 2);
        } else {
            dirr = new Coordinate2D(0, 0);
        }

    }

    @Override
    public void render(@Nonnull Graphics batch) {
        batch.setColor(curr);
        Coordinate2D toOut;
        toOut = Tools.getSwingCords(getCoordinate());
        //toOut = new Coordinate2D(getCoordinate().getX(),Constants.SIZE_HEIGHT)
        LOG.fine("Drawing at : " + toOut + "\t std : " + getCoordinate());
        batch.fillOval((int) toOut.getX() + 5, (int) toOut.getY() + 5, 10, 10);
    }

    @Override
    public void update(float deltaTime) {
        cpt++;
        setCoordinate(c.add(dirr.times(deltaTime).divide(1000)));
        if (cpt % 20 < 10) {
            curr = ON;
        } else {
            curr = OFF;
        }
    }
}

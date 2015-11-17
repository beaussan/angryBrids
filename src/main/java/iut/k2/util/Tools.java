package iut.k2.util;

import com.google.common.base.Preconditions;
import iut.k2.Constants;
import iut.k2.physics.Coordinate2D;

import javax.annotation.Nonnull;
import java.awt.geom.Rectangle2D;

/**
 * Created by Nicolas Beaussart on 14/10/15 for angryBrids.
 */
public final class Tools {

    public static Coordinate2D getSwingCords(Coordinate2D cords) {
        Preconditions.checkNotNull(cords, "Cords must not be null !");
        return new Coordinate2D(cords.getX(), Constants.SIZE_HEIGHT - cords.getY());
    }

    /**
     * Avec répeère othonormé standard 0,0 en bas à gauche
     * @param input
     * @param angle
     * @return
     */
    public static Rectangle2D getRotate(@Nonnull Rectangle2D input, float angle) {
        Preconditions.checkNotNull(input);

        // TODO faire la rotation

        return input;
    }

    private Tools() {
    }
}

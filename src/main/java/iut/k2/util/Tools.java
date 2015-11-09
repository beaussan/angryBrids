package iut.k2.util;

import com.google.common.base.Preconditions;
import iut.k2.Constants;
import iut.k2.physics.Coordinate2D;

/**
 * Created by Nicolas Beaussart on 14/10/15 for angryBrids.
 */
public final class Tools {

    public static Coordinate2D getSwingCords(Coordinate2D cords) {
        Preconditions.checkNotNull(cords, "Cords must not be null !");
        return new Coordinate2D(cords.getX(), Constants.SIZE_HEIGHT - cords.getY());
    }

    private Tools() {
    }
}

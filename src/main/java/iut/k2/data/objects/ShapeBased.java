package iut.k2.data.objects;

import iut.k2.gui.Sprite;
import iut.k2.physics.Coordinate2D;

import java.awt.*;
import java.util.Map;

/**
 * Created by beaussan on 17/11/15.
 */
public interface ShapeBased {

    Map<Coordinate2D, Map<Shape, Color>> getDrawsShapes();
}

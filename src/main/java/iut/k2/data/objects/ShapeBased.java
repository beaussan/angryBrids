package iut.k2.data.objects;

import java.awt.Color;
import java.util.Map;

import iut.k2.data.objects.Shapes.Shape;

/**
 * Created by beaussan on 17/11/15.
 */
public interface ShapeBased {

    Map<Shape, Color> getDrawsShapes();
}

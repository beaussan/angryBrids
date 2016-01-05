package iut.k2.data.objects;

import iut.k2.data.objects.Shapes.Rectangle2D;
import iut.k2.data.objects.Shapes.Shape;
import iut.k2.physics.Coordinate2D;

import javax.annotation.Nullable;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nicbe on 05/01/2016.
 */
public class Ground extends Entity implements ShapeBased{
    Map<Shape, Color> lsShapes = new HashMap<>();
    public Ground(@Nullable Coordinate2D c) {
        super(c);
        Rectangle2D r;
        if (c != null){
            r = new Rectangle2D(c.getX()-30, c.getY(), 1000,-40);
        } else {
            r = new Rectangle2D(-30,0,1000,-40);
        }
        getLsShapes().add(r);
        lsShapes.put(r,Color.GRAY);

    }

    @Override
    protected void onCollide(Entity e) {

    }

    @Override
    public Map<Shape, Color> getDrawsShapes() {
        return lsShapes;
    }
}

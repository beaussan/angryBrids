package iut.k2.data.objects;

import iut.k2.gui.Sprite;
import iut.k2.physics.Coordinate2D;

import java.util.List;
import java.util.Map;

/**
 * Created by beaussan on 17/11/15.
 */
public interface SpriteBased {

    Map<Sprite, Coordinate2D> getLsSprites();
}

package iut.k2.data.objects;

import iut.k2.gui.Sprite;
import iut.k2.gui.SpriteStore;
import iut.k2.physics.Coordinate2D;
import iut.k2.util.Tools;

import java.awt.*;

/**
 * Created by Nicolas Beaussart on 15/10/15 for angryBrids.
 */
public class Montain extends AbstractGameObject {
    private final static int NMB_REP = 3;
    private final Sprite sprite;
    private Coordinate2D cords;
    private Coordinate2D cordsDraw;

    public Montain(String sprite, Coordinate2D cords) {
        this.sprite = SpriteStore.get().getSprite(sprite);
        this.cords = cords;
        cordsDraw = Tools.getSwingCords(cords);
        cordsDraw = cordsDraw.minus(0, this.sprite.getHeight() - 20);
    }

    public Montain(String sprite, Coordinate2D cords, int red, int blue, int green) {
        this.sprite = SpriteStore.get().getSprite(sprite).colorImage(red, blue, green);
        this.cords = cords;
        cordsDraw = Tools.getSwingCords(cords);
        cordsDraw = cordsDraw.minus(0, this.sprite.getHeight() - 20);
    }

    @Override
    public void render(Graphics batch) {
        for (int i = 0; i < NMB_REP; i++)
            sprite.draw(batch, (int) (cordsDraw.getX() + (i * sprite.getWidth())), (int) cordsDraw.getY());
    }
}

package iut.k2.data;

import java.awt.*;
import java.util.List;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public abstract class Level {

    // entityes to refresh
    private List<Entity> lsEntitys;

    // object to render
    private List<AbstractGameObject> lsObjects;

    public Level() {
        init();
    }

    public void render(Graphics g) {
        for (AbstractGameObject ago : lsObjects) {
            ago.render(g);
        }
    }

    public void update(float deltaTime) {
        for (Entity en : lsEntitys) {
            en.update(deltaTime);
        }
    }

    abstract void init();

}

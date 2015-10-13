package iut.k2.data;

import iut.k2.util.KeyMap;

import java.awt.event.KeyEvent;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public class WorldControler {

    private final KeyMap keyMap;
    private final Level level;

    public WorldControler(Level level) {
        this.keyMap = new KeyMap();
        this.level = level;
    }

    public void checkColisions() {

    }

    public KeyMap getKeyMap() {
        return keyMap;
    }

    public Level getLevel() {
        return level;
    }

    public void handleInput() {
        if (keyMap.getKey(KeyEvent.VK_UP)) {
            System.out.println("UP pressed !");
        }
    }

    public void update(float deltaTime) {
        level.update(deltaTime);
    }
}

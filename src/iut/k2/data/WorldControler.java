package iut.k2.data;

import iut.k2.data.objects.Entity;
import iut.k2.util.KeyMap;
import iut.k2.util.loggin.UtilLog;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public class WorldControler implements Runnable {
    private final static Logger LOG = UtilLog.getLog(WorldControler.class.getName());
    private final KeyMap keyMap;
    private final Level level;
    private final List<WorldRenderer> worldRenderers;
    private boolean gameRunning = true;

    public WorldControler(Level level) {
        this.keyMap = new KeyMap();
        this.level = level;
        worldRenderers = new ArrayList<>();
    }

    public boolean addAllRenderer(Collection<? extends WorldRenderer> c) {
        return worldRenderers.addAll(c);
    }

    public boolean addRenderer(WorldRenderer worldRenderer) {
        return worldRenderers.add(worldRenderer);
    }

    public void checkColisions() {

    }

    public boolean containsAllRenderer(Collection<?> c) {
        return worldRenderers.containsAll(c);
    }

    public KeyMap getKeyMap() {
        return keyMap;
    }

    public Level getLevel() {
        return level;
    }

    public List<WorldRenderer> getWorldRenderers() {
        return worldRenderers;
    }

    public void handleDebugInput() {
        if (keyMap.getKey(KeyEvent.VK_D)) {
            for (Entity entity : level.getLsEntitys()) {
                LOG.fine("Entity : " + entity.getCoordinate());
            }
        }
    }

    public void handleInput() {
        handleDebugInput();
    }

    public boolean removeRenderer(WorldRenderer o) {
        return worldRenderers.remove(o);
    }

    public void render() {
        for (WorldRenderer worldRenderer : worldRenderers) {
            worldRenderer.render();
        }
    }

    @Override
    public void run() {
        long lastLoopTime = System.currentTimeMillis();

        // keep looping round til the game ends
        while (gameRunning) {
            // work out how long its been since the last update, this
            // will be used to calculate how far the entities should
            // move this loop
            long delta = System.currentTimeMillis() - lastLoopTime;
            lastLoopTime = System.currentTimeMillis();

            LOG.finest("Handling input");
            handleInput();
            LOG.finest("Updating the game with  " + delta + " of delta time");
            update(delta);
            LOG.finest("Updating collisions");
            checkColisions();
            LOG.finest("Rendering !");
            render();

            // finally pause for a bit. Note: this should run us at about
            // 100 fps but on windows this might vary each loop due to
            // a bad implementation of timer
            try {
                Thread.sleep(10);
            } catch (Exception ignored) {
            }
        }
    }

    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
    }

    public void update(float deltaTime) {
        level.update(deltaTime);
    }
}

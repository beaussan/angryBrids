package iut.k2.data;

import iut.k2.util.KeyMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public abstract class AbstractWorldControler implements Runnable, MouseMotionListener, MouseListener{
    private final static Logger LOG = LoggerFactory.getLogger(AbstractWorldControler.class);
    private final KeyMap keyMap;
    private final Level level;
    private final List<WorldRenderer> worldRenderers;
    volatile private boolean gameRunning = true;
   
    /**
     * Create a new world based witch control the level
     *
     * @param level The subject
     */
    public AbstractWorldControler(@Nonnull Level level) {
        this.keyMap = new KeyMap();
        this.level = checkNotNull(level);
        worldRenderers = new ArrayList<>();
    }
    
    /**
     * Add renderer to this controller
     *
     * @param c A collection of renderer
     * @return true if renderer have been added
     */
    public boolean addAllRenderer(Collection<? extends WorldRenderer> c) {
        return worldRenderers.addAll(c);
    }

    /**
     * Add a renderer to this controller
     *
     * @param worldRenderer A renderer
     * @return true if renderer have been added successfully
     */
    public boolean addRenderer(WorldRenderer worldRenderer) {
        return worldRenderers.add(worldRenderer);
    }

    /**
     * Verify if this controller contain a collection of renderer
     *
     * @param c A renderer
     * @return true if the list of renderer of this object contains these renderer
     */
    public boolean containsAllRenderer(Collection<?> c) {
        return worldRenderers.containsAll(c);
    }

    /**
     * Get the keys recognized by this controller
     *
     * @return keyMap The keyMap of this controller
     */
    public KeyMap getKeyMap() {
        return keyMap;
    }

    /**
     * Get the level related to this controller
     *
     * @return level The level of this controller
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Get the renderer controlled by this controller
     *
     * @return worldRenderers Renderer in this controller's list of renderer
     */
    public List<WorldRenderer> getWorldRenderers() {
        return worldRenderers;
    }

    abstract public void handleInput();

    /**
     * Verify if the game is running or not
     *
     * @return gameRunning
     */
    public boolean isGameRunning() {
        return gameRunning;
    }

    /**
     * Set the game to "running" or "not running"
     * @param gameRunning
     */
    public void setGameRunning(boolean gameRunning) {
        this.gameRunning = gameRunning;
        LOG.trace("Setting game runing to {}", gameRunning);
    }

    /**
     * Remove a renderer from this controller
     *
     * @param worldRenderer A renderer
     * @return true if renderer have been removed successfully
     */
    public boolean removeRenderer(WorldRenderer o) {
        return worldRenderers.remove(o);
    }

    abstract public void render();

    /**
     * Update the delta time of the level
     *
     * @param deltaTime
     */
    public void update(float deltaTime) {
        level.update(deltaTime);
    }
}

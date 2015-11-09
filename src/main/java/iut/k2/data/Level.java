package iut.k2.data;

import iut.k2.data.objects.AbstractGameObject;
import iut.k2.data.objects.Entity;

import javax.annotation.Nonnull;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public abstract class Level {

    // entityes to refresh
    private List<Entity> lsEntitys = new ArrayList<>();

    /**
     * The map lsObjects defines the order each set 
     * of AbstractGameObject has to be displayed
     * Example:
     * 1 : Background
     * 2 : Bird
     * 3 : Obstacles
     */
    private Map<Integer, List<AbstractGameObject>> lsObjects = new TreeMap<>();

	public Level() {
        init();
    }


    /**
     * Add a object to render
     * Example:
     * 1 : Background
     * 2 : Bird
     * 3 : Obstacles
     */
    public boolean addRenderObject(@Nonnull AbstractGameObject abstractGameObject,
                                   int level) {
        checkNotNull(abstractGameObject);

        if (!lsObjects.containsKey(level)) {
            lsObjects.put(level, new ArrayList<AbstractGameObject>());
        }
        boolean res = lsObjects.get(level).add(abstractGameObject);
        if (abstractGameObject instanceof Entity) {
            lsEntitys.add((Entity) abstractGameObject);
        }
        return res;
    }


    /**
     * The map lsObjects defines the order each set
     * of AbstractGameObject has to be displayed
     * Example:
     * 1 : Background
     * 2 : Bird
     * 3 : Obstacles
     */
    public boolean addRenderObject(AbstractGameObject abstractGameObject) {
        return addRenderObject(abstractGameObject, 0);
    }

    public List<Entity> getLsEntitys() {
        return lsEntitys;
    }

    public void setLsEntitys(List<Entity> lsEntitys) {
        this.lsEntitys = lsEntitys;
    }

    public Map<Integer, List<AbstractGameObject>> getLsObjects() {
        return lsObjects;
    }

    public void setLsObjects(Map<Integer, List<AbstractGameObject>> lsObjects) {
        this.lsObjects = lsObjects;
    }

    /**
     * The levels differences will be defined in this function
     * For example:
     * Level 1 can have 1 Pecker and 5 obstacles
     * Level 2 can have 2 Pecker and 10 obstacles
     */
    public abstract void init();

    /**
     * Renders the list of Objects contained in the level
     * @param g graphics
     */
    public void render(@Nonnull Graphics g) {
        for (Integer in : lsObjects.keySet()) {
            for (AbstractGameObject ago : lsObjects.get(in)) {
                ago.render(g);
            }
    	}
    }

    /**
     * Updates the informations about the current Entity
     * @param deltaTime time between two frames
     */
    public void update(float deltaTime) {
        for (Entity en : lsEntitys) {
            en.update(deltaTime);
        }
    }

}

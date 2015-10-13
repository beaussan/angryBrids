package iut.k2.data;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public abstract class Level {

    // entityes to refresh
    private List<Entity> lsEntitys;

    /**
     * The map lsObjects defines the order each set 
     * of AbstractGameObject has to be displayed
     * Example:
     * 1 : Background
     * 2 : Bird
     * 3 : Obstacles
     */
    private Map<Integer, List<AbstractGameObject>> lsObjects;

	public Level() {
        init();
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
     * @param g
     */
    public void render(Graphics g) {
    	for(int i = 0; i < lsObjects.size(); i++){
    		for (AbstractGameObject ago : lsObjects.get(i)) {
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

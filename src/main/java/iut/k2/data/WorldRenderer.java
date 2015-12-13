package iut.k2.data;

import com.google.common.base.Strings;

import iut.k2.Constants;
import iut.k2.data.objects.AbstractGameObject;
import iut.k2.data.objects.Obstacle;
import iut.k2.data.objects.ShapeBased;
import iut.k2.data.objects.SpriteBased;
import iut.k2.gui.Sprite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import iut.k2.data.objects.Shapes.*;

import javax.annotation.Nonnull;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferStrategy;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by Nicolas Beaussart on 13/10/15 for angryBrids.
 */
public class WorldRenderer {
    private final static Logger LOG = LoggerFactory.getLogger(WorldRenderer.class);
    private final BufferStrategy strategy;
    private AbstractWorldControler abstractWorldControler;
    private String textDisplayed;

    public WorldRenderer(@Nonnull BufferStrategy strategy,
                         @Nonnull AbstractWorldControler abstractWorldControler) {
        this.strategy = checkNotNull(strategy);
        this.abstractWorldControler = checkNotNull(abstractWorldControler);
        abstractWorldControler.addRenderer(this);
    }

    /**
     * Getter for property 'textDisplayed'.
     *
     * @return Value for property 'textDisplayed'.
     */
    public String getTextDisplayed() {
        return textDisplayed;
    }

    /**
     * Setter for property 'textDisplayed'.
     *
     * @param textDisplayed Value to set for property 'textDisplayed'.
     */
    public void setTextDisplayed(String textDisplayed) {
        this.textDisplayed = Strings.nullToEmpty(textDisplayed);
    }

	 /**
     * The final render which implemented the strategy
     */
    public void render() {
        Graphics g = strategy.getDrawGraphics();
        render(g);
        g.dispose();
        strategy.show();
    }

	 /**
     * Render the black font and call the render of the world and axis
     *
     * @param g
     */
    public void render(@Nonnull Graphics g) {
        checkNotNull(g, "Graphics must not be null !");
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Constants.SIZE_WIDE + 20, Constants.SIZE_HEIGHT + 20);
        writeTxtInfo(g);
        Level l = abstractWorldControler.getLevel();
        renderWorld(g, l);
        renderAxis(g);
    }

	 /**
     * Render all the shapes and sprite
     *
     * @param g
     * @param l
     */
    private void renderWorld(Graphics g, Level l) {
    	((Graphics2D) g).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (Integer in : l.getLsObjects().keySet()) {
            for (AbstractGameObject ago : l.getLsObjects().get(in)) {
                if (ago instanceof ShapeBased) {
                    ShapeBased shapeBased = (ShapeBased) ago;
                    for (Shape shape : shapeBased.getDrawsShapes().keySet()) {
                    	if (!g.getColor().equals(shapeBased.getDrawsShapes().get(shape))){
                    		g.setColor(shapeBased.getDrawsShapes().get(shape));
                    	}
                        if(shape instanceof Circle){
                        	Circle circle = (Circle)shape;
                        	((Graphics2D) g).fill(new Ellipse2D.Double(
                            		circle.getCoordTL().getX(),
                            		circle.getCoordTL().getY(), 
                            		circle.getRadius()*2,
                            		circle.getRadius()*2));
                          
                        	//debugDrawCircle(g, circle);

                        }else if(shape instanceof Rectangle2D){
                        	Rectangle2D r2 = (Rectangle2D)shape;
                            ((Graphics2D) g).fill(new java.awt.geom.Rectangle2D.Double(r2.getX(), r2.getY(), r2.getWidth(), r2.getHeight()));
                        }else if(shape instanceof Rectangle){
                        	Rectangle r2 = (Rectangle)shape;
                            ((Graphics2D) g).fill(new java.awt.Rectangle(r2.getX(), r2.getY(), r2.getWidth(), r2.getHeight()));
                        }else if(shape instanceof Polygon){
                        	Polygon p = (Polygon)shape;
                            ((Graphics2D) g).fill(new java.awt.Polygon(p.getArrayX(), p.getArrayY(), p.getNbPoints()));
                        }else{
                        	LOG.debug("No instance of type:" + shape.toString());
                        }
                    }
                } else if (ago instanceof SpriteBased) {
                    SpriteBased sb = (SpriteBased) ago;
                    for (Sprite sprite : sb.getLsSprites().keySet()) {
                        sprite.draw(g, (int) sb.getLsSprites().get(sprite).getX(), (int) sb.getLsSprites().get(sprite).getY());
                    }
                } else {
                    LOG.error("I got an entity I don't know how to draw it ! ( {} )", ago);
                }
            }
        }
    }
    
	 /**
     * A solution find how to draw circle correctly on the screen
     *
     * @param g
     * @param circle
     */
    private void debugDrawCircle(Graphics g, Circle circle){
		g.setColor(Color.YELLOW);
		((Graphics2D) g).drawLine((int) circle.getCoordTL().getX(),
				(int) circle.getCoordTL().getY(), (int) circle.getCoordTL().getX(),
				(int) circle.getCoordTL().getY());
		g.setColor(Color.YELLOW);
		g.drawString(
				(int) circle.getCoordTL().getX() + ","
						+ (int) (circle.getCoordTL().getY() + circle.getRadius() * 2),
				(int) circle.getCoordTL().getX(),
				(int) (circle.getCoordTL().getY() + circle.getRadius() * 2));
		((Graphics2D) g).drawLine((int) circle.getCoordTL().getX(),
				(int) (circle.getCoordTL().getY() + circle.getRadius() * 2),
				(int) circle.getCoordTL().getX(),
				(int) (circle.getCoordTL().getY() + circle.getRadius() * 2));
		g.setColor(Color.WHITE);
		((Graphics2D) g).drawLine((int) circle.getCoordCenter().getX(),
				(int) circle.getCoordCenter().getY(), (int) circle.getCoordCenter().getX(),
				(int) circle.getCoordCenter().getY());
    }

	 /**
     * Show informations at the screen if textDisplayed is set
     *
     * @param g
     */
    private void writeTxtInfo(Graphics g) {
        if (textDisplayed == null || textDisplayed.equals("")) {
            return;
        }
        g.setColor(Color.LIGHT_GRAY);
        g.drawString(textDisplayed, 10, 50);
    }

	 /**
     * Render the x and y axis
     *
     * @param g
     */
    private void renderAxis(Graphics g) {
        g.setColor(Color.WHITE);
        g.drawLine(0, 0, Constants.SIZE_WIDE, 0);
        g.drawLine(0, 0, 0, Constants.SIZE_HEIGHT);
    }
}

package iut.k2.gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.HashMap;
import java.util.Map;

/**
 * A sprite to be displayed on the screen. Note that a sprite
 * contains no state information, i.e. its just the image and
 * not the location. This allows us to use a single sprite in
 * lots of different places without having to store multiple
 * copies of the image.
 *
 * @author Nicolas Beaussart
 */
public class Sprite {
    /**
     * The image to be drawn for this sprite
     */
    private Image image;
    private Map<String, Sprite> otherColors = new HashMap<>();

    /**
     * Create a new sprite based on an image
     *
     * @param image The image that is this sprite
     */
    public Sprite(Image image) {
        this.image = image;
    }

    public Sprite colorImage(int red, int blue, int green) {
        if (!otherColors.containsKey("" + red + "," + blue + "," + green)) {
            BufferedImage outImg = copyImage();
            int width = outImg.getWidth();
            int height = outImg.getHeight();
            WritableRaster raster = outImg.getRaster();

            for (int xx = 0; xx < width; xx++) {
                for (int yy = 0; yy < height; yy++) {
                    int[] pixels = raster.getPixel(xx, yy, (int[]) null);
                    pixels[0] = red;
                    pixels[1] = green;
                    pixels[2] = blue;
                    raster.setPixel(xx, yy, pixels);
                }
            }
            // create an accelerated image of the right size to store our sprite in
            GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
            Image image = gc.createCompatibleImage(outImg.getWidth(), outImg.getHeight(), Transparency.BITMASK);

            // draw our source image into the accelerated image
            image.getGraphics().drawImage(outImg, 0, 0, null);

            // create a sprite, add it the cache then return it
            Sprite sprite = new Sprite(image);
            otherColors.put("" + red + "," + blue + "," + green, sprite);
            return sprite;
        }
        return otherColors.get("" + red + "," + blue + "," + green);
    }

    /**
     * Draw the sprite onto the graphics context provided
     *
     * @param g The graphics context on which to draw the sprite
     * @param x The x location at which to draw the sprite
     * @param y The y location at which to draw the sprite
     */
    public void draw(Graphics g, int x, int y) {
        g.drawImage(image, x, y, null);
    }

    /**
     * Get the height of the drawn sprite
     *
     * @return The height in pixels of this sprite
     */
    public int getHeight() {
        return image.getHeight(null);
    }

    /**
     * Get the width of the drawn sprite
     *
     * @return The width in pixels of this sprite
     */
    public int getWidth() {
        return image.getWidth(null);
    }

    private BufferedImage copyImage() {
        BufferedImage b = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics g = b.getGraphics();
        g.drawImage(image, 0, 0, null);
        g.dispose();
        return b;
    }
}
package iut.k2.data.objects;

import iut.k2.gui.renderfunc.DrawBird;
import iut.k2.physics.Coordinate2D;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Pecker extends Entity implements ShapeBased {
    private final static Logger LOG = LoggerFactory.getLogger(Pecker.class);

    private boolean hasToUbdShape = true;

    private Map<Shape, Color> shapeColorMap = new LinkedHashMap<>();

	public Pecker(Coordinate2D c) {
		super(c);
        LOG.debug("Creating new Pecker at {}", c);

        // Set physics values
        setTerminalVelocity(new Coordinate2D(1000.0f, 1000.0f));
        setFriction(new Coordinate2D(.005, 0));
        setAcceleration(new Coordinate2D(0.0f, -0.25f));
        //setVelocity(new Coordinate2D(200, 300));
    }

    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        getLsShapes().clear();
        getLsShapes().add(DrawBird.getCircle(getCoordinate()));
        hasToUbdShape = true;
    }

    private Map<Shape, Color> genShapes() {
        shapeColorMap.clear();
        shapeColorMap.put(DrawBird.getSwingArrow(getCoordinate(), getCoordinate().add(getVelocity().times(2))), Color.YELLOW);
        shapeColorMap.put(DrawBird.getSwingCircle(getCoordinate()), Color.RED);
        hasToUbdShape = false;
        LOG.debug("Generating a thing !!!!!!!");
        return shapeColorMap;
    }

    @Override
    public Map<Shape, Color> getDrawsShapes() {
        return (hasToUbdShape) ? genShapes() : shapeColorMap;
    }
}



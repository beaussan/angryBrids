package iut.k2.util;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class KeyMap extends KeyAdapter {

    private final HashMap<Integer, Boolean> keys = new HashMap<Integer, Boolean>();

    public boolean getKey(int i) {
        Boolean b = keys.get(i);
        return (b != null) && (b);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys.put(e.getKeyCode(), true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys.put(e.getKeyCode(), false);
    }

    public void setKey(int i, boolean b) {
        keys.put(i, b);
    }
}

package iut.k2;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import iut.k2.gui.Window;
import iut.k2.gui.renderfunc.DrawingPlace;
import iut.k2.physics.functions.ArchimedeSpiral;
import iut.k2.physics.functions.Square;
import iut.k2.physics.functions.SquareParam;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jf = new JFrame("Hello curve");
                Window win = new Window(700, 500);
                
                jf.add(win);
                jf.setLocationRelativeTo(null);
                jf.setSize(700, 500);
                jf.setVisible(true);
                jf.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosed(WindowEvent e) {
                        //System.exit(0);
                    }

                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
            }
        });
	}
	
}

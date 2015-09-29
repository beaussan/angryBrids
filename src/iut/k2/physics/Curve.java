package iut.k2.physics;



import java.awt.*;
import java.applet.*;

public class Curve extends Applet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -4701031565570056071L;

	private final Dimension dim = new Dimension(481,321);

    private ParamCurve curve;
    private Drawing drawing;

    public void init() {
    	try{
    		setSize(dim);
    		setBackground(Color.lightGray);
    		curve = new ParamCurve();
    		drawing = new Drawing(dim,curve);
    	}catch(Exception e){
    		System.out.println("test");
    	}
    }
		
    public void paint(Graphics g) {
        drawing.drawCurve(g,curve);
    }
	
}
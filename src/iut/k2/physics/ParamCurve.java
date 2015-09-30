package iut.k2.physics;
public class ParamCurve {
    
    public final double tMin = 0;
    public final double tMax = 2*Math.PI;
    
    public double x(double t) {
        return Math.cos(t);
    }

    public double y(double t) {
        return Math.sin(2*t);
	}
	
}
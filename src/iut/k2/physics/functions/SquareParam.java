package iut.k2.physics.functions;

public class SquareParam extends ParamCurve{

	public final double tMin = -10;
    public final double tMax = 10;
    public double coef;
	
	public SquareParam(double coef){
		this.coef = coef;
	}
	
    @Override
    public double getTMax() {
        return tMax;
    }

    @Override
    public double getTMin() {
        return tMin;
    }

    @Override
    public double x(double t) {
        return t;
    }

    @Override
    public double y(double t) {
        return -(Math.pow(x(t), 2)+coef);
    }
}

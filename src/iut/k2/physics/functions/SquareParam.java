package iut.k2.physics.functions;

public class SquareParam extends ParamCurve{

	public final double hauteurEcran = 300;
	public final double tMin = 0;
    public final double tMax = 10;
    public double coef;
	
	public SquareParam(double coef){
		this.coef = coef;
	}

    /**
     * {@inheritDoc}
     */
    @Override
    public double getTMax() {
        return tMax;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getTMin() {
        return tMin;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double x(double t) {
        return t;
    }

    /** {@inheritDoc} */
    @Override
    public double y(double t) {
    	//http://tpe-records-mondiaux-sport.e-monsite.com/pages/les-facteurs-d-une-bonne-performance.html
    	//Idée de fonction pour la courbe ax2+bx+c (y=-0,05x²+1,05x+1,5)
        return -0.05*Math.pow(x(t), 2)+1.05*x(t);
    }
}

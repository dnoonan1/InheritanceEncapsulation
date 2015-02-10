package drawable;

import real.Vector2d;

/**
 *
 * @author      Dan Noonan
 * @version     1.00
 */
public abstract class ParametricCurve2d implements Drawable {
    
    private double t0, t1; // parameter start and end; t exists in [t0, t1]
    
    // Default interval is [0, 1]
    public ParametricCurve2d() {
        t0 = 0.0;
        t1 = 1.0;
    }
    
    public double getParameterStart() {
        return t0;
    }
    
    public double getParameterEnd() {
        return t1;
    }
    
    // Useful for subclasses
    public final double normalizeT(double t) {
        return (t - t0) / (t1 - t0);
    }
    
    public abstract Vector2d eval(double t);
    public abstract double getArclength();
    
    @Override
    public String getProperty() {
        return String.format("value at t = 0.5: (%s); arclength = %.2f",
                eval(0.5), getArclength());
    }
    
}

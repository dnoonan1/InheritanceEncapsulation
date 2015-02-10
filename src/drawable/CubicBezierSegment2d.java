package drawable;

import real.Vector2d;

/**
 *
 * @author Dan
 */
public class CubicBezierSegment2d extends ParametricCurve2d {
    
    private Vector2d[] b = new Vector2d[4];
    
    private static double steps = 100;
    
    public CubicBezierSegment2d(Vector2d b0, Vector2d b1,
            Vector2d b2, Vector2d b3) {
        b[0] = b0;
        b[1] = b1;
        b[2] = b2;
        b[3] = b3;
    }
    
    // Encapsulation
    public CubicBezierSegment2d(double b0x, double b0y, double b1x, double b1y,
            double b2x, double b2y, double b3x, double b3y) {
        b[0] = new Vector2d(b0x, b0y);
        b[1] = new Vector2d(b1x, b1y);
        b[2] = new Vector2d(b2x, b2y);
        b[3] = new Vector2d(b3x, b3y);
    }
    
    public static void setSteps(double value) {
        if (value < 0.0) {
            throw new IllegalArgumentException("value must be positive");
        }
        steps = value;
    }

    public static Vector2d interpolate(double t, Vector2d b0, Vector2d b1,
            Vector2d b2, Vector2d b3) {
        // De Castlejau algorithm
        Vector2d b01, b12, b23;
        b01 = Line2d.interpolate(t, b0, b1);
        b12 = Line2d.interpolate(t, b1, b2);
        b23 = Line2d.interpolate(t, b2, b3);
        
        b01 = Line2d.interpolate(t, b01, b12);
        b12 = Line2d.interpolate(t, b12, b23);
        
        b01 = Line2d.interpolate(t, b01, b12);
        
        return b01;
    }
    
    @Override
    public void draw() {
        System.out.printf("Drawing a Bezier curve segment with control points "
                + "(%s), (%s), (%s), and (%s)\n", b[0], b[1], b[2], b[3]);
    }
    
    @Override
    public Vector2d eval(double t) {
        return interpolate(t, b[0], b[1], b[2], b[3]);
    }

    @Override
    public double getArclength() {
        System.out.println();
        double t;
        double length = 0.0;
        Vector2d previous = b[0], next;
        for (int i = 1; i < steps; i++) {
            t = getParameterStart() + (i / steps)
                    * (getParameterEnd() - getParameterStart());
            next = eval(t);
            length += previous.distanceTo(next);
            previous = next;
        }
        //return length;
        throw new UnsupportedOperationException(); // doesn't work yet
    }
    
}

package drawable;

import real.Vector2d;

/**
 *
 * @author      Dan Noonan
 */
public class Line2d extends ParametricCurve2d {

    private Vector2d start;
    private Vector2d end;
    
    // Default: line from (0, 0) to (1, 1)
    public Line2d() {
        this(0.0, 0.0,  1.0, 1.0);
    }
    
    public Line2d(Vector2d start, Vector2d end) {
        this.start = start;
        this.end = end;
    }
    
    // Encapsulation
    public Line2d(double x1, double y1, double x2, double y2) {
        this(new Vector2d(x1, y1), new Vector2d(x2, y2));
    }

    @Override
    public void draw() {
        System.out.printf("Drawing a line from (%s) to (%s)\n", start, end);
    }
    
    public static Vector2d interpolate(double t, Vector2d p0, Vector2d p1) {
        p0 = new Vector2d(p0);
        p1 = new Vector2d(p1);
        p0.scale(1 - t);
        p1.scale(t);
        p0.add(p1);
        return p0;
    }
    
    @Override
    public Vector2d eval(double t) {
        t = normalizeT(t);
        return interpolate(t, start, end);
    }

    @Override
    public double getArclength() {
        return start.distanceTo(end);
    }
    
}

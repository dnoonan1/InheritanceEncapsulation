package ivector;

/**
 *
 * @author Dan Noonan
 */
public class Vector2d implements IVector {
    private double x, y;
    
    public Vector2d() {}
    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public void add(IVector v) {
        if (v instanceof Vector2d) {
            Vector2d u = (Vector2d)v;
            x += u.x;
            y += u.y;
        } else {
            // Not very desirable
            throw new IllegalArgumentException("v must be type Vector2d");
        }
    }

    @Override
    public void scale(double k) {
        x *= k;
        y *= k;
    }

    @Override
    public double dot(IVector v) {
        if (v instanceof Vector2d) {
            Vector2d u = (Vector2d)v;
            return x * u.x + y * u.y;
        } else {
            // Not very desirable
            throw new IllegalArgumentException("v must be type Vector2d");
        }
    }
    
    
}

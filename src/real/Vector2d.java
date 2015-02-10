package real;

/**
 *
 * @author Dan
 */

// R2 space
public class Vector2d extends Real {
    
    private double y;
    
    public Vector2d() {}
    
    public Vector2d(double x) {
        super(x);
    }
    
    public Vector2d(double x, double y) {
        super(x);
        this.y = y;
    }
    
    public Vector2d(Vector2d v) {
        super(v);
        this.y = v.y;
    }

    public final double getY() {
        return y;
    }

    public final void setY(double y) {
        this.y = y;
    }
    
    // Additive inverse
    @Override
    public void opposite() {
        super.opposite();
        y = -y;
    }
    
    // Add a 2D vector
    public final void add(Vector2d v) {
        super.add(v);
        y += v.y;
    }
    
    // Subtract a 2D vector
    public final void subtract(Vector2d v) {
        super.subtract(v);
        y -= v.y;
    }
    
    // Scalar multiplication
    @Override
    public void scale(double k) {
        super.scale(k);
        y *= k;
    }
    
    // Dot product
    public double dot(Vector2d v) {
        return super.dot(v) + y * v.y;
    }
    
    // Norm (length) = sqrt(x^2 + y^2)
    @Override
    public double norm() {
        return Math.sqrt(super.norm() + y * y);
    }
    
    // Normalize (divide by norm) - throws an exception if norm = 0
    @Override
    public void normalize() {
        scale(1.0 / norm());
    }
    
    // Tests whether this is a unit vector (norm = 1)
    @Override
    public boolean isUnit() {
        return norm() == 1.0;
    }
    
    public double distanceTo(Vector2d v) {
        Vector2d u = new Vector2d(this);
        u.subtract(v);
        return u.norm();
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + y;
    }
}

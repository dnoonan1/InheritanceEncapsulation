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
        super((Real)v);
        this.y = v.y;
    }

    public final double getY() {
        return y;
    }

    public final void setY(double y) {
        this.y = y;
    }
    
    public void opposite() {
        super.opposite();
        y = -y;
    }
    
    @Override
    public double norm() {
        return Math.sqrt(super.norm() + y * y);
    }
    
    @Override
    public void normalize() {
        scale(1.0 / norm());
    }
    
    @Override
    public boolean isUnit() {
        return norm() == 1.0;
    }
    
    public final void add(Vector2d v) {
        add(getX());
        y += v.y;
    }
    
    @Override
    public void scale(double k) {
        super.scale(k);
        y *= k;
    }
    
    public double dot(Vector2d v) {
        return getX() * v.getX() + y * v.y;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + y;
    }
}

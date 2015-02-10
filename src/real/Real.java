package real;

/**
 *
 *         Real
 *           |
 *       Vector2d
 *        |     \
 *   Vector3d    ComplexNumber  < - - Complex
 *        |    
 *   Vector4d    
 *          \
 *         Quaternion  < - - Complex
 *
 *   Elegant in terms of structure, but not efficient
 * 
 * @author Dan Noonan
 */

// Real (R) space
public abstract class Real {
    // Real is abstract because there's no need to instantiate it; it's
    // a wrapper for double (like Double) and a base class for other vectors
    private double x;
    
    // Constructors are called in subclasses
    public Real() {}
    
    public Real(double x) {
        this.x = x;
    }
    
    public Real(Real num) {
        this.x = num.x;
    }
    
    public final double getX() {
        return x;
    }
    
    public final void setX(double x) {
        this.x = x;
    }
    
    public void opposite() {
        x = -x;
    }
    
    public double norm() {
        return Math.abs(x);
    }
    
    public void normalize() {
        x /= Math.abs(x);
    }
    
    public boolean isUnit() {
        return norm() == 1.0;
    }
    
    public final void add(double number) {
        x += number;
    }
    
    public void scale(double k) {
        x *= k;
    }
    
    @Override
    public String toString() {
        return Double.toString(x);
    }
}

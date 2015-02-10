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
    
    public Real(Real real) {
        this.x = real.x;
    }
    
    public final double getX() {
        return x;
    }
    
    public final void setX(double x) {
        this.x = x;
    }
    
    // Additive inverse
    public void opposite() {
        x = -x;
    }
    
    // Add another real number
    public final void add(Real real) {
        x += real.x;
    }
    
    // Subtract (same as adding opposite)
    public final void subtract(Real real) {
        x -= real.x;
    }
    
    // Scalar multiplication
    public void scale(double k) {
        x *= k;
    }
    
    // Dot product (in R space, same as scalar multiplication)
    // The difference between the two methods is that this returns a double
    public double dot(Real real) {
        return x * real.x;
    }
    
    // Norm (in R space, norm = absolute value)
    public double norm() {
        return Math.abs(x);
    }
    
    // Make this into -1 or 1 - throws an exception if norm = 0
    public void normalize() {
        x /= Math.abs(x);
    }
    
    // Test whether this is a unit
    public boolean isUnit() {
        return norm() == 1.0;
    }
    
    public double distanceTo(Real real) {
        return Math.abs(x - real.x);
    }

    @Override
    public String toString() {
        return Double.toString(x);
    }
}

package ivector;

/**
 *
 * @author Dan Noonan
 */

// Check package real for better implementations of vector math
public interface IVector {
    public abstract void add(IVector v);
    public abstract void scale(double k);
    public abstract double dot(IVector v);
}

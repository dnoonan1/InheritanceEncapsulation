package complex;
import real.Vector3d;

/**
 *
 * @author Dan Noonan
 */

// Same as Quaternion, except uses composition instead of extending Vector4d
// This greatly simplifies math for multiply() method
public class Quaternion2 implements Complex {
    private double real;
    private Vector3d vector;
    
    // Complex numbers i, j, and k
    public static final Quaternion I = new Quaternion(1, 0, 0, 0);
    public static final Quaternion J = new Quaternion(0, 1, 0, 0);
    public static final Quaternion K = new Quaternion(0, 0, 1, 0);
    
    public Quaternion2() {}
    
    public Quaternion2(double w, Vector3d vector) {
        this.real = w;
        this.vector = vector;
    }
    
    public Quaternion2 quaternionFromAngleAxis(double angle, Vector3d axis) {
        Vector3d v = new Vector3d(axis);
        // First, make sure the axis is normalized
        if (!v.isUnit()) {
            v.normalize();
        }
        v.scale(Math.sin(angle));
        return new Quaternion2(Math.cos(angle), v);
    }
    
    public double getReal() {
        return real;
    }
    
    public Vector3d getVector() {
        return new Vector3d(vector);
    }

    @Override
    public void conjugate() {
        vector.opposite();
    }
    
    @Override
    public void multiply(Complex quaternion) {
        if (quaternion instanceof Quaternion2) {
            Quaternion2 q = (Quaternion2)quaternion;
            double real1 = real,
                   real2 = q.real;
            Vector3d v2 = new Vector3d(q.vector),
                     u  = new Vector3d(vector);
            u.cross(v2);
            real = real1 * real2 - vector.dot(v2);
            vector.scale(real2);
            v2.scale(real1);
            vector.add(v2);
            vector.add(u);
        } else {
            throw new UnsupportedOperationException("Only quaternions can be "
                    + "multiplied with quaternions!");
        }
    }
}

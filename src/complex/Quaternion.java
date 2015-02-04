package complex;
import real.*;

/**
 *
 * @author Dan Noonan
 */
public class Quaternion extends Vector4d implements Complex {
    
    // Complex numbers i, j, and k
    public static final Quaternion I = new Quaternion(1, 0, 0, 0);
    public static final Quaternion J = new Quaternion(0, 1, 0, 0);
    public static final Quaternion K = new Quaternion(0, 0, 1, 0);
    
    public Quaternion() {}
    
    public Quaternion(double x, double y, double z, double w) {
        super(x, y, z, w);
    }
    
    public Quaternion(double w, Vector3d v) {
        super(v.getX(), v.getY(), v.getZ(), w);
    }
    
    public Quaternion quaternionFromAngleAxis(double angle, Vector3d axis) {
        Vector3d v = new Vector3d(axis);
        // First, make sure the axis is normalized
        if (!v.isUnit()) {
            v.normalize();
        }
        v.scale(Math.sin(angle));
        return new Quaternion(Math.cos(angle), v);
    }
    
    public double getReal() {
        return getW();
    }
    
    public Vector3d getVector() {
        return new Vector3d(getX(), getY(), getZ());
    }

    @Override
    public void conjugate() {
        setX(-getX());
        setY(-getY());
        setZ(-getZ());
    }
    
    @Override
    public void multiply(Complex quaternion) {
        if (quaternion instanceof Quaternion) {
            Quaternion q = (Quaternion)quaternion;
            double w1 = getW(),
                   x1 = getX(),
                   y1 = getY(),
                   z1 = getZ(),
                   
                   w2 = q.getW(),
                   x2 = q.getX(),
                   y2 = q.getY(),
                   z2 = q.getZ();
            
            setW(w1 * w2 - x1 * x2 - y1 * y2 - z1 * z2);
            setX(w1 * x2 + x1 * w2 + y1 * z2 - z1 * y2);
            setY(w1 * y2 + y1 * w2 - x1 * z2 + z1 * x2);
            setZ(w1 * z2 + z1 * w2 + y1 * z2 - z1 * y2);
        } else {
            throw new UnsupportedOperationException("Only quaternions can be "
                    + "multiplied with quaternions!");
        }
    }
}

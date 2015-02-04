package ivector;

/**
 *
 * @author Dan Noonan
 */
public class Vector3d implements IVector {

    private double x, y, z;
    
    public Vector3d() {}
    
    public Vector3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
    
    @Override
    public void add(IVector v) {
        if (v instanceof Vector3d) {
            Vector3d u = (Vector3d)v;
            x += u.x;
            y += u.y;
            z += u.z;
        } else if (v instanceof Vector2d) {
            Vector2d u = (Vector2d)v;
            x += u.getX();
            y += u.getY();
        } else {
            // Not very desirable
            throw new IllegalArgumentException("v must be type Vector3d or "
                    + "Vector2d");
        }
    }

    @Override
    public void scale(double k) {
        x *= k;
        y *= k;
        z *= k;
    }

    @Override
    public double dot(IVector v) {
        if (v instanceof Vector3d) {
            Vector3d u = (Vector3d)v;
            return x * u.x + y * u.y + z * u.z;
        } else {
            // Not very desirable
            throw new IllegalArgumentException("v must be Vector3d");
        }
    }
}

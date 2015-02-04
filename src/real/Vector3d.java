package real;

/**
 *
 * @author Dan Noonan
 */

// R3 space
public class Vector3d extends Vector2d {
    private double z;
    
    public Vector3d() {}
    
    public Vector3d(double x, double y) {
        super(x, y);
    }
    
    public Vector3d(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }
    
    public Vector3d(Vector3d v) {
        super((Vector2d)v);
        z = v.z;
    }
    
    public final double getZ() {
        return z;
    }
    
    public final void setZ(double z) {
        this.z = z; 
    }
    
    public void opposite() {
        super.opposite();
        z = -z;
    }
    
    @Override
    public double norm() {
        return Math.sqrt(super.norm() + z * z);
    }
    
    @Override
    public void normalize() {
        scale(1.0 / norm());
    }
    
    @Override
    public boolean isUnit() {
        return norm() == 1.0;
    }
    
    public final void add(Vector3d v) {
        super.add((Vector2d)v);
        z += v.z;
    }
    
    @Override
    public void scale(double k) {
        super.scale(k);
        z *= k;
    }
    
    public double dot(Vector3d v) {
        return super.dot((Vector2d)v) + z * v.z;
    }
    
    public void cross(Vector3d v) {
        double x = getX(),
               y = getY(),
               z = this.z;
        setX(getY() * v.z - z * v.getY());
        setY(z * v.getX() - getX() * v.z);
        z = getX() * v.getY() - getY() * v.getX();
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + z;
    }
}

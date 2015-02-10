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
        super(v);
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
    
    public final void add(Vector3d v) {
        super.add(v);
        z += v.z;
    }
    
    public final void subtract(Vector3d v) {
        super.subtract(v);
        z -= v.z;
    }
    
    @Override
    public void scale(double k) {
        super.scale(k);
        z *= k;
    }
    
    public double dot(Vector3d v) {
        return super.dot(v) + z * v.z;
    }
    
    public void cross(Vector3d v) {
        double x = getX(),
               y = getY(),
               z = this.z;
        setX(x * v.z - z * v.getY());
        setY(z * v.getX() - x * v.z);
        z = x * v.getY() - y * v.getX();
    }
    
    // Triple vector product: u dot (v cross w)
    // unique to Vector3d
    public double triple(Vector3d v, Vector3d w) {
        Vector3d u = new Vector3d(v);
        u.cross(w);
        return this.dot(u);
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
    
    public double distanceTo(Vector3d v) {
        Vector3d u = new Vector3d(this);
        u.subtract(v);
        return u.norm();
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + z;
    }
}

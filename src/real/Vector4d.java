package real;

/**
 *
 * @author Dan Noonan
 */

// R4 space
public class Vector4d extends Vector3d {
    
    private double w;
    
    public Vector4d() {}
    
    public Vector4d(double x, double y) {
        super(x, y);
    }
    
    public Vector4d(double x, double y, double z) {
        super(x, y, z);
    }
    
    public Vector4d(double x, double y, double z, double w) {
        super(x, y, z);
        this.w = w;
    }
    
    public Vector4d(Vector4d v) {
        super(v);
        w = v.w;
    }
    
    public double getW() {
        return w;
    }
    
    public void setW(double w) {
        this.w = w; 
    }
    
    public void opposite() {
        super.opposite();
        w = -w;
    }
    
    public void add(Vector4d v) {
        super.add(v);
        w += v.w;
    }
    
    public void subtract(Vector4d v) {
        super.subtract(v);
        w += v.w;
    }
    
    @Override
    public void scale(double k) {
        super.scale(k);
        w *= k;
    }
    
    public double dot(Vector4d v) {
        return super.dot(v) + w * v.w;
    }
    
    // Cross-product is illegal in any space beyond R3
    @Override
    public final void cross(Vector3d v) {
        throw new UnsupportedOperationException(
                "Only 3D vectors can be cross-multiplied");
    }
    
    @Override
    public final double triple(Vector3d v, Vector3d w) {
        throw new UnsupportedOperationException("Only 3D vectors have a triple "
                + "product");
    }
    
    @Override
    public double norm() {
        return Math.sqrt(super.norm() + w * w);
    }
    
    @Override
    public void normalize() {
        scale(1.0 / norm());
    }
    
    @Override
    public boolean isUnit() {
        return norm() == 1.0;
    }
    
    public double distanceTo(Vector4d v) {
        Vector4d u = new Vector4d(this);
        u.subtract(v);
        return u.norm();
    }
    
    @Override
    public String toString() {
        return super.toString() + ", " + w;
    }
}

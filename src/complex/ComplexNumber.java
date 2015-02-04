package complex;
import real.Vector2d;

/**
 *
 * @author Dan Noonan
 */

// See real.Real for inheritance hierarchy
public class ComplexNumber extends Vector2d implements Complex {
    
    // Mathematical constant i (sqrt of -1)
    public static final ComplexNumber I = new ComplexNumber(0, 1);
    
    public ComplexNumber() {}
    
    public ComplexNumber(double x, double y) {
        super(x, y);
    }
    
    public ComplexNumber complexFromPolar(double radius, double angle) {
        return new ComplexNumber(radius * Math.cos(angle),
                radius * Math.sin(angle));
    }
    
    public double getReal() {
        return getX();
    }
    
    public double getComplex() {
        return getY();
    }
    
    @Override
    public void conjugate() {
        setY(-getY());
    }

    @Override
    public void multiply(Complex number) {
        if (number instanceof ComplexNumber) {
            double x = getX(),
                   y = getY();
            ComplexNumber c = (ComplexNumber)number;
            setX(x * c.getX() - y * c.getY());
            setY(y * c.getX() + x * c.getY());
        } else {
            throw new UnsupportedOperationException("Only complex numbers may "
                    + "be multiplied with complex numbers!");
        }       
    }   
}

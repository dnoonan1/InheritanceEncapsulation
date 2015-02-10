package drawable;

/**
 *
 * @author      Dan Noonan
 * @version     1.00
 */
public abstract class Shape implements Drawable {
    
    public abstract double getArea();
    
    @Override
    public final String getProperty() {
        return String.format("area = %.2f", getArea());
    }
    
}

package drawable;

/**
 * Drawable is a simple interface which is to be implemented by a class that
 * requires a draw() method. Additionally, this version has a getProperty()
 * method which is included only for sample purposes.
 * 
 * @author      Dan Noonan
 * @version     1.00
 * @see         Shape, Text, ParametricCurve2d, Startup (for sample usage)
 */
public interface Drawable {
    public abstract void draw();
    public abstract String getProperty();
}

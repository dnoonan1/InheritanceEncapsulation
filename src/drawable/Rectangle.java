package drawable;

import real.Vector2d;

/**
 *
 * @author Dan
 */
public class Rectangle extends Shape {
    
    private Vector2d corner1;
    private Vector2d corner2;

    // Default: rectangle from (-1, -1) to (1, 1)
    public Rectangle() {
        this(-1.0, -1.0,  1.0, 1.0);
    }
    
    public Rectangle(Vector2d corner1, Vector2d corner2) {
        this.corner1 = corner1;
        this.corner2 = corner2;
    }
    
    // Encapsulation
    public Rectangle(double x1, double y1,double x2, double y2) {
        this(new Vector2d(x1, y1), new Vector2d(x2, y2));
    }

    public final double getWidth() {
        return Math.abs(corner1.getX() - corner2.getX());
    }
    
    public final double getLength() {
        return Math.abs(corner1.getY() - corner2.getY());
    }
    
    @Override
    public final double getArea() {
        return getWidth() * getLength();
    }

    @Override
    public void draw() {
        System.out.printf("Drawing rectangle from (%s) to (%s)\n",
                corner1, corner2);
    }
    
}

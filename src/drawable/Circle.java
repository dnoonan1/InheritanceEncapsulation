package drawable;

import real.Vector2d;

/**
 *
 * @author Dan
 */
public class Circle extends Shape {
    // Fields
    private Vector2d center;
    private double radius;

    // Default: circle centered at origin, radius 1
    public Circle() {
        center = new Vector2d(0.0, 0.0);
        radius = 1.0;
    }
    
    public Circle(Vector2d center, double radius) {
        this.center = center;
        this.radius = radius;
    }
    
    // Encapsulation
    public Circle(double x, double y, double radius) {
        this(new Vector2d(x, y), radius);
    }
    
    /* Methods Unique to Circle */
    public final double getDiameter() {
        return 2 * radius;
    }
    
    public final double getCircumference() {
        return Math.PI * getDiameter();
    }
    
    @Override
    public final double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public final void draw() {
        System.out.printf("Drawing a circle: center = (%s); radius = %.1f\n",
                center, radius);
    }

}

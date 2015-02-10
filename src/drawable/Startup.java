package drawable;

import real.Vector2d;

/**
 *
 * @author Dan
 */
public class Startup {
    
    public static void main(String[] args) {
        
        // Demonstrate vector math
        Vector2d u, v, w;
        u = new Vector2d(1.0, 2.0);
        v = new Vector2d(3.0, 4.0);
        w = new Vector2d(u);
        w.add(v);
        
        // Print results
        System.out.printf("u = (%s)\nv = (%s)\nu + v = (%s)\n\n", u, v, w);
        
        // Demonstrate Drawable
        Drawable[] stuff = {
            new Circle(), new Rectangle(), new Text("Hello!"), new Line2d()
            //new CubicBezierSegment2d(0.0, 0.0,  0.0, 1.0,  1.0, 1.0,  1.0, 0.0)
        };
        
        for (Drawable thing : stuff) {
            thing.draw();
            System.out.println("\t" + thing.getProperty());
        }
        
    }
    
}

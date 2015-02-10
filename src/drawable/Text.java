package drawable;

/**
 *
 * @author      Dan Noonan
 * @version     1.00
 */
public class Text implements Drawable {
    
    private String value;

    public Text(String value) {
        setValue(value);
    }

    public final String getValue() {
        return value;
    }

    public final void setValue(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("value cannot be null or the "
                    + "empty string");
        }
        this.value = value;
    }
    
    @Override
    public final void draw() {
        System.out.println("Drawing text: " + value);
    }
    
    @Override
    public final String getProperty() {
        return "text-length: " + value.length();
    }
    
}

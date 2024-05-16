package Factory;

import Product.Circle;
import Product.Rectangle;
import Product.Shape;
import Product.Triangle;

public class ShapeFactory {
    public static Shape createShape(String type) throws Exception {
        if ("Circle".equals(type)) {
            return new Circle();
        } else if ("Triangle".equals(type)) {
            return new Triangle();
        } else if ("Rectangle".equals(type)) {
            return new Rectangle();
        } else {
            throw new Exception("UnSupportedShapeException");
        }
    }
}

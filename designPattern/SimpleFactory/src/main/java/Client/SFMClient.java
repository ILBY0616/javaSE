package Client;

import Factory.ShapeFactory;
import Product.Shape;
import Util.SFMXMLUtil;

public class SFMClient {
    public static void main(String[] args) {
        try {
            Shape shape;
            String type = SFMXMLUtil.getBean();
            if (type != null) {
                shape = ShapeFactory.createShape(type);
                shape.draw();
                shape.erase();
            }
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }
}

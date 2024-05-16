package Product;

public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("drawRectangle");
    }

    @Override
    public void erase() {
        System.out.println("eraseRectangle");
    }
}

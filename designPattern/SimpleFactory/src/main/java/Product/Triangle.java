package Product;

public class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("drawTriangle");
    }

    @Override
    public void erase() {
        System.out.println("eraseTriangle");
    }
}

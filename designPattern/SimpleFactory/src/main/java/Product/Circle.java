package Product;

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("drawCircle");
    }

    @Override
    public void erase() {
        System.out.println("eraseCircle");
    }
}

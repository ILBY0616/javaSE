package objectOriented;

public class Rectangle extends Graph {
    private double a, b;

    public Rectangle(double x, double y, double a, double b) {
        super(x, y);
        this.a = a;
        this.b = b;
    }

    protected void changeLength(double length) {
        this.a = length;
    }

    protected void changeWidth(double width) {
        this.b = width;
    }

    public double area() {
        return a * b;
    }
}

package objectOriented;

public class Ellipse extends Graph {
    private double a, b;

    public Ellipse(double x, double y, double a, double b) {
        super(x, y);
        this.a = a;
        this.b = b;
    }

    protected void changeA(double a) {
        this.a = a;
    }

    protected void changeB(double b) {
        this.b = b;
    }

    public double area() {
        return Math.PI * a * b;
    }
}

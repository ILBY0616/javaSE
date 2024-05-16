package objectOriented;

public class Square extends Graph {
    private double length;

    public Square(double x, double y, double length) {
        super(x, y);
        this.length = length;
    }

    protected void changeLength(double length) {
        this.length = length;
    }

    public double area() {
        return length * length;
    }
}

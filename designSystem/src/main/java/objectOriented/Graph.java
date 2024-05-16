package objectOriented;

public abstract class Graph {
    protected double x, y;

    protected Graph(double x, double y) {
        this.x = x;
        this.y = y;
    }

    protected void changeX(double x) {
        this.x = x;
    }

    protected void changeY(double y) {
        this.y = y;
    }

    public abstract double area();
}


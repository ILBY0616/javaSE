package objectOriented;

public class Area {
    public static void main(String[] args) {
        Circle c = new Circle(1, 1, 3);
        Square s = new Square(2, 2, 4);
        Rectangle r = new Rectangle(12, 9, 1, 2);
        Ellipse e = new Ellipse(2, -1, 3, 2);

        System.out.println("圆 c 的面积是 " + c.area());
        System.out.println("正方形 s 的面积是 " + s.area());
        System.out.println("矩形 r 的面积是 " + r.area());
        System.out.println("椭圆 e 的面积是 " + e.area());
    }
}



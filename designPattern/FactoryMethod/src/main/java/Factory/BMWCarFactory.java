package Factory;

import Product.BMWCar;
import Product.Car;

public class BMWCarFactory implements CarFactory {
    @Override
    public Car makeCar() {
        System.out.println("宝马汽车生产成功！");
        return new BMWCar();
    }
}

package Factory;

import Product.BENZCar;
import Product.Car;

public class BENZCarFactory implements CarFactory{
	@Override
	public Car makeCar() {
		System.out.println("奔驰汽车生产成功！");
		return new BENZCar();
	}
}

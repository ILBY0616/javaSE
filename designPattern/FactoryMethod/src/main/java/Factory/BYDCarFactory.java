package Factory;

import Product.BYDCar;
import Product.Car;

public class BYDCarFactory implements CarFactory{
	@Override
	public Car makeCar() {
		System.out.println("比亚迪电动车生产成功！");
		return new BYDCar();
	}
}

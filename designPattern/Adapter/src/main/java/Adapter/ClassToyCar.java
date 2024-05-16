package Adapter;

import Adaptee.ClassToy;
import AdaptiveTarget.ClassCar;

public class ClassToyCar extends ClassToy implements ClassCar {
    @Override
    public void run() {
        super.flash();
        super.sound();
        System.out.println("跑跑");
    }
}

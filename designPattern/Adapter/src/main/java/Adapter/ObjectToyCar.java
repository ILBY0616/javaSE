package Adapter;

import Adaptee.ObjectToy;
import AdaptiveTarget.ObjectCar;

public class ObjectToyCar extends ObjectCar {
    ObjectToy objectToy = new ObjectToy();

    @Override
    public void run() {
        objectToy.flash();
        objectToy.sound();
        System.out.println("跑跑");
    }
}

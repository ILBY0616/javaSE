package Decorator;

import Component.Phone;

public class ShakePhone extends SeniorPhone {
    public ShakePhone(Phone phone) {
        super(phone);
        System.out.println("高级手机");
    }

    public void sound() {
        super.sound();
        this.shake();
    }

    public void shake() {
        System.out.println("产生振动");
    }
}

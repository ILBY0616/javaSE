package Decorator;

import Component.Phone;

public class FlashPhone extends SeniorPhone{
    public FlashPhone(Phone phone) {
        super(phone);
        System.out.println("超级手机");
    }
    public void sound() {
        super.sound();
        this.flash();
    }
    public void flash() {
        System.out.println("散发灯光");
    }
}

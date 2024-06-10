package Decorator;

import Component.Phone;

public class SeniorPhone implements Phone {
    private final Phone phone;

    public SeniorPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void sound() {
        this.phone.sound();
    }
}

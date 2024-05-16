package Client;

import Component.JuniorPhone;
import Component.Phone;
import Decorator.FlashPhone;
import Decorator.ShakePhone;

public class DMClient {
    public static void main(String[] args) {
        Phone juniorPhone,seniorPhone,superPhone;

        System.out.println("--------");
        juniorPhone = new JuniorPhone();
        juniorPhone.sound();

        System.out.println("--------");
        seniorPhone = new ShakePhone(juniorPhone);
        seniorPhone.sound();

        System.out.println("--------");
        superPhone = new FlashPhone(seniorPhone);
        superPhone.sound();
    }
}

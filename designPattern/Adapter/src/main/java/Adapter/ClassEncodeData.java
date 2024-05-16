package Adapter;

import Adaptee.ClassEncode;
import AdaptiveTarget.ClassData;

public class ClassEncodeData extends ClassEncode implements ClassData {

    @Override
    public void add() {
        super.encodeDate();
        System.out.println("add");
    }

    @Override
    public void delete() {
        super.encodeDate();
        System.out.println("delete");
    }

    @Override
    public void update() {
        super.encodeDate();
        System.out.println("update");
    }

    @Override
    public void find() {
        super.encodeDate();
        System.out.println("find");
    }
}

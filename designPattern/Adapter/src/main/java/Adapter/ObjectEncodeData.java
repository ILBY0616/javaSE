package Adapter;

import Adaptee.ObjectEncode;
import AdaptiveTarget.ObjectData;

public class ObjectEncodeData extends ObjectData {

    private final ObjectEncode objectEncode = new ObjectEncode();

    @Override
    public void add() {
        objectEncode.encodeDate();
        System.out.println("add");
    }

    @Override
    public void delete() {
        objectEncode.encodeDate();
        System.out.println("delete");
    }

    @Override
    public void update() {
        objectEncode.encodeDate();
        System.out.println("update");
    }

    @Override
    public void find() {
        objectEncode.encodeDate();
        System.out.println("find");
    }
}

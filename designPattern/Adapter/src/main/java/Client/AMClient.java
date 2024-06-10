package Client;

import AdaptiveTarget.ClassCar;
import AdaptiveTarget.ClassData;
import AdaptiveTarget.ObjectCar;
import AdaptiveTarget.ObjectData;
import Util.AMXMLUtil;

import java.util.List;

public class AMClient {
    public static void main(String[] args) {
        List<Object> beans = AMXMLUtil.getBeans();
        adapterToyCar(beans);
        adapterEncodeData(beans);
    }

    public static void adapterToyCar(List<Object> list) {
        // 获取第一个对象
        System.out.println("类适配器模式");
        ClassCar classCar = (ClassCar) list.get(0);
        classCar.run();


        // 获取第二个对象
        System.out.println("对象适配器模式");
        ObjectCar objectCar = (ObjectCar) list.get(1);
        objectCar.run();
    }

    public static void adapterEncodeData(List<Object> list) {
        // 获取第三个对象
        System.out.println("类适配器模式");
        ClassData classData = (ClassData) list.get(2);
        classData.add();
        classData.delete();
        classData.update();
        classData.find();

        // 获取第四个对象
        System.out.println("对象适配器模式");
        ObjectData objectData = (ObjectData) list.get(3);
        objectData.add();
        objectData.delete();
        objectData.update();
        objectData.find();
    }
}

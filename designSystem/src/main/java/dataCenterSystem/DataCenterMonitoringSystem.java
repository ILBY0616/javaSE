package dataCenterSystem;

import java.util.ArrayList;
import java.util.List;

// 抽象观察者
interface Observer {
    void update(Subject subject);
}

// 抽象主题
abstract class Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }
}

// 具体主题 - 温度传感器
class TemperatureSensor extends Subject {
    private final double threshold;
    private double temperature;

    public TemperatureSensor(double threshold) {
        this.threshold = threshold;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
        checkTemperature();
    }

    private void checkTemperature() {
        if (temperature >= threshold) {
            this.notifyObservers();
        }
    }
}

// 具体观察者 - 警示灯
class WarningLight implements Observer {
    @Override
    public void update(Subject subject) {
        if (subject instanceof TemperatureSensor) {
            TemperatureSensor sensor = (TemperatureSensor) subject;
            System.out.println("警示灯闪烁: 当前温度 = " + sensor.getTemperature() + "°C");
        }
    }
}

// 具体观察者 - 报警器
class Alarm implements Observer {
    @Override
    public void update(Subject subject) {
        if (subject instanceof TemperatureSensor) {
            TemperatureSensor sensor = (TemperatureSensor) subject;
            System.out.println("报警器发出警报: 当前温度 = " + sensor.getTemperature() + "°C");
        }
    }
}

// 具体观察者 - 安全门
class EmergencyDoor implements Observer {
    @Override
    public void update(Subject subject) {
        if (subject instanceof TemperatureSensor) {
            TemperatureSensor sensor = (TemperatureSensor) subject;
            System.out.println("安全门开启: 当前温度 = " + sensor.getTemperature() + "°C");
        }
    }
}

// 具体观察者 - 隔热门
class FireDoor implements Observer {
    @Override
    public void update(Subject subject) {
        if (subject instanceof TemperatureSensor) {
            TemperatureSensor sensor = (TemperatureSensor) subject;
            System.out.println("隔热门关闭: 当前温度 = " + sensor.getTemperature() + "°C");
        }
    }
}

// 测试代码
public class DataCenterMonitoringSystem {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor(30.0);

        WarningLight light = new WarningLight();
        Alarm alarm = new Alarm();
        EmergencyDoor door = new EmergencyDoor();
        FireDoor fireDoor = new FireDoor();

        sensor.attach(light);
        sensor.attach(alarm);
        sensor.attach(door);
        sensor.attach(fireDoor);

        sensor.setTemperature(28.0);  // 不会触发任何响应
        sensor.setTemperature(32.0);  // 会触发所有响应设备
    }
}


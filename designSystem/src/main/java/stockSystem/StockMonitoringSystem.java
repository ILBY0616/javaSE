package stockSystem;

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

// 具体主题 - 股票
class Stock extends Subject {
    private String stockName;
    private double price;
    private double previousPrice;

    public Stock(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        this.previousPrice = price;
    }

    public String getStockName() {
        return stockName;
    }

    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.previousPrice = this.price;
        this.price = price;
        checkPriceChange();
    }

    private void checkPriceChange() {
        double changePercentage = Math.abs(price - previousPrice) / previousPrice;
        if (changePercentage >= 0.05) {
            this.notifyObservers();
        }
    }
}

// 具体观察者 - 股民
class ConcreteInvestor implements Observer {
    private final String name;

    public ConcreteInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(Subject subject) {
        if (subject instanceof Stock) {
            Stock stock = (Stock) subject;
            System.out.println("提示股民:" + name);
            System.out.println("--------股票:" + stock.getStockName());
            System.out.println("--------价格波动幅度超过5%");
            System.out.println("新价格是:" + stock.getPrice());
            System.out.println("=======================");
        }
    }
}

// 测试代码
public class StockMonitoringSystem {
    public static void main(String[] args) {
        Stock stock = new Stock("ABC", 100);

        ConcreteInvestor investor1 = new ConcreteInvestor("张三");
        ConcreteInvestor investor2 = new ConcreteInvestor("李四");

        stock.attach(investor1);
        stock.attach(investor2);

        stock.setPrice(104);  // 不会触发通知
        stock.setPrice(110);  // 会触发通知
        stock.setPrice(100);  // 会触发通知
    }
}


package Client;

import Factory.CarFactory;
import Product.Car;
import Util.FMMXMLUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class FMMClient {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            selectCar();
            makeCar();
        }
    }

    public static void selectCar() {
        System.out.println("Select Car,BYD or BMW or BENZ");
        Scanner scanner = new Scanner(System.in);
        String selectedCar = scanner.nextLine();
        try {
            // 找到文件
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("designPattern/FactoryMethod/src/main/resources/config.xml"));

            // 更新文件
            NodeList nodeList = document.getElementsByTagName("className");
            Node node = nodeList.item(0).getFirstChild();
            node.setNodeValue(selectedCar + "CarFactory");

            // 保存文件
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("designPattern/FactoryMethod/src/main/resources/config.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }

    public static void makeCar() {
        try {
            Car car;
            CarFactory carFactory;
            carFactory = (CarFactory) FMMXMLUtil.getBean();
            if (carFactory != null) {
                car = carFactory.makeCar();
                car.run();
            }
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }
}

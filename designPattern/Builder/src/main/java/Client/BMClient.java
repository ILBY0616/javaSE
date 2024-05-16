package Client;

import Builder.PatternBuilder;
import Director.PatternDirector;
import Product.Pattern;
import Util.BMXMLUtil;
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

public class BMClient {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            selectPattern();
            makePattern();
        }
    }

    public static void selectPattern() {
        System.out.println("Select Pattern,Simple or Pastoral or Grand");
        Scanner scanner = new Scanner(System.in);
        String selectedCar = scanner.nextLine();
        try {
            // 找到文件
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("designPattern/Builder/src/main/resources/config.xml"));

            // 更新文件
            NodeList nodeList = document.getElementsByTagName("className");
            Node node = nodeList.item(0).getFirstChild();
            node.setNodeValue(selectedCar + "PatternBuilder");

            // 保存文件
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("designPattern/Builder/src/main/resources/config.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }
    }

    public static void makePattern() {
        try {
            PatternBuilder patternBuilder = (PatternBuilder) BMXMLUtil.getBean();
            PatternDirector patternDirector = new PatternDirector();
            if (patternBuilder != null) {
                patternDirector.setPatternBuilder(patternBuilder);
                Pattern pattern = patternDirector.constructPattern();
                System.out.print("装修方案 ");
                System.out.print(pattern.getTile() + " ");
                System.out.print(pattern.getCoat() + " ");
                System.out.print(pattern.getFloor() + " ");
                System.out.println(pattern.getCeiling() + " ");
            }
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
        }

    }
}

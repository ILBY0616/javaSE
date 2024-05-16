package Util;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class SFMXMLUtil {
    public static String getBean() {
        try {
            // 找到文件
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document;
            document = builder.parse(new File("designPattern/SimpleFactory/src/main/resources/config.xml"));

            // 找到类名
            NodeList nodeList = document.getElementsByTagName("className");
            Node node = nodeList.item(0).getFirstChild();

            // 返回类名
            return node.getNodeValue();
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
            return null;
        }
    }
}

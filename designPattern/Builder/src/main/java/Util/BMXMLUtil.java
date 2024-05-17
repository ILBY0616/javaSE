package Util;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Constructor;

public class BMXMLUtil {
	public static Object getBean() {
		try {
			// 找到文件
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document;
			document = builder.parse(new File("designPattern/Builder/src/main/resources/config.xml"));

			// 找到类名
			NodeList nodeList = document.getElementsByTagName("className");
			Node node = nodeList.item(0).getFirstChild();
			String className = "Builder." + node.getNodeValue();

			// 返回对象
			Class<?> newClass = Class.forName(className);
			Constructor<?> constructor = newClass.getConstructor();
			constructor.setAccessible(true);
            return constructor.newInstance();
		} catch (Exception exception) {
			System.out.println("error: " + exception.getMessage());
			return null;
		}
	}
}

package util;
import javax.xml.parsers.*;

import org.w3c.dom.*;
import org.xml.sax.*;

import java.io.*;

public class XMLUtil {
	public static Object getBean() throws ClassNotFoundException
	{
			DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = null;
			try {
				dBuilder = dFactory.newDocumentBuilder();
			} catch (ParserConfigurationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Document doc;
			try {
				doc = dBuilder.parse(new File("config.xml"));
				NodeList node = doc.getElementsByTagName("className");
				Node classNode = node.item(0).getFirstChild();
				String cName = classNode.getNodeValue();
				
				Class c = Class.forName(cName);
				Object obj = c.newInstance();
				return obj;
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return null;
			}		
	}
}

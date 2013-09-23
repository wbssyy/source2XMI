package util;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

public class DocumentFactory {
    public static Document getDocument() throws Exception{
	
   	DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
   	DocumentBuilder builder = dFactory.newDocumentBuilder();
   	Document document;
   	document = (Document) builder.parse(new File("property.xml"));           //指定解析的配置文件
   	
   	return document;
    }
}

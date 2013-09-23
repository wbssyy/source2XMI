package util;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class IOConfig {
    
    public static String getAnalyzedDir() throws Exception {
	String dirNameStr = getPropertyNode("inputAddress");    
	return dirNameStr;
    }
    
    public static String getOutputAddr() throws Exception{
	String outputAddress = getPropertyNode("outputAddress");    
	return outputAddress;
    }
    
    public static Object getAttrWriter() throws Exception {
   	Object object = getObject("attributeInfoWriter"); 
   	return object;
    }
    
    public static Object getMethodWriter() throws Exception {
   	Object object = getObject("methodInfoWriter"); 
   	return object;
    }
    
    private static Object getObject(String nodeName) throws Exception {
	
   	String objectName = getPropertyNode(nodeName);  
   	Object object = Class.forName(objectName).newInstance();
   	System.out.println(object.getClass());
   	return object;
    }
    
    private static String getPropertyNode(String nodeName) throws Exception{
	
	Document document = DocumentFactory.getDocument();
	NodeList nodeList = document.getElementsByTagName(nodeName);
	Node dirNode = (Node) nodeList.item(0).getFirstChild();
	String nodeValue = dirNode.getNodeValue().trim(); 
	
	return nodeValue;
    }
   
}

package xmiio;

import java.util.ArrayList;

import bean.AbstractType;
import bean.AttributeInfo;
import bean.ClassInfo;

public class AttributeWriter extends AbstractXMIWriter{
    @Override
    public StringBuffer writeXMI(ArrayList<AbstractType> abstractTypes, StringBuffer resultString) {
	// TODO Auto-generated method stub
	
		for (int i = 0; i < abstractTypes.size(); i++) {
		  
		    AttributeInfo attributeInfo = (AttributeInfo)abstractTypes.get(i);
		    resultString.append("\n  ");
			String attrName = attributeInfo.getAttrName();
			String attrId = attributeInfo.getAttrID();
			String attrType = attributeInfo.getAttrType();
			String attrVisibility = attributeInfo.getVisibility();
			String attrModifiers = attributeInfo.getModifiers();
			String attrInitialValue = attributeInfo.getInitialValue();
		    
			resultString.append("<ownedAttribute xmi:id=\"" + attrId
				+ "\" name=\"" + attrName
				+ "\" visibility=\"" + attrVisibility
				+ "\" type=\"" + attrType + "\"");
		    
			if (attrModifiers.contains("static")) {
			    resultString.append(" isStatic=\"true\"");
			}
		    	resultString.append(">");
		    	resultString.append("\n  </ownedAttribute>");
		    
		}
		
		return resultString;
    }
}

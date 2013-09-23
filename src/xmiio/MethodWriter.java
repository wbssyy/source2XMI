package xmiio;

import java.util.ArrayList;

import bean.AbstractType;
import bean.ClassInfo;
import bean.MethodInfo;
import bean.ParameterInfo;

public class MethodWriter extends AbstractXMIWriter{

    @Override
    public StringBuffer writeXMI(ArrayList<AbstractType> abstractTypes, StringBuffer resultString) {
	// TODO Auto-generated method stub	   
		   
		    for (int i = 0; i < abstractTypes.size(); i++) {
			MethodInfo methodInfo = (MethodInfo)abstractTypes.get(i);
			resultString.append("\n  ");
			String methodName = methodInfo.getMethodName();
			String methodId = methodInfo.getMethodId();
			String methodBody = methodInfo.getMethodBody();
			String methodVisibility = methodInfo.getVisibility();
			String methodModifers = methodInfo.getModifiers();
			String methodReturnType = methodInfo.getReturnType();
			ArrayList<ParameterInfo> methodParameters = (ArrayList<ParameterInfo>) 
				methodInfo.getParameterList();
		    
			resultString.append("<ownedOperation xmi:id=\"" + methodId
				+ "\" name=\"" + methodName
				+ "\" visibility=\"" + methodVisibility 
				+ "\">");
			
			
			if (methodBody != null) {
			    resultString.append("\n    ");
			    resultString.append("<bodyCondition xmi:type=\"uml:Constraint\" xmi:id=\"" + "body_" + methodId
				+ "\">\n"
				+ "      <specification xmi:type=\"uml:OpaqueExpression\" xmi:id=\"" 
				+ "\" body=\"" + methodBody
				+ "\"/>\n    " + "</bodyCondition>");
			}
		    
			for (int k = 0; k < methodParameters.size(); k++) {
			    resultString.append("\n    ");
			    resultString.append("<ownedParameter xmi:id=\"" + methodParameters.get(k).getParaID()
				+ "\" name=\"" + methodParameters.get(k).getParaName()
				+ "\" direction=\"in\" type=\"" + methodParameters.get(k).getParaType()
				+ "\"/>");
			}
		    
		   	resultString.append("\n    ");
		   	resultString.append("<ownedParameter xmi:id=\"" + "return_" + methodId
		   		+ "\" name=\"" + methodName
		   		+ "\" direction=\"return\" type=\"" + methodReturnType
		   		+ "\"/>");
		   	resultString.append("\n  ");
		   	resultString.append("</ownedOperation>");
		    }
		
		return resultString;
    }
    
}

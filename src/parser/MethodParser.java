package parser;

import java.util.ArrayList;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import bean.AbstractType;
import bean.ClassInfo;
import bean.MethodInfo;
import bean.ParameterInfo;

public class MethodParser extends AbstractParser{
    private static int methodNum = 0; 

    @Override
    public AbstractType parserOpera(ASTNode astNode, AbstractType abstractType) {
	// TODO Auto-generated method stub
	ClassInfo classInfo = (ClassInfo)abstractType;
	TypeDeclaration node = (TypeDeclaration)astNode;
	MethodDeclaration[] methoDeclaration = node.getMethods();
	ArrayList<MethodInfo> methodInfoList = new ArrayList<MethodInfo>();
	    
	for (int i = 0; i < methoDeclaration.length; i++) {
	    MethodInfo methodInfo = new MethodInfo();
	   
	    //获取修饰符列表
	    methodInfo.setModifiers(methoDeclaration[i].modifiers().toString());
	    
	    //获取所在类的ID
	    methodInfo.setClassId(classInfo.getClassId());
	    
	    //获取方法名
	    methodInfo.setMethodName(methoDeclaration[i].getName().toString());
	    
	    //获取方法的ID
	    methodInfo = (MethodInfo)generateId(methodInfo);
	    
	    //获取方法的方法体
	    if (methoDeclaration[i].getBody() != null) {
		String methodBodyString = methoDeclaration[i].getBody().toString();
		methodBodyString = methodBodyString.replaceAll("\n", "&#xA;");
		methodBodyString = methodBodyString.replaceAll("\"", "&quot;");
		methodBodyString = methodBodyString.replaceAll("\t", "&#x9;");
		methodInfo.setMethodBody(methodBodyString);
		//methodInfo.getMethodBody().replaceAll("\n", "&#xA;");
	    }
	    
	    //获取方法的参数列表
	    ArrayList<ParameterInfo> parameterList = new ArrayList<ParameterInfo>();
	    for (int j = 0; j < methoDeclaration[i].parameters().size(); j++) {
		
		ParameterInfo parameterInfo = new ParameterInfo();
		String paraName = "", paraType = "";
		
		paraName = ((SingleVariableDeclaration)methoDeclaration[i].
			parameters().get(j)).getName().toString();
		paraType = ((SingleVariableDeclaration)methoDeclaration[i].
			parameters().get(j)).getType().toString();
		
		parameterInfo.setParaName(paraName);
		parameterInfo.setParaType(paraType);
		parameterInfo.setParaID(methodInfo.getMethodId() + "_" + paraName);
		
		parameterList.add(parameterInfo);
	    }
	    methodInfo.setParameterList(parameterList);
	    
	    //获取返回值类型
	    if (methoDeclaration[i].getReturnType2() != null) {
		methodInfo.setReturnType(methoDeclaration[i].getReturnType2().toString());
	    }
	    
	    methodInfoList.add(methodInfo);
	}
	
	methodNum = 0;
	
	//输出测试
//	for (int i = 0; i < methodInfoList.size(); i++) {
//	    System.out.println(methodInfoList.get(i).getClassId());
//	    System.out.println(methodInfoList.get(i).getModifiers());
//	    System.out.println(methodInfoList.get(i).getMethodName());
//	    System.out.println(methodInfoList.get(i).getMethodId());
//	    for (int j = 0; j < methodInfoList.get(i).getParameterList().size(); j++) {
//		System.out.print(((ParameterInfo)methodInfoList.get(i).getParameterList().get(j)).getParaName()
//			+ "    " + ((ParameterInfo)methodInfoList.get(i).getParameterList().get(j)).getParaType()
//			+ ", ");
//	    } System.out.println();
//	    System.out.println(methodInfoList.get(i).getMethodBody());
//	    System.out.println(methodInfoList.get(i).getReturnType());
//	}
	classInfo.setOperaList(methodInfoList);
	return classInfo;
    }

    @Override
    public AbstractType generateId(AbstractType abstractType) {
	// TODO Auto-generated method stub
	MethodInfo methodInfo = (MethodInfo)abstractType;
	methodInfo.setMethodId(methodInfo.getClassId() + "_" + 
		methodInfo.getMethodName() + "_" + methodNum++);
	return methodInfo;
    }

}

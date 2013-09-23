package xmiio;

import java.util.ArrayList;
import java.util.List;

import parser.GeneralizationParser;

import util.IOConfig;
import util.OutputUtil;
import util.XMLUtil;
import xmiio.*;
import bean.*;

public class XMIWriter extends AbstractXMIWriter{

    @Override
    public StringBuffer writeXMI(ArrayList<AbstractType> classInfoList, StringBuffer resultString) {
	// TODO Auto-generated method stub
	AbstractXMIWriter attrWriter = null, methodWriter = null;
	try {
	    attrWriter = (AbstractXMIWriter) IOConfig.getAttrWriter(); 
	    methodWriter = (AbstractXMIWriter) IOConfig.getMethodWriter();  
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	for (int i = 0; i < classInfoList.size(); i++) {
	    ClassInfo classInfo = (ClassInfo)classInfoList.get(i);
	    String className = classInfo.getClassName();
	    String classId = classInfo.getClassId();
	    String classType = classInfo.getClassType();
	    String visibility = classInfo.getVisibility();
	    String packageName = classInfo.getPackageName();
	    String superClass = classInfo.getSuperClassName();
	    ArrayList<AttributeInfo> attributeInfos = (ArrayList<AttributeInfo>) classInfo.getAttrList();
	    ArrayList<MethodInfo> methodInfos = (ArrayList<MethodInfo>) classInfo.getOperaList();
	    
//	    List<String> packageList = classInfo.getImportedPackages();
//	    if (packageList != null) {
//		for (int j = 0; j < packageList.size(); j++) {
//			System.out.println("bbbbbbbb" + packageList.get(j));
//		    }
//	    }
	    
	    //生成类的基本信息的xmi文件内容
	    resultString.append("<packagedElement xmi:type=\"uml:Class\" xmi:id=\""+ classId
		    +"\" name=\"" + className 
		    + "\" visibility=\"" + visibility + "\"");
	    if (classType != null && classType.contains("abstract")) {
		resultString.append(" isAbstract=\"true\"");
	    }
	    
	    //如果类中不包含属性和方法
	    if(attributeInfos.size() == 0 && methodInfos.size() == 0 && superClass == null) {
		resultString.append("/>");
	    } else {
		resultString.append(">");
		
		  //如果该类存在父类
		    if (superClass != null) {
			GeneralizationParser relationParser = new GeneralizationParser();
			RelationInfo relationInfo = new RelationInfo();
			relationInfo = (RelationInfo)relationParser.parseRelation(classInfoList, classInfo);
			resultString.append("\n  ");
			resultString.append("<generalization xmi:type=\"uml:Generalization\" xmi:id=\"" + relationInfo.getRelationID()
				+ "\" general=\"" + relationInfo.getObjactB() 
				+ "\"/>");
		    }
		
		 //如果属性列表不为空，则逐个读取属性信息并输出
		 if (attributeInfos.size() > 0) {
		     ArrayList<AbstractType> abstractTypes = new ArrayList<AbstractType>();
		     for (int j = 0; j < attributeInfos.size(); j++) {
			 abstractTypes.add(attributeInfos.get(j));
		     }
		     if (attrWriter != null) {
			 resultString = attrWriter.writeXMI(abstractTypes, resultString);
		     }
		 }	    
		    
		  //如果类的方法列表不为空，则逐个读取方法的信息并输出
		 if (methodInfos.size() > 0) {
		     ArrayList<AbstractType> abstractTypes = new ArrayList<AbstractType>();
		     for (int j = 0; j < methodInfos.size(); j++) {
			 abstractTypes.add(methodInfos.get(j));
		     }
		     if (methodWriter != null) {
			 resultString = methodWriter.writeXMI(abstractTypes, resultString);
		     }
		 }  
		    resultString.append("\n</packagedElement>\n");	
	    }
	    
	    if (resultString.length() > 16012345) {
		try {
	   	    //long time = System.currentTimeMillis();
		    OutputUtil.outputToXML(resultString.toString());
		   // System.out.println("时间：" + (System.currentTimeMillis()-time));
		    resultString.delete(0, resultString.length());
		} catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	    }
	}
	
	if (resultString.length()>0) {
	    try {
		    OutputUtil.outputToXML(resultString.toString());
		} catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	}
	
	return resultString;
    }
}

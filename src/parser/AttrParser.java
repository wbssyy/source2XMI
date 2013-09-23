package parser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import bean.AbstractType;
import bean.AttributeInfo;
import bean.ClassInfo;

public class AttrParser extends AbstractParser{

    @Override
    public AbstractType parserOpera(ASTNode astNode, AbstractType abstractType) {
	// TODO Auto-generated method stub
	//装配类的属性相关的信息
	TypeDeclaration node = (TypeDeclaration)astNode;
	FieldDeclaration[] field = node.getFields();
	ClassInfo classInfo = (ClassInfo)abstractType;
	
//	System.out.println("field: "+field.length);
	ArrayList<AttributeInfo> attributeInfoList = new ArrayList<AttributeInfo>();
	for (int i = 0; i < field.length; i++) {   
	    //获取属性的修饰符
	    List<String> modifiersList = new ArrayList<String>();
	    	modifiersList = field[i].modifiers();
		String attrType = field[i].getType().toString();
		    
		//获取属性名和（属性的初始值）
		for (int j = 0; j <field[i].fragments().size(); j++) {
			
		    String fieldString = field[i].fragments().get(j).toString();
		    AttributeInfo attributeInfo = new AttributeInfo();
			
		    if (field[i].fragments().get(j).toString().contains("=")) {	    
			for (int k = 0; k < fieldString.length(); k++) {
			    if (fieldString.charAt(k) == '=') {		
				attributeInfo.setAttrName(fieldString.substring(0, k));
				attributeInfo.setInitialValue(fieldString.substring(k+1,fieldString.length()));
			    }
			}
		    } else {
			attributeInfo.setAttrName(fieldString);
		    }
			attributeInfo.setAttrType(attrType);
			attributeInfo.setModifiers(modifiersList.toString());
			attributeInfo.setClassId(classInfo.getClassId());
			attributeInfo = (AttributeInfo)generateId(attributeInfo);
			attributeInfoList.add(attributeInfo);
		    }
	}
	
//	System.out.println(attributeInfoList.size());
//	for (int j = 0; j < attributeInfoList.size(); j++) {
//	    System.out.println("属性名："+attributeInfoList.get(j).getAttrName());
//	    System.out.println("属性id："+attributeInfoList.get(j).getAttrID());
//	    System.out.println("属性类型："+attributeInfoList.get(j).getAttrType());
//	    System.out.println("属性初始化："+attributeInfoList.get(j).getInitialValue());
//	    System.out.println("可见性："+attributeInfoList.get(j).getVisibility());
//	    System.out.println("修饰词："+attributeInfoList.get(j).getModifiers());
//	    System.out.println("属性所在类："+attributeInfoList.get(j).getClassId());
//	}
	classInfo.setAttrList(attributeInfoList);
	return classInfo;
    }

    @Override
    public AbstractType generateId(AbstractType abstractType) {
	// TODO Auto-generated method stub
	AttributeInfo attributeInfo = (AttributeInfo)abstractType;
	attributeInfo.setAttrID(attributeInfo.getClassId() + "_" + attributeInfo.getAttrName());
	return attributeInfo;
    }

}

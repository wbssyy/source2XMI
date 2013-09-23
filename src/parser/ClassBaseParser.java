package parser;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.WildcardType;

import util.OutputUtil;
import bean.AbstractType;
import bean.ClassInfo;

public class ClassBaseParser extends AbstractParser{
    private static int classNum = 0;

    @Override
    public ClassInfo parserOpera(ASTNode astNode, AbstractType abstractType) {
	// TODO Auto-generated method stub
	//装配ClassInfo的信息
	TypeDeclaration node = (TypeDeclaration)astNode;
	ClassInfo classInfo = new ClassInfo();
	classInfo = (ClassInfo)abstractType;
	classInfo.setClassName(node.getName().toString());
	if (classInfo.getPackageName() == null) {
	    classInfo.setPackageName("default");
	}
	
	//如果该类继承于另一个类，则获取父类的名字
	if (node.getSuperclassType() != null) {
	    classInfo.setSuperClassName(node.getSuperclassType().toString()); 
	    System.out.println("super class :" + node.getSuperclassType().toString());
	}
		
	if (node.modifiers().size() > 1) {
	    classInfo.setVisibility(node.modifiers().get(0).toString());
	    classInfo.setClassType(node.modifiers().get(1).toString());
	} else if (node.modifiers().size() == 1) {
	    		if (node.modifiers().get(0) != "abstract" && node.modifiers().get(0) != "final"
	    			&& node.modifiers().get(0) != "static") {
	    		    classInfo.setVisibility(node.modifiers().get(0).toString());
	    		    classInfo.setClassType("");
	    		} else {
	    		    classInfo.setVisibility("package");
	    		    classInfo.setClassType(node.modifiers().get(0).toString());
	    		}
		}
	classInfo = (ClassInfo)generateId(classInfo);
	
	return classInfo;
    }

    @Override
    public AbstractType generateId(AbstractType abstractType) {
	// TODO Auto-generated method stub
	ClassInfo classInfo = (ClassInfo)abstractType;
	classInfo.setClassId(classInfo.getPackageName()+"_"+classInfo.getClassName()+"_"+classNum++);
	return classInfo;
    }
}

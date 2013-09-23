package parser;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import bean.AbstractType;
import bean.ClassInfo;

public class ClassInfoBuilder {
    private static ArrayList<AbstractType> classInfoList = new ArrayList<AbstractType>();
    private ClassInfo classInfo = new ClassInfo();
    
    public void setImportPackages(ImportDeclaration node) {
	classInfo.setImportedPackages(node.getName().toString());
    }
    
    public void setPackageName(PackageDeclaration node) {
	classInfo.setPackageName(node.getName().toString());
    }
    
    public ArrayList<AbstractType> buildClassAllInfo(TypeDeclaration node) {
	
	AbstractParser classParser,attrParser,methodParser;	
	classParser = new ClassBaseParser();
	attrParser = new AttrParser();
	methodParser = new MethodParser();
	
	classInfo = (ClassInfo) classParser.parserOpera(node,classInfo);
	classInfo = (ClassInfo) attrParser.parserOpera(node,classInfo);
	classInfo = (ClassInfo) methodParser.parserOpera(node, classInfo);
	
	ClassInfo tempClassInfo = new ClassInfo();
	tempClassInfo = classInfo;
	classInfoList.add(tempClassInfo);
	
	return classInfoList;
    }
    
    public ArrayList<AbstractType> getAllClassInfos(){
	return classInfoList;
    }
}

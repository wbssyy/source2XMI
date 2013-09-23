package parser;

import java.util.ArrayList;

import bean.AbstractType;
import bean.ClassInfo;
import bean.RelationInfo;

public class GeneralizationParser extends RelationParser{
    private static int generalizationNum = 0;
    @Override
    public AbstractType parseRelation(ArrayList<AbstractType> classInfoList, AbstractType abstractType) {
	
	// TODO Auto-generated method stub
	
	//从所有类中提取继承关系
	RelationInfo generalization = new RelationInfo();
	
	ClassInfo classInfo = (ClassInfo)abstractType;
	String superClassName = classInfo.getSuperClassName();
	String superClassPackage = "";
	
	//找出父类名所对应的类的id
	for (int i = 0; i < classInfoList.size(); i++) {
	    ClassInfo temp = (ClassInfo) classInfoList.get(i);
	    if (temp.getClassName().equals(superClassName)) {
		superClassPackage = temp.getPackageName();
		
		for (int j = 0; j < classInfo.getImportedPackages().size(); j++) {
		    System.out.println(classInfo.getClassName());

		    if (classInfo.getImportedPackages().get(j).contains(superClassPackage) || 
			    classInfo.getPackageName().equals(superClassPackage)) {
			generalization.setRelationType("Generalization");
			generalization.setObjactA(classInfo.getClassId());
			generalization.setObjactB(temp.getClassId());
			generalization = (RelationInfo)generateRelationId(generalization);
			System.out.println(generalization.getObjactA()+"------"+generalization.getObjactB());
		    }
		}
	    }
	}
	return generalization;
    }

    @Override
    public AbstractType generateRelationId(AbstractType abstractType) {
	// TODO Auto-generated method stub
	RelationInfo relationInfo = (RelationInfo)abstractType;
	relationInfo.setRelationID(relationInfo.getRelationType() + "_" + (generalizationNum++));
	return relationInfo;
    }

}

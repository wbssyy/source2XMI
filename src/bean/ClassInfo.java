package bean;

import java.util.ArrayList;
import java.util.List;

import javax.management.loading.PrivateClassLoader;

public class ClassInfo extends AbstractType {
    private String className;
    private String classId;
    private List<AttributeInfo> attrList;
    private List<MethodInfo> operaList;
    private String visibility;
    private String classType;
    private String packageName;
    private String superClassName;
    private List<String> importedPackages;
  
    public List<String> getImportedPackages() {
        return importedPackages;
    }
    public void setImportedPackages(String packageName) {
	if (importedPackages == null) {
	    importedPackages = new ArrayList<String>();
	}
	importedPackages.add(packageName);   
    }
    public String getSuperClassName() {
        return superClassName;
    }
    public void setSuperClassName(String superClassName) {
        this.superClassName = superClassName;
    }
    public String getPackageName() {
        return packageName;
    }
    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public String getClassId() {
        return classId;
    }
    public void setClassId(String classId) {
        this.classId = classId;
    }
    public String getClassType() {
        return classType;
    }
    public void setClassType(String classType) {
        this.classType = classType;
    }
    public List<AttributeInfo> getAttrList() {
        return attrList;
    }
    public void setAttrList(List<AttributeInfo> attrList) {
        this.attrList = attrList;
    }
    public List<MethodInfo> getOperaList() {
        return operaList;
    }
    public void setOperaList(List<MethodInfo> operList) {
        this.operaList = operList;
    }
    public String getVisibility() {
        return visibility;
    }
    public void setVisibility(String visibility) {	
	    this.visibility = visibility;
    }
}

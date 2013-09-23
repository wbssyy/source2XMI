package bean;

import java.util.List;

public class AttributeInfo extends AbstractType{
    private String attrID;
    private String attrName;
    private String attrType;
    private String visibility;
    private String modifiers;
    private String initialValue;
    private String classId;

    public String getClassId() {
        return classId;
    }
    public void setClassId(String classId) {
        this.classId = classId;
    }
    public String getInitialValue() {
        return initialValue;
    }
    public void setInitialValue(String initialValue) {
        this.initialValue = initialValue;
    }
    public String getModifiers() {
        return modifiers;
    }
    public void setModifiers(String modifiers) {
        this.modifiers = modifiers;
    }
    public String getAttrID() {
        return attrID;
    }
    public void setAttrID(String attrID) {
        this.attrID = attrID;
    }
    public String getAttrName() {
        return attrName;
    }
    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }
    public String getAttrType() {
        return attrType;
    }
    public void setAttrType(String attrType) {
        this.attrType = attrType;
    }
    public String getVisibility() {
        return visibility;
    }
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
}

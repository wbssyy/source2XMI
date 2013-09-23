package bean;
import java.util.List;


public class MethodInfo extends AbstractType {
    private String classId;
    private String methodName;
    private String methodId;
    private List<ParameterInfo> parameterList;
    private String returnType;
    private String modifiers;
    private String visibility;
    private String keyInfo;
    private String methodBody;
    
    public String getModifiers() {
        return modifiers;
    }
    public void setModifiers(String modifiers) {
        this.modifiers = modifiers;
    }
    public String getMethodBody() {
        return methodBody;
    }
    public void setMethodBody(String methodBody) {
        this.methodBody = methodBody;
    }
    public String getClassId() {
        return classId;
    }
    public void setClassId(String classId) {
        this.classId = classId;
    }
    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    public String getMethodId() {
        return methodId;
    }
    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }
    public List<ParameterInfo> getParameterList() {
        return parameterList;
    }
    public void setParameterList(List<ParameterInfo> parameterList) {
        this.parameterList = parameterList;
    }
    public String getReturnType() {
        return returnType;
    }
    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }
    public String getVisibility() {
        return visibility;
    }
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }
    public String getKeyInfo() {
        return keyInfo;
    }
    public void setKeyInfo(String keyInfo) {
        this.keyInfo = keyInfo;
    }
}

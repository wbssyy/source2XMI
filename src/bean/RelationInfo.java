package bean;

public class RelationInfo extends AbstractType{
    private String relationID;
    private String relationName;
    private String relationType;
    private String objactA;
    private String objactB;
    public String getRelationName() {
        return relationName;
    }
    public void setRelationName(String relationName) {
        this.relationName = relationName;
    }
    public String getObjactA() {
        return objactA;
    }
    public void setObjactA(String objactA) {
        this.objactA = objactA;
    }
    public String getObjactB() {
        return objactB;
    }
    public void setObjactB(String objactB) {
        this.objactB = objactB;
    }
    public String getRelationType() {
        return relationType;
    }
    public void setRelationType(String relationType) {
        this.relationType = relationType;
    }
    public String getRelationID() {
        return relationID;
    }
    public void setRelationID(String relationID) {
        this.relationID = relationID;
    }
}

package parser;

import java.util.ArrayList;
import java.util.List;

import bean.AbstractType;

public abstract class RelationParser {
    
    public abstract AbstractType parseRelation(ArrayList<AbstractType> classInfoList, AbstractType abstractType);
    
    public abstract AbstractType generateRelationId(AbstractType abstractType);
}

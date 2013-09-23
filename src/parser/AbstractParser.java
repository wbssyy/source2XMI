package parser;

import org.eclipse.jdt.core.dom.ASTNode;

import bean.AbstractType;


public abstract class AbstractParser {
    public abstract AbstractType parserOpera(ASTNode astNode, AbstractType abstractType);
    public abstract AbstractType generateId(AbstractType abstractType);
}

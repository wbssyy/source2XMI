package testAST;

import java.util.ArrayList;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;

import parser.AbstractParser;
import parser.AttrParser;
import parser.ClassBaseParser;
import parser.ClassInfoBuilder;
import parser.MethodParser;

import bean.*;

public class MyJavaASTVisitor extends ASTVisitor {

    private ClassInfoBuilder classInfoBuilder = new ClassInfoBuilder();
    
    
    
    @Override
    public boolean visit(ImportDeclaration node) {
	// TODO Auto-generated method stub
	//System.out.println("999999"+ node.getName());
	classInfoBuilder.setImportPackages(node);
	return super.visit(node);
    }

    @Override
    public boolean visit(PackageDeclaration node) {
	// TODO Auto-generated method stub	
	classInfoBuilder.setPackageName(node);
	return super.visit(node);
    }

    @Override
    public boolean visit(TypeDeclaration node) { 
	// TODO Auto-generated method stub
	classInfoBuilder.buildClassAllInfo(node);
	return super.visit(node);
    }
}

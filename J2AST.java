

import java.io.BufferedInputStream;
import java.io.FileInputStream;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public abstract class J2AST {
    private ASTParser astParser = ASTParser.newParser(AST.JLS3);
    private static final String nameString = "hhh"  , syyName = "jjj";
    private int aa = 10  , bb = 20;
    
    public CompilationUnit getCompilationUnit(String fileName) {}
    public static class Inner{
    	private String name;
    	public static boolean setName(String name,String mm, int aa){
    		name = "ddd";
    		name+="sss";
    		for(int i=0 ; i<10 ; i++){
    			System.out.println(i);
    		}
    		return true;
    	}
    	
    	public static boolean setName(String name, int aa){
		name = "ddd";
		name+="sss";
		for(int i=0 ; i<10 ; i++){
			System.out.println(i);
		}
		return true;
	}
    }
}

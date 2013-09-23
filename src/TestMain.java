import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.CompilationUnit;

import parser.ClassInfoBuilder;

import testAST.J2AST;
import testAST.MyJavaASTVisitor;
import util.MultiDirParser;
import util.IOConfig;
import util.OutputUtil;
import xmiio.XMIWriter;


public class TestMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
	// TODO Auto-generated method stub
	
	long time = 0;
   	time = System.currentTimeMillis();
	List<String> dirStrings = new ArrayList<String>();
	MultiDirParser multiDirParser = new MultiDirParser();
	try {
	    dirStrings = multiDirParser.getDirectory(new File(IOConfig.getAnalyzedDir()));
	    for (int i = 0; i < dirStrings.size(); i++) {
//		System.out.println(dirStrings.get(i));
	    }
	} catch (Exception e1) {
	    // TODO Auto-generated catch block
	    e1.printStackTrace();
	}
  	
  	J2AST j2ast = new J2AST();
   	CompilationUnit compilationUnit = null;
   	for (int i = 0; i < dirStrings.size(); i++) {
   	    try {  	   
   		System.out.println(dirStrings.get(i));
   		compilationUnit = j2ast.getCompilationUnit(dirStrings.get(i));    
   	    } catch (Exception e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	    }
   	    MyJavaASTVisitor javaASTVisitor = new MyJavaASTVisitor();
   	    compilationUnit.accept(javaASTVisitor);
   	}
   	
   	ClassInfoBuilder classInfoBuilder = new ClassInfoBuilder();
   	XMIWriter xmiWriter = new XMIWriter();
   	String resultString = "";
   	
   	StringBuffer stringBuffer = new StringBuffer("");
   	xmiWriter.writeXMI(classInfoBuilder.getAllClassInfos(),stringBuffer);
   	System.out.println("时间：" + (System.currentTimeMillis()-time));

    }
}

package xmiio;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import util.IOConfig;

import bean.*;

public abstract class AbstractXMIWriter {
    
    public abstract StringBuffer writeXMI(ArrayList<AbstractType> classInfoList, StringBuffer result);
    
    public void outputToXML(String result) throws Exception{
   	FileWriter fwrite = null;
   	try {
   	    fwrite = new FileWriter(IOConfig.getOutputAddr(),true);
   	    fwrite.write(result);
   	    fwrite.flush();	
   	} catch (IOException e) {
   	    // TODO Auto-generated catch block
   	    e.printStackTrace();
   	} finally {
   	    try {
   		if (fwrite != null)
   		    fwrite.close();
   	    } catch (IOException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	    }
   	}
    }
}

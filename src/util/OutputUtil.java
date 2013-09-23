package util;

import java.io.FileWriter;
import java.io.IOException;

public class OutputUtil {

    public static void outputToXML(String result) throws Exception{
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

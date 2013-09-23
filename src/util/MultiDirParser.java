package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MultiDirParser {
    
    private static List<String> dirStrings = new ArrayList<String>();
    
    public List<String> getDirectory(File file) {
	
	if (!file.isDirectory()) {
	    //System.out.println(file);
	    dirStrings.add(file.toString());
	} else {
	    File[] fs = file.listFiles();
	    for (int i = 0; i < fs.length; i++) {
		getDirectory(fs[i]);
	    }
 	}
	return dirStrings;
    }
}

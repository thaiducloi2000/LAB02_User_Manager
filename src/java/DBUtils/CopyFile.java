/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 *
 * @author PC
 */
public class CopyFile implements Serializable{
    
    public static void copyFileUsingStream(File source,File dest)throws FileNotFoundException,IOException{
	InputStream is=null;
	OutputStream os=null;
	try {
	    is=new FileInputStream(source);
	    os=new FileOutputStream(dest);
	    byte[] buffer=new byte[1024];
	    int length;
	    while((length=is.read(buffer))>0){
		os.write(buffer,0,length);
	    }
	} finally {
	    if (os!=null) {
		os.close();
	    }if (is!=null) {
		is.close();
	    }
	}
    }
    
    public static void deleteFile(File source){
	source.delete();
    }
}

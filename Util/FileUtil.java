package Util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    private FileUtil() {}
         
    public static void copy(FileInputStream src, FileOutputStream dest, int blockSize) throws IOException
    {
        IOUtil.copy(src, dest, blockSize);      
    }
    
    public static void copy(FileInputStream src, FileOutputStream dest) throws IOException
    {
        copy(src, dest, 1024);      
    }
     
    public static void copy(String src, String dest, int blockSize) throws IOException
    {       
    	FileInputStream  fis = new FileInputStream(src);
    	FileOutputStream fos = new FileOutputStream(dest);
    	copy(fis, fos, blockSize);
    }
    
    public static void copy(String src, String dest) throws IOException
    {       
    	copy(src, dest, 1024);
    }
    
    public static void fastCopy(FileInputStream src, FileOutputStream dest, int blockSize) throws IOException
    {
    	IOUtil.fastCopy(src, dest, blockSize);
    }
    
    public static void fastCopy(FileInputStream src, FileOutputStream dest) throws IOException
    {
    	IOUtil.fastCopy(src, dest);
    }
    
    public static void fastCopy(String src, String dest) throws IOException
    {
    	IOUtil.fastCopy(new FileInputStream(src), new FileOutputStream(dest));
    }

    /*
    public static void splitFiles(File file, File path, int blockSize, int part) 
    {
    	long partOfFileSize = file.length() + (part-(file.length() % part))/part;
    	int pathFileCount = 1;
    	byte[] buffer = new byte[blockSize];

    	try(FileInputStream src = new FileInputStream(file);
    		FileOutputStream dest = new FileOutputStream(fileNameOfPart))
    	{
    		int read, total = 0;
    		while ((read = src.read(buffer)) > 0) {
    			dest.write(buffer, 0, read);
    			total += read;
    		}
    				
    	}
    	catch(IOException ex) {
    		ex.printStackTrace();
    		System.out.println(ex.getMessage());
    	}
    }
    */
}





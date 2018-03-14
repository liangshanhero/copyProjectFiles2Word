package cn.edu.scau.cmi.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.apache.commons.io.FileUtils;

public class CmiFileUtils extends FileUtils{


	public  static String readFile(File sourceProjectFile) {   
	    String fileContent = "";   
	    try {    
//	        File sourceProjectFile = new File(filePathAndName);   
	        if(sourceProjectFile.isFile()&&sourceProjectFile.exists()){   
	            InputStreamReader read = new InputStreamReader(new FileInputStream(sourceProjectFile),"UTF-8");   
	            BufferedReader reader=new BufferedReader(read);   
	            String line;   
	            while ((line = reader.readLine()) != null) {   
	                fileContent = fileContent+line+"\r\n";   
	            }     
	            read.close();   
	        }   
	    } catch (Exception e) {   
	        System.out.println("读取文件内容操作出错");   
	        e.printStackTrace();   
	    }   
	    return fileContent;   
	} 
	
	
	public  static void writeFile(String filePathAndName, String fileContent) {   
	    try {   
	        File sourceFilePath = new File(filePathAndName);   
	        if (!sourceFilePath.exists()) {   
	            sourceFilePath.createNewFile();   
	        }   
	        OutputStreamWriter write = new OutputStreamWriter(new FileOutputStream(sourceFilePath),"UTF-8");   
	        BufferedWriter writer=new BufferedWriter(write);     
	        writer.write(fileContent);   
	        writer.close();   
	    } catch (Exception e) {   
	        System.out.println("写文件内容操作出错");   
	        e.printStackTrace();   
	    }   
	}  
	
	
}

package cn.edu.scau.cmi.nouse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import cn.edu.scau.cmi.utils.FileUtils;
import cn.edu.scau.cmi.utils.ProjectUtils;
public class DocumentUtilsOlder {
	   public  static void WriteDoc(StringBuilder allSourceFilecontent,String targePath) throws IOException{
		   String allFIleContent=allSourceFilecontent.toString();
		   XWPFDocument doc = new XWPFDocument();  
		      //创建一个段落  
		      XWPFParagraph para = doc.createParagraph(); 
		      //一个XWPFRun代表具有相同属性的一个区域。  
		      XWPFRun run = para.createRun(); 
		      run.setText(allFIleContent);
//		      run.setBold(true); //加粗  
//		      run.setText("加入的内容");  
		      OutputStream os = new FileOutputStream(targePath);  
		      //把doc输出到输出流  
		      doc.write(os);  
		      doc.close();
	   }
	   public  static void writeProject2Doc(String project, File targePath) throws IOException{
		   OutputStream os = new FileOutputStream(targePath);  
		   XWPFDocument doc = new XWPFDocument();  
		   XWPFParagraph para = doc.createParagraph(); 
//		   StringBuilder sb=new StringBuilder("");
		   ArrayList<File> projectFileList = ProjectUtils.getProjectFiles(project);
		   for(File file:projectFileList){
			   XWPFRun fileNameRun = para.createRun();
			   XWPFRun fileContentRun = para.createRun();
			   fileNameRun.setBold(true);
			   fileNameRun.setText(file.getName());
			   fileNameRun.setText("\r\n");
			   fileContentRun.setBold(false);
			   fileContentRun.setText(FileUtils.readFile(file));
		   }
		   doc.write(os);  
		   doc.close();
		   System.out.println("OK");
	   }
}
package cn.edu.scau.cmi.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFStyles;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTStyles;

public class DocumentUtils {
	 /** 
     * word整体样式 
     */  
    private static CTStyles wordStyles = null;  
  
    /** 
     * Word整体样式 
     */  
    static {  
        XWPFDocument template;  
        try {  
            // 读取模板文档  
            template = new XWPFDocument(new FileInputStream(System.getProperty("user.dir")+"/format.docx"));  
            // 获得模板文档的整体样式  
            wordStyles = template.getStyle();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (XmlException e) {  
            e.printStackTrace();  
        }  
    }  

	public static void WriteDoc(StringBuilder allSourceFilecontent,	String targePath) throws IOException {
		String allFileContent = allSourceFilecontent.toString();
		XWPFDocument doc = new XWPFDocument();
		// 创建一个段落
		XWPFParagraph para = doc.createParagraph();
		// 一个XWPFRun代表具有相同属性的一个区域。
		XWPFRun run = para.createRun();
		run.setText(allFileContent);
		OutputStream os = new FileOutputStream(targePath);
		// 把doc输出到输出流
		doc.write(os);
		doc.close();
	}

	public static void writeProject2Doc(String project, File targePath)	throws IOException {
		OutputStream os = new FileOutputStream(targePath);
		XWPFDocument doc = new XWPFDocument();
		XWPFStyles newStyles = doc.createStyles();  
		newStyles.setStyles(wordStyles); 
//		XWPFParagraph paraFileName = doc.createParagraph();
//		XWPFParagraph paraFileContent = doc.createParagraph();
		// StringBuilder sb=new StringBuilder("");
		ArrayList<File> projectFileList = ProjectUtils.getProjectFiles(project);
		
		for (File file : projectFileList) {
			
			XWPFParagraph paraFileName = doc.createParagraph();
			XWPFParagraph paraFileContent = doc.createParagraph();
			
			System.out.println(file.getName());
			System.out.println(FileUtils.readFile(file));
			
			//设置文件名标题
			paraFileName.setStyle("2");
			XWPFRun fileNameRun = paraFileName.createRun();
			XWPFRun fileContentRun = paraFileContent.createRun();
			
			//写文件名
//			fileNameRun.setBold(true);
			fileNameRun.setText(file.getName());
			//换行
//			fileNameRun.addCarriageReturn();
			
			//写文件内容
			fileContentRun.setBold(false);
			fileContentRun.setText(FileUtils.readFile(file));

		}
		doc.write(os);
		doc.close();
		System.out.println("OK");

	}

}

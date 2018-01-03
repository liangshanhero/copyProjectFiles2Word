package cn.edu.scau.cmi.client;

import java.io.File;
import java.util.ArrayList;

import cn.edu.scau.cmi.utils.DocumentUtils;

public class CmiClient {

	public static void main(String[] args) throws Exception {

		
		String project="D:\\Workspace\\Jee\\CopyProjectFile2WordDocument";
		File targePath=new File("D:\\Workspace\\Jee\\CopyProjectFile2WordDocument\\testResult.docx");
		DocumentUtils.writeProject2Doc(project, targePath);
		
		
		
		
	}

}

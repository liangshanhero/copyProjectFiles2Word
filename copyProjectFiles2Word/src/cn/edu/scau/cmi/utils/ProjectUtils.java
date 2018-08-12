package cn.edu.scau.cmi.utils;

import java.io.File;
import java.util.ArrayList;

public class ProjectUtils {
	private static ArrayList<File> projectFiles = new ArrayList<File>();

	// 获取指定目录下所有的文本文件，目前包含以一下几种类型的文件 。
	public static ArrayList<File> getProjectFiles(String dirpath ) {
		File directory = new File(dirpath);// 建立当前目录中文件的File对象
		if (directory.exists()) {
			File[] files = directory.listFiles();// 取得目录中所有文件的File对象数组
			for (int i = 0; i < files.length; i++) {
				File file = files[i];
				if ( file.isFile()){
					if(file.getName().endsWith(".java")
						|| file.getName().endsWith(".jsp")
						|| file.getName().endsWith(".html")
						|| file.getName().endsWith(".xml")
						|| file.getName().endsWith(".xsd") 
						|| file.getName().endsWith(".css")
						|| file.getName().endsWith(".properties")
						|| file.getName().endsWith(".map")
						|| file.getName().endsWith(".project")
						|| file.getName().endsWith(".springBeans")) {
					projectFiles.add(file);
					}
				}
				if (file.isDirectory()) {
					getProjectFiles(file.getPath());
				}
			}
		}
		return projectFiles;
	}
}

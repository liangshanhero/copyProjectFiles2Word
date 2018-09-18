package cn.edu.scau.cmi.client;

import java.io.File;

import cn.edu.scau.cmi.utils.CmiDocUtils;

public class CmiConsoleClient {
	public static void main(String[] args) throws Exception {
		String project = "D:\\git\\copyProjectFiles2Word\\copyProjectFiles2Word";
		File targePath = new File("D:\\git\\copyProjectFiles2Word\\copyProjectFiles2Word\\testResult.docx");
		CmiDocUtils.writeProject2Doc(project, targePath);
	}
}
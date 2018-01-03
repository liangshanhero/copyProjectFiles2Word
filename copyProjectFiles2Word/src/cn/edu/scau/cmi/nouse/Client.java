package cn.edu.scau.cmi.nouse;
//package cn.edu.scau.cmi.implcode;
//
//import java.io.File;
//import java.util.ArrayList;
//
//public class Client {
//
//	public static void main(String[] args) throws Exception {
//		StringBuilder sbAllDocument4Word=new StringBuilder("");//所有准备写入到word文档中的内容
//		String simpleDocumentString="";//每一个文档的内容
//		DocumentUtils writeWordDocument=new DocumentUtils();
//		ProjectUtils getProjectFile=new ProjectUtils();
//		ArrayList<File> projectFile=getProjectFile.getProjectFiles("D:/Workspace/MyEclipse4Spring/t");
//				for(int i=0;i<projectFile.size();i++){
//			simpleDocumentString=FileUtils.readFile(projectFile.get(i).toString());
//			String[] splitString=projectFile.get(i).toString().split("\\\\");
//			sbAllDocument4Word.append(splitString[splitString.length-1]+"\r\n");
//			sbAllDocument4Word.append(simpleDocumentString);
//			System.out.println(projectFile.get(i));
//			System.out.print(simpleDocumentString);
//		}
//		writeWordDocument.WriteDoc(sbAllDocument4Word.toString(),"D:\\simpleWrite.docx");
//		System.out.println("OK");
//	}
//
//}

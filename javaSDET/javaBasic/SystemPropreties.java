package javaBasic;
//lấy đường dẫn dể upload 1 file nào đó ở trên hệ điều hành khác nhau (mac, window...)
public class SystemPropreties {
	static String projectPath = System.getProperty("user.dir");
	static String osName = System.getProperty("os.name");
	static String fileName = "";
	static String filePath;
	
	public static void main(String[] agrs) {
		filePath = projectPath + getDirSlash("uploadFile") + fileName;
	}
	
	public static String getDirSlash (String folderName) {
		if (osName.toLowerCase().startsWith("window")) {
			folderName = "\\" + folderName + "\\";
		}else if (osName.toLowerCase().startsWith("mac")) {
			folderName = "/" + folderName + "/";
		}
		return folderName;
	}

}

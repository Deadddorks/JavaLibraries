package javaLibraries.file;

import java.io.File;

public class FileInfo
{
	
	private FileInfo() {}
	
	public static String getWorkingDirPath()
	{
		return System.getProperty("user.dir").replaceAll("\\\\", "/") + "/";
	}
	public static File getWorkingDirFile()
	{
		return new File(getWorkingDirPath());
	}
	
}

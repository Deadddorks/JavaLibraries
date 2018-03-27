package javaLibraries;

import static javaLibraries.util.logger.LogLevel.*;
import javaLibraries.util.logger.Logger;

public class Main
{
	
	public static void main(String[] args)
	{
		
		Logger logger = new Logger(System.out, ERROR);
		
		logger.log(DEBUG, "Debug");
		logger.log(INFO, "Info");
		logger.log(PRINT, "Print");
		logger.log(ERROR, "Error");
		logger.log(ALWAYS, "Always");
		
		logger.log("Wee-hoo");
		
	}
	
}

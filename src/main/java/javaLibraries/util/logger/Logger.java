package javaLibraries.util.logger;

import java.io.PrintStream;

public class Logger
{
	
	private final PrintStream printStream;
	private LogLevel logLevel;
	
	public Logger(final PrintStream printStream)
	{
		this(printStream, LogLevel.PRINT);
	}
	public Logger(final PrintStream printStream, final LogLevel logLevel)
	{
		setLogLevel(logLevel);
		this.printStream = printStream;
	}
	
	public void setLogLevel(final LogLevel logLevel)
	{
		if (logLevel == null)
		{
			throw new IllegalArgumentException("level can not be \'null\'.");
		}
		
		this.logLevel = logLevel;
	}
	
	public void log(final String string)
	{
		log(LogLevel.PRINT, string);
	}
	public void log(final LogLevel logLevel, final String string)
	{
		if (logLevel.compareTo(this.logLevel) >= 0)
		{
			printStream.println(string);
		}
	}
	
}

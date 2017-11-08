package javaLibraries.util.cycle.exceptions;

public class InvalidIntRangeException extends RuntimeException
{
	
	public InvalidIntRangeException(final int min, final int max)
	{
		super("Invalid range, Min > Max. ["+min+"] > ["+max+"]");
	}
	
	public InvalidIntRangeException(final int min, final int max, final int start)
	{
		super("Start value is not within range. ["+start+"] x ["+min+"] - ["+max+"]");
	}
	
}

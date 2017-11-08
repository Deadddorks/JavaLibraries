package javaLibraries.util.cycle.exceptions;

/**
 * RuntimeException that gets thrown by a CyclicIntList when its min < max, or start is outside range
 */
public class InvalidIntRangeException extends RuntimeException
{
	
	/**
	 * InvalidIntRangeException where min < max
	 * @param min specified min
	 * @param max specified max
	 */
	public InvalidIntRangeException(final int min, final int max)
	{
		super("Invalid range, Min > Max. ["+min+"] > ["+max+"]");
	}
	
	/**
	 * InvalidIntRangeException where start is outside range of min-max
	 * @param min specified min
	 * @param max specified max
	 * @param start specified start
	 */
	public InvalidIntRangeException(final int min, final int max, final int start)
	{
		super("Start value is not within range. ["+start+"] x ["+min+"] - ["+max+"]");
	}
	
}

package javaLibraries.util.math.exceptions;

/**
 * RuntimeException that gets thrown when a specified Random range is Invalid
 *
 * @author Deaddorks
 * @version 1.0
 */
public class InvalidRangeException extends RuntimeException
{
	
	/**
	 * Specifies an invalid range for ints
	 * @param specifiedMin int that was specified for the minimum value of the range
	 * @param specifiedMax int that was specified for the maximum value of the range
	 */
	public InvalidRangeException(final int specifiedMin, final int specifiedMax)
	{
		super("Invalid range, Min > Max. {["+specifiedMin+"] > ["+specifiedMax+"]}");
	}
	
	/**
	 * Specifies an invalid range for doubles
	 * @param specifiedMin double that was specified for the minimum value of the range
	 * @param specifiedMax double that was specified for the maximum value of the range
	 */
	public InvalidRangeException(final double specifiedMin, final double specifiedMax)
	{
		super("Invalid range, Min > Max. {["+specifiedMin+"] > ["+specifiedMax+"]}");
	}

}

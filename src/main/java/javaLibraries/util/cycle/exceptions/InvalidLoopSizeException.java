package javaLibraries.util.cycle.exceptions;

/**
 * Gets thrown when a loop size is < 2
 *
 * @author Deaddorks
 * @version 1.0
 */
public class InvalidLoopSizeException extends RuntimeException
{
	
	/**
	 * Creates an InvalidLoopSizeException with the specified loop size as the loop size specified in the List
	 * @param specifiedLoopSize the specified loop size as the loop size specified in the List
	 */
	public InvalidLoopSizeException(final int specifiedLoopSize)
	{
		super("Invalid Loop Size. Loop size must be >= 2. Specified Size: ["+specifiedLoopSize+"]");
	}

}

package javaLibraries.util.strings.exceptions;

/**
 * Exception that gets thrown by StringFormatter when in is longer than maxLength
 * and EXCEPTION is set
 *
 * @author Deaddorks
 * @version 1.0
 */
public class StringLengthException extends RuntimeException
{
	
	/**
	 * Creates a StringLengthException with the specified maxLength and in String
	 *
	 * @param max the maxLength of the StringFormatter
	 * @param actual the String that was given to the StringFormatter
	 */
	public StringLengthException(final int max, final String actual)
	{
		super("String \"" + actual + "\" greater than max length. ["+ actual.length() +"] > ["+ max +"].");
	}
	
}
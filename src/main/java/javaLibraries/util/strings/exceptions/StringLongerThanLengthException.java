package javaLibraries.util.strings.exceptions;

/**
 * RuntimeException that gets thrown when a StringFormatter tries to create a String
 * shorter than the specified String when it is not allowed
 *
 * @author Deaddorks
 * @version 1.0
 */
public class StringLongerThanLengthException extends RuntimeException
{
	
	/**
	 * Creates a StringLongerThanLengthException with the specified String and length that caused the error
	 * @param string the String passed in
	 * @param length the length passed in
	 */
	public StringLongerThanLengthException(final String string, final int length)
	{
		super("Attempted to print string: ["+string+"] with a length of ["+length+"]. String too long <"+(string.length())+">");
	}
	
}

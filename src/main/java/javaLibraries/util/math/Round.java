package javaLibraries.util.math;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import java.security.InvalidParameterException;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/**
 * Methods that allow for more simple methods of rounding
 *
 * @author Deaddorks
 * @version 1.0
 */
public class Round
{
	
	// ----- Label -----
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * Private constructor to deny creating an Instance of this Class
	 */
	private Round() {}
	
	/**
	 * Takes a double and rounds it to the specified number of decimal places.<br>
	 * 0  : The nearest whole number.<br>
	 * 1  : The nearest tenth.<br>
	 * -1 : The nearest ten.
	 * @param number the number to round
	 * @param numDecimalPlaces the specified number of decimal places
	 * @return the specified double rounded to the specified number of decimal places
	 */
	public static double round(final double number, final int numDecimalPlaces)
	{
		double d = Math.round(Math.pow(10, numDecimalPlaces) * number) / Math.pow(10, numDecimalPlaces);
		return numDecimalPlaces < 0 ? Math.round(d) : d;
	}
	
	/**
	 * Takes a double and rounds it so that the double has the specified length as far as a String would be concerned.<br>
	 * Note: It is not Double.toString.substring(...), and will not tolerate invalid lengths.<br>
	 * The minimum length for a double is 3 ("0.1"), and for negatives it is 4 ("-0.1"),<br>
	 * and the minimum length for a number with 2 digits before the decimal would be 4 ("10.0"), and so on...
	 * @param number the number to round
	 * @param length the specified length of the double to be returned
	 * @return
	 */
	public static double roundToLength(final double number, final int length)
	{
		int minLength = Double.toString((double) ((int) Math.abs(number))).length() + (number < 0 ? 1 : 0);
		
		if (length < 3)
		{
			throw new InvalidParameterException("Length of double can never be less than 3. Entered: ["+length+"]");
		}
		if (minLength > length)
		{
			throw new InvalidParameterException("Can not round number of minimum length ["+minLength+"] to length ["+length+"]");
		}
		
		return round(number, length - minLength + 1);
	}
	
}

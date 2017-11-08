package javaLibraries.util.math;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import javaLibraries.util.math.exceptions.InvalidRangeException;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


/**
 * Used to easily generate random values within a range
 *
 * @author	Deaddorks
 * @version	1.0
 */
public class Random
{
	
	// ----- Label -----
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * Private constructor to deny creating an Instance of this Class
	 */
	private Random() {}
	
	/**
	 * Generates a random int between <strong>min</strong> and <strong>max</strong>, inclusive.
	 * @param min Minimum value of the range of the desired random int
	 * @param max Maximum value of the range of the desired random int
	 * @return a random int between <strong>min</strong> and <strong>max</strong>, inclusive.
	 */
	public static int randomInt(final int min, final int max)
	{
		if (min > max)
		{
			throw new InvalidRangeException(min, max);
		}
		
		java.util.Random rand = new java.util.Random();
		return rand.nextInt(max - min + 1) + min;
	}
	/**
	 * Generates a random int between <strong>0</strong> and <strong>max</strong>, inclusive.
	 * @param max Maximum value of the range of the desired random int
	 * @return a random int between <strong>0</strong> and <strong>max</strong>, inclusive.
	 */
	public static int randomInt(final int max)
	{
		return randomInt(0, max);
	}
	
	/**
	 * Generates a random double between <strong>min</strong> and <strong>max</strong>, inclusive.
	 * @param min Minimum value of the range of the desired random double
	 * @param max Maximum value of the range of the desired random double
	 * @return a random double between <strong>min</strong> and <strong>max</strong>, inclusive.
	 */
	public static double randomDouble(final double min, final double max)
	{
		if (min > max)
		{
			throw new InvalidRangeException(min, max);
		}
		
		java.util.Random rand = new java.util.Random();
		return min + (max - min) * rand.nextDouble();
	}
	/**
	 * Generates a random double between <strong>0</strong> and <strong>max</strong>, inclusive.
	 * @param max Maximum value of the range of the desired random double
	 * @return a random double between <strong>0</strong> and <strong>max</strong>, inclusive.
	 */
	public static double randomDouble(final double max)
	{
		return randomDouble(0, max);
	}
	
}

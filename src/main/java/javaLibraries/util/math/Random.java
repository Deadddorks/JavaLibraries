package javaLibraries.util.math;

// ~~~~~~~~~~ Imports ~~~~~~~~~~

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

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
	
	public static int randomInt(final int min, final int max)
	{
		java.util.Random rand = new java.util.Random();
		return rand.nextInt(max - min + 1) + min;
	}
	public static int randomInt(final int max)
	{
		return randomInt(0, max);
	}
	
	public static double randomDouble(final double min, final double max)
	{
		java.util.Random rand = new java.util.Random();
		return min + (max - min) * rand.nextDouble();
	}
	public static double randomDouble(final double max)
	{
		return randomDouble(0, max);
	}
	
}

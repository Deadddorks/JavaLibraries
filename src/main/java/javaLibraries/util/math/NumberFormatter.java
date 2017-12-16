package javaLibraries.util.math;

// ~~~~~~~~~~ Imports ~~~~~~~~~~

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class NumberFormatter
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	private NumberFormatter() {}
	
	public static String formatLong(final long number)
	{
		
		int sign = (int) Math.signum(number);
		long num = Math.abs(number);
		
		String numString = Long.toString(num);
		String out = "";
		char sep = ',';
		
		while (numString.length() > 3)
		{
			out = numString.substring(numString.length() - 3) + (out == "" ? "" : ",") + out;
			numString = numString.substring(0, numString.length() - 3);
		}
		out = (sign == -1 ? "-" : "") + numString + (out == "" ? "" : ",") + out;
		
		return out;
	}
	
	public static String formatDouble(final double number)
	{
		String[] split = Double.toString(number).split("\\.");
		
		return formatLong(Long.parseLong(split[0])) + "." + split[1];
	}
	
}

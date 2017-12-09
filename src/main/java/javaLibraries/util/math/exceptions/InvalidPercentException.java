package javaLibraries.util.math.exceptions;

// ~~~~~~~~~~ Imports ~~~~~~~~~~

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class InvalidPercentException extends RuntimeException
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public InvalidPercentException(final float percent)
	{
		super("Invalid percent value ["+percent+"]. Percent must be '>= 0' and '<= 100'. ");
	}
	
}

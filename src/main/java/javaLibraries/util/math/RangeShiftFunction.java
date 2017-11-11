package javaLibraries.util.math;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import java.security.InvalidParameterException;
import java.util.function.Function;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/**
 * Allows conversion from one range to another, allows converting from a -> b & b -> 1
 *
 * @author Deaddorks
 * @version 1.0
 */
public class RangeShiftFunction
{
	
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	private final Function<Double, Double> oldToNewFunction;
	private final Function<Double, Double> newToOldFunction;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * Creates a RangeShiftFunction with the specified old range and new range
	 * @param oldMin min of old range
	 * @param oldMax max of old range
	 * @param newMin min of new range
	 * @param newMax max of new range
	 */
	public RangeShiftFunction(final double oldMin, final double oldMax, final double newMin, final double newMax)
	{
		if (oldMax - oldMin == 0 || newMax - newMin == 0)
		{
			throw new InvalidParameterException("Can not have a range of 0.");
		}
		
		oldToNewFunction = d -> (d - oldMin) * (newMax - newMin) / (oldMax - oldMin) + newMin;
		newToOldFunction = d -> (d - newMin) * (oldMax - oldMin) / (newMax - newMin) + oldMin;
	}
	
	/**
	 * Converts a number from the old range to the new range
	 * @param d number to be converted
	 * @return the converted value
	 */
	public double oldToNew(final double d)
	{
		return oldToNewFunction.apply(d);
	}
	/**
	 * Converts a number from the new range to the old range
	 * @param d number to be converted
	 * @return the converted value
	 */
	public double newToOld(final double d)
	{
		return newToOldFunction.apply(d);
	}
	
}

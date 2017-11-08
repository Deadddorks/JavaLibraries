package javaLibraries.util.cycle;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import javaLibraries.util.cycle.exceptions.InvalidIntRangeException;
import javaLibraries.util.cycle.exceptions.InvalidLoopSizeException;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/**
 * Creates a CycleList of Integers between specified values.<br>
 * Allows for faster operations and less data stored compared to if an actual CycleList<Integer> was used
 *
 * @author Deaddorks
 * @version 1.0
 */
public class CyclicIntList extends CyclicList<Integer>
{
	
	// ----- Label -----
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	private int min;
	private int max;
	private int current;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * Creates a CycleIntList between <strong>0</strong> and <strong>max</strong>, starts at 0
	 * @param max max value of the cycle
	 */
	public CyclicIntList(final int max)
	{
		init(0, max, 0);
	}
	/**
	 * Creates a CycleIntList between <strong>0</strong> and <strong>max</strong>, starts at min
	 * @param min min value of the cycle
	 * @param max max value of the cycle
	 */
	public CyclicIntList(final int min, final int max)
	{
		init(min, max, min);
	}
	/**
	 * Creates a CycleIntList between <strong>0</strong> and <strong>max</strong>, starts at <strong>start</strong>
	 * @param min min value of the cycle
	 * @param max max value of the cycle
	 * @param start start value of the cycle
	 */
	public CyclicIntList(final int min, final int max, final int start)
	{
		init(min, max, start);
	}
	
	private void init(final int min, final int max, final int start)
	{
		if (min > max)
		{
			throw new InvalidIntRangeException(min, max);
		}
		if (max - min < 1)
		{
			throw new InvalidLoopSizeException(max - min + 1);
		}
		if (start < min || start > max)
		{
			throw new InvalidIntRangeException(min, max, start);
		}
		
		this.min = min;
		this.max = max;
		
		this.current = start;
	}
	
	/**
	 * Gets the current value of the List
	 *
	 * @return the current value of the List
	 */
	@Override
	public Integer get()
	{
		return current;
	}
	
	/**
	 * Sets the value to the next value in the List,<br>
	 * if you go out the end of the List, you should emerge at the beginning.
	 */
	@Override
	public void next()
	{
		current = ++current > max ? min : current;
	}
	
	/**
	 * Sets the value to the previous value in the List,<br>
	 * if you go out the beginning of the List, you should emerge at the end.
	 */
	@Override
	public void prev()
	{
		current = --current < min ? max : current;
	}
}

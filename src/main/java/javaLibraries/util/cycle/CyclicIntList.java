package javaLibraries.util.cycle;

// ~~~~~~~~~~ Imports ~~~~~~~~~~

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

import javaLibraries.util.cycle.exceptions.InvalidIntRangeException;
import javaLibraries.util.cycle.exceptions.InvalidLoopSizeException;

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
	
	public CyclicIntList(final int max)
	{
		init(0, max, 0);
	}
	public CyclicIntList(final int min, final int max)
	{
		init(min, max, min);
	}
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
	
	@Override
	public Integer get()
	{
		return current;
	}
	
	@Override
	public void next()
	{
		current = ++current > max ? min : current;
	}
	
	@Override
	public void prev()
	{
		current = --current < min ? max : current;
	}
}

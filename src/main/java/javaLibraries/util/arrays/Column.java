package javaLibraries.util.arrays;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import javaLibraries.constants.Alignment;
import javaLibraries.util.strings.StringFormatter;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.Function;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class Column<E>
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	private Function<E, String> toStringFunction;
	private String nullString;
	
	private int maxLength;
	private Queue<String> entries;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Column(final Function<E, String> toStringFunction, final String nullString)
	{
		this.toStringFunction = toStringFunction;
		this.nullString = nullString;
		
		entries = new LinkedList<>();
		maxLength = -1;
	}
	
	public void add(final E item)
	{
		String entry = (item == null ? nullString : toStringFunction.apply(item));
		
		entries.add(entry);
		maxLength = Math.max(maxLength, entry.length());
	}
	
	public boolean isEmpty()
	{
		return entries.isEmpty();
	}
	
	public int getMaxLength()
	{
		return maxLength;
	}
	
	public String get(final boolean sizeToMax)
	{
		if (sizeToMax)
		{
			return StringFormatter.create(entries.remove(), maxLength).setAlignment(Alignment.LEFT).build();
		}
		return entries.remove();
	}
	
}

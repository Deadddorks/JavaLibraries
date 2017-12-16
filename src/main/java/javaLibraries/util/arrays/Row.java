package javaLibraries.util.arrays;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import java.util.ArrayList;
import java.util.List;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class Row
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	private List<String> values;
	private int length;
	private int size;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Row()
	{
		values = new ArrayList<>();
		length = 0;
		size = 0;
	}
	
	public void add(final String value)
	{
		values.add(value);
		length += value.length();
		size++;
	}
	
	public List<String> getValues()
	{
		return values;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public int getSize()
	{
		return size;
	}
}

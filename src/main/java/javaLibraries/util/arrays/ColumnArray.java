package javaLibraries.util.arrays;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import javaLibraries.constants.Alignment;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class ColumnArray
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	private ColumnArray() {}
	
	public static <E, T extends Iterable<? extends E>> TriPair<List<Row>, List<Integer>, Integer> getRows(final T t, final List<Function<E, String>> toStringFunctions,
																			  final String nullString, final boolean fitToMax, final Alignment alignment)
	{
		// Create Columns
		List<Column<E>> cols = new ArrayList<>();
		for (int i = 0; i < toStringFunctions.size(); i++)
		{
			cols.add(new Column<>(toStringFunctions.get(i), nullString));
		}
		
		// Fill Columns with Function applied Strings
		Iterator<? extends E> iter = t.iterator();
		E item;
		while (iter.hasNext())
		{
			item = iter.next();
			for (Column<E> c : cols)
			{
				c.add(item);
			}
		}
		
		// Convert Columns into Rows
		List<Row> rows = new ArrayList<>();
		Row r;
		int maxRowCharacterWidth;
		
		maxRowCharacterWidth = -1;
		while (!cols.get(0).isEmpty())
		{
			r = new Row();
			for (Column<E> c : cols)
			{
				r.add(c.get(fitToMax));
			}
			maxRowCharacterWidth = Math.max(maxRowCharacterWidth, r.getLength());
			rows.add(r);
		}
		
		// List of col widths
		List<Integer> colWidths = new ArrayList<>();
		for (Column<E> c : cols)
		{
			colWidths.add(c.getMaxLength());
		}
		
		return new TriPair<>(rows, colWidths, maxRowCharacterWidth);
	}
	
}

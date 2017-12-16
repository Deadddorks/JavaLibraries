package javaLibraries.util.arrays;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import javaLibraries.constants.Alignment;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class IterableToString
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	public enum Orientation {VERTICAL, HORIZONTAL}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	private IterableToString() {}
	
	public static <E, T extends Iterable<? extends E>> Builder<E, T> builder(final T iterable)
	{
		return new Builder<>(iterable);
	}
	
	public static class Builder<E, T extends Iterable<? extends E>>
	{
		
		// ~~~~~~~~~~ Constants ~~~~~~~~~~
		private List<Function<E, String>> DEFAULT_TO_STRING_FUNCTION = new ArrayList<>();
		// ~~~~~~~~~~ Variables ~~~~~~~~~~
		private T iterable;
		private List<Function<E, String>> toStringFunctions;
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		private Builder(final T iterable)
		{
			if (iterable == null)
			{
				throw new IllegalArgumentException("Iterable Object can not be null");
			}
			
			DEFAULT_TO_STRING_FUNCTION.add(e -> e.toString());
			
			
			
		}
		
		public Builder<E, T> setToString(final Function<E, String>... toStringFunctions)
		{
			if (toStringFunctions == null)
			{
				throw new IllegalArgumentException("toStringFunctions can not be null");
			}
			if (toStringFunctions.length == 0)
			{
				throw new IllegalArgumentException("must have at least 1 toStringFunction");
			}
			for (Function<E, String> f : toStringFunctions)
			{
				if (f == null)
				{
					throw new IllegalArgumentException("toStringFunctions can not be null");
				}
			}
			
			this.toStringFunctions = new ArrayList<>();
			for (Function<E, String> f : toStringFunctions)
			{
				this.toStringFunctions.add(f);
			}
			
			return this;
		}
		
		
		public Output build()
		{
			
			throw new UnsupportedOperationException();
		}
		
	}
	
	public class Output
	{
		
		// ~~~~~~~~~~ Variables ~~~~~~~~~~
		private List<Row> rows;
		private String title;
		private String nullString;
		
		private Orientation orientation;
		private List<Integer> colWidths;
		private int maxRowWidth;
		
		private Alignment titleAlignment;
		private Alignment functionAlignment;
		
		private String functionSeparator;
		private String elementSeparator;
		
		private String leftBorder;
		private String rightBorder;
		
		private char horizStrong;
		private char horizWeak;
		private char corner;
		// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
		
		public Output(final List<Row> rows, final String title, final String nullString,
					  final Orientation orientation, final List<Integer> colWidths, final int maxRowWidth,
					  final Alignment titleAlignment, final Alignment functionAlignment,
					  final String functionSeparator, final String elementSeparator,
					  final String leftBorder, final String rightBorder,
					  final char horizStrong, final char horizWeak, final char corner)
		{
			this.rows = rows;
			this.title = title;
			this.nullString = nullString;
			
			this.orientation = orientation;
			this.colWidths = colWidths;
			this.maxRowWidth = maxRowWidth;
			
			this.titleAlignment = titleAlignment;
			this.functionAlignment = functionAlignment;
			
			this.functionSeparator = functionSeparator;
			this.elementSeparator = elementSeparator;
			
			this.leftBorder = leftBorder;
			this.rightBorder = rightBorder;
			
			this.horizStrong = horizStrong;
			this.horizWeak = horizWeak;
			
			this.corner = corner;
		}
		
		public void print()
		{
			throw new UnsupportedOperationException();
		}
		
		@Override
		public String toString()
		{
			
			switch (orientation)
			{
				case VERTICAL:
					String rowBreak = null;
					if (horizWeak != ' ' && corner != ' ')
					{
						StringBuilder string = new StringBuilder();
						
					}
					break;
				case HORIZONTAL:
					break;
				default:
					throw new RuntimeException("Invalid orientation");
			}
			
			throw new UnsupportedOperationException();
		}
	}
	
}

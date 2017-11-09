package javaLibraries.util.arrays;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import javaLibraries.constants.Alignment;
import javaLibraries.util.strings.StringFormatter;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class ArrayToString
{
	
	// ----- Label -----
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	private ArrayToString() {}
	
	public static <T> ArrayBuilder1D<T> create1D(final T[] array)
	{
		return new ArrayBuilder1D<>(array);
	}
	public static <T> ArrayBuilder2D<T> create2D(final T[][] array)
	{
		return new ArrayBuilder2D<>(array);
	}
	
	public static class ArrayBuilder1D<T>
	{
		
		public enum Style
		{
			
			BLANK(' ', ' ', "", ""),
			TOP('-', ' ', "", ""),
			SIDES(' ', ' ', "[", "]"),
			SURROUNDED('-', '-', "[", "]");
			
			private char topBorder;
			private char bottomBorder;
			private String leftBorder;
			private String rightBorder;
			Style(final char topBorder, final char bottomBorder, final String leftBorder, final String rightBorder)
			{
				this.topBorder = topBorder;
				this.bottomBorder = bottomBorder;
				this.leftBorder = leftBorder;
				this.rightBorder = rightBorder;
			}
			
		}
		
		private T[] array;
		
		private Alignment alignment;
		private Function<T, String> function;
		
		private char topBorder;
		private char bottomBorder;
		private String leftBorder;
		private String rightBorder;
		
		private ArrayBuilder1D(final T[] array)
		{
			if (array == null)
			{
				throw new InvalidParameterException("array can not be null");
			}
			this.array = array;
			
			alignment = Alignment.LEFT;
			function = t -> t.toString();
			topBorder = ' ';
			bottomBorder = ' ';
			leftBorder = "";
			rightBorder = "";
		}
		
		public ArrayBuilder1D<T> setAlignment(final Alignment alignment)
		{
			this.alignment = alignment;
			return this;
		}
		
		public ArrayBuilder1D<T> setBorders(final Style style)
		{
			setTopBorder(style.topBorder);
			setBottomBorder(style.bottomBorder);
			setLeftBorder(style.leftBorder);
			setRightBorder(style.rightBorder);
			return this;
		}
		
		public ArrayBuilder1D<T> setTopBorder(final char topBorder)
		{
			this.topBorder = topBorder;
			return this;
		}
		public ArrayBuilder1D<T> setBottomBorder(final char bottomBorder)
		{
			this.bottomBorder = bottomBorder;
			return this;
		}
		
		public ArrayBuilder1D<T> setLeftBorder(final String leftBorder)
		{
			if (leftBorder == null)
			{
				throw new InvalidParameterException("leftBorder can not be null");
			}
			this.leftBorder = leftBorder;
			return this;
		}
		public ArrayBuilder1D<T> setRightBorder(final String rightBorder)
		{
			if (rightBorder == null)
			{
				throw new InvalidParameterException("rightBorder can not be null");
			}
			this.rightBorder = rightBorder;
			return this;
		}
		
		public ArrayBuilder1D<T> setFunction(final Function<T, String> function)
		{
			if (function == null)
			{
				throw new InvalidParameterException("function can not be null");
			}
			this.function = function;
			return this;
		}
		
		public String build()
		{
			int maxLength = 0;
			List<String> outputs = new ArrayList<>();
			
			String temp;
			for (T t : array)
			{
				temp = (t == null ? "null" : function.apply(t));
				maxLength = Math.max(temp.length(), maxLength);
				outputs.add(temp);
			}
			
			StringBuilder string = new StringBuilder();
			
			if (topBorder != ' ')
			{
				for (int i = 0; i < leftBorder.length() + maxLength + rightBorder.length(); i++)
				{
					string.append(topBorder);
				}
				string.append('\n');
			}
			
			for (int i = 0; i < outputs.size(); i++)
			{
				string.append(leftBorder);
				string.append(StringFormatter.create(outputs.get(i), maxLength).setAlignment(alignment).build());
				string.append(rightBorder);
				if (i + 1 < outputs.size())
				{
					string.append('\n');
				}
			}
			
			if (bottomBorder != ' ')
			{
				string.append('\n');
				for (int i = 0; i < leftBorder.length() + maxLength + rightBorder.length(); i++)
				{
					string.append(bottomBorder);
				}
			}
			
			return string.toString();
		}
		
	}
	
	public static class ArrayBuilder2D<T>
	{
		
		private T[][] array;
		
		private ArrayBuilder2D(final T[][] array)
		{
			this.array = array;
		}
		
		public String build()
		{
			throw new UnsupportedOperationException();
		}
		
	}
	
}

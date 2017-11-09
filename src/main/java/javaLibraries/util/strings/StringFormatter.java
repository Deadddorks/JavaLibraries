package javaLibraries.util.strings;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import javaLibraries.util.strings.exceptions.StringLongerThanLengthException;
import java.security.InvalidParameterException;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/**
 * Allows for taking Strings and either expanding it or chopping it
 *
 * @author Deaddorks
 * @version 1.0
 */
public class StringFormatter
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	/**
	 * enum used to specify the alignment of the resulting formatted String
	 */
	public enum Alignment
	{
		LEFT, CENTER, RIGHT
	}
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * Private constructor to disable instantiation
	 */
	private StringFormatter() {}
	
	/**
	 * Creates a Builder with the base String to be set to length
	 * @param text String to be formatted
	 * @param length desired new length of the String
	 * @return a Builder that allows manipulation of the settings on how the string will be formatted
	 */
	public static Builder create(final String text, final int length)
	{
		return new Builder(text, length);
	}
	
	/**
	 * Allows manipulation of the settings on how the string will be formatted
	 *
	 * @author Deaddorks
	 * @version 1.0
	 */
	public static class Builder
	{
		
		private String text;
		private int length;
		private char filler;
		private boolean truncatePastLength;
		private Alignment alignment;
		
		private Builder(final String text, final int length)
		{
			if (text == null)
			{
				throw new NullPointerException("text == `null`");
			}
			if (length < 0)
			{
				throw new InvalidParameterException("Length < 0. ["+length+"]");
			}
			
			this.text = text;
			this.length = length;
			
			this.filler = ' ';
			
			this.truncatePastLength = false;
			this.alignment = Alignment.LEFT;
		}
		
		/**
		 * Sets whether or not it is allowed that the desired length is less than the actual Strings length.<br>
		 * If this is true, and the length is shorter, this will behave like a substring.<br>
		 * Based on the Alignment, different parts of the String will be returned
		 * @param value whether or not to allow lengths smaller than the String
		 * @return the Builder
		 */
		public Builder setTruncatePastLength(final boolean value)
		{
			truncatePastLength = value;
			return this;
		}
		
		/**
		 * Sets the alignment of the resulting formatted String.<br>
		 * LEFT: Characters will be added/removed only to/from the end of the String.<br>
		 * LEFT: Characters will be added/removed as evenly as possible to the beginning/end, favoring a left shift on odd numbers.<br>
		 * LEFT: Characters will be added/removed only to/from the beginning of the String.
		 * @param value Alignment value
		 * @return the Builder
		 */
		public Builder setAlignment(final Alignment value)
		{
			alignment = value;
			return this;
		}
		
		/**
		 * Sets the char that will be added to the blank spaces in the resulting String.<br>
		 * Only really matters in Strings where characters are being added
		 * @param value the specified char
		 * @return the Builder
		 */
		public Builder setFiller(final char value)
		{
			filler = value;
			return this;
		}
		
		/**
		 * Used to get the final product after all the desired settings have been specified
		 * @return the String resulting from all the specified settings
		 */
		public String build()
		{
			int extra = length - text.length();
			int addToFront;
			int addToBack;
			switch (alignment)
			{
				case LEFT:
					addToFront = 0;
					addToBack = extra;
					break;
				case CENTER:
					addToFront = extra / 2;
					addToBack = extra - addToFront;
					break;
				case RIGHT:
					addToFront = extra;
					addToBack = 0;
					break;
				default:
					throw new NullPointerException("Alignment is `null`.");
			}
			
			if (text.length() > length)
			{
				if (!truncatePastLength)
				{
					throw new StringLongerThanLengthException(text, length);
				}
				return text.substring(-addToFront, text.length() + addToBack);
			}
			else
			{
				StringBuilder string = new StringBuilder();
				for (int i = 0; i < addToFront; i++)
				{
					string.append(filler);
				}
				string.append(text);
				for (int i = 0; i < addToBack; i++)
				{
					string.append(filler);
				}
				return string.toString();
			}
		}
		
	}
	
}

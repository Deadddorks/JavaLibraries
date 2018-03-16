package javaLibraries.util.strings;

import javaLibraries.constants.Alignment;
import javaLibraries.util.strings.exceptions.StringLengthException;

import java.security.InvalidParameterException;

/**
 * Used to create Strings of a specified length by
 * filling in extra space
 *
 * @author Deaddorks
 * @version 2.0
 */
public class StringFormatter
{
	
	/**
	 * Specifies what to do if a String is inputted with a length
	 * greater than maxLength.<br>
	 * ALLOW :		Strings that exceed maxLength are simply returned as is<br>
	 * EXCEPTION :	Strings that exceed maxLength throw a StringLengthException<br>
	 * TRUNCATE :	Strings that exceed maxLength have the extra cut off
	 */
	public enum OverflowOption {ALLOW, EXCEPTION, TRUNCATE}
	
	private OverflowOption overflowOption;
	private Alignment alignment;
	
	private char fillerChar;
	private int maxLength;
	
	private StringFormatter(final OverflowOption overflowOption, final Alignment alignment, final char fillerChar, final int maxLength)
	{
		this.overflowOption = overflowOption;
		this.alignment = alignment;
		this.fillerChar = fillerChar;
		this.maxLength = maxLength;
	}
	
	/**
	 * Creates a new Builder with defaults
	 *
	 * @return a new Builder with defaults
	 */
	public static Builder builder()
	{
		return new Builder();
	}
	
	/**
	 * Formats a String with the specifications
	 *
	 * @param in the String to format
	 * @return the formatted String
	 */
	public String format(final String in)
	{
		if (in.length() > maxLength)
		{
			switch (overflowOption)
			{
				case ALLOW:
					return in;
				case TRUNCATE:
					return in.substring(0, maxLength);
				case EXCEPTION:
					throw new StringLengthException(maxLength, in);
				default:
					throw new RuntimeException("Switch Default");
			}
		}
		else
		{
			int toAddTotal = maxLength - in.length();
			int toAddBefore, toAddAfter;
			switch (alignment)
			{
				case LEFT:
					toAddBefore = 0;
					toAddAfter = toAddTotal;
					break;
				case RIGHT:
					toAddBefore = toAddTotal;
					toAddAfter = 0;
					break;
				case CENTER:
					toAddBefore = toAddTotal / 2;
					toAddAfter = toAddTotal - toAddBefore;
					break;
				default:
					throw new RuntimeException("Switch default");
			}
			
			StringBuilder string = new StringBuilder();
			for (int i = 0; i < toAddBefore; i++)
			{
				string.append(fillerChar);
			}
			string.append(in);
			for (int i = 0; i < toAddAfter; i++)
			{
				string.append(fillerChar);
			}
			return string.toString();
		}
	}
	
	/**
	 * Used to build a StringFormatter
	 *
	 * @author Deaddorks
	 * @version 2.0
	 */
	public static class Builder
	{
		
		private OverflowOption overflowOption;
		private Alignment alignment;
		
		private char fillerChar;
		private int maxLength;
		
		private Builder()
		{
			overflowOption = OverflowOption.EXCEPTION;
			alignment = Alignment.LEFT;
			
			fillerChar = ' ';
			maxLength = 0;
		}
		
		/**
		 * Sets the OverflowOption for the Builder
		 *
		 * @param overflowOption the specified OverflowOption
		 * @return the Builder
		 */
		public Builder setOverflowOption(final OverflowOption overflowOption)
		{
			if (overflowOption == null)
			{
				throw new InvalidParameterException("overflowOption must be != null");
			}
			
			this.overflowOption = overflowOption;
			return this;
		}
		
		/**
		 * Sets the Alignment for the Builder
		 *
		 * @param alignment the specified Alignment
		 * @return the Builder
		 */
		public Builder setAlignment(final Alignment alignment)
		{
			if (alignment == null)
			{
				throw new InvalidParameterException("alignment must be != null");
			}
			
			this.alignment = alignment;
			return this;
		}
		
		/**
		 * Sets the fillerChar for the Builder
		 *
		 * @param fillerChar the char that fills the extra space in the String
		 * @return the Builder
		 */
		public Builder setFillerChar(final char fillerChar)
		{
			this.fillerChar = fillerChar;
			return this;
		}
		
		/**
		 * Sets the maxLength for the Builder
		 *
		 * @param maxLength the maximum length of the formatted String
		 * @return the Builder
		 */
		public Builder setMaxLength(final int maxLength)
		{
			if (maxLength < 0)
			{
				throw new InvalidParameterException("maxLength must be >= 0");
			}
			
			this.maxLength = maxLength;
			return this;
		}
		
		/**
		 * Builds a StringFormatter with the specified properties
		 *
		 * @return a StringFormatter with the specified properties
		 */
		public StringFormatter build()
		{
			return new StringFormatter(overflowOption, alignment, fillerChar, maxLength);
		}
		
	}

}

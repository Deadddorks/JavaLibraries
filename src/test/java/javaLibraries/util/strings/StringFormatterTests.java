package javaLibraries.util.strings;

import javaLibraries.util.strings.exceptions.StringLongerThanLengthException;
import org.junit.Test;
import java.security.InvalidParameterException;

import static org.junit.Assert.*;
import static javaLibraries.constants.Alignment.*;

public class StringFormatterTests
{

	@Test
	public void testNoErrors()
	{
		StringFormatter.create("Test", 4).build();
		StringFormatter.create("Test", 4).setAlignment(CENTER).build();
		StringFormatter.create("Test", 4).setAlignment(RIGHT).build();
		
		StringFormatter.create("test", 3).setTruncatePastLength(true).build();
		StringFormatter.create("test", 0).setTruncatePastLength(true).build();
	}
	
	@Test (expected = InvalidParameterException.class)
	public void testThrowsException_1()
	{
		StringFormatter.create("", -1);
	}
	@Test (expected = StringLongerThanLengthException.class)
	public void testThrowsException_2()
	{
		StringFormatter.create("test", 3).build();
	}
	@Test (expected = NullPointerException.class)
	public void testThrowsException_3()
	{
	    StringFormatter.create(null, 4);
	}
	
	@Test
	public void testValues_1()
	{
		assertEquals("test", StringFormatter.create("test", 4).setAlignment(LEFT).build());
		assertEquals("test", StringFormatter.create("test", 4).setAlignment(CENTER).build());
		assertEquals("test", StringFormatter.create("test", 4).setAlignment(RIGHT).build());
	}
	@Test
	public void testValues_2()
	{
		assertEquals("test  ", StringFormatter.create("test", 6).setAlignment(LEFT).build());
		assertEquals(" test ", StringFormatter.create("test", 6).setAlignment(CENTER).build());
		assertEquals("  test", StringFormatter.create("test", 6).setAlignment(RIGHT).build());
	}
	@Test
	public void testValues_3()
	{
		assertEquals("test   ", StringFormatter.create("test", 7).setAlignment(LEFT).build());
		assertEquals(" test  ", StringFormatter.create("test", 7).setAlignment(CENTER).build());
		assertEquals("   test", StringFormatter.create("test", 7).setAlignment(RIGHT).build());
	}
	@Test
	public void testValues_4()
	{
		assertEquals("test", StringFormatter.create("test", 4).setTruncatePastLength(true).setAlignment(LEFT).build());
		assertEquals("test", StringFormatter.create("test", 4).setTruncatePastLength(true).setAlignment(CENTER).build());
		assertEquals("test", StringFormatter.create("test", 4).setTruncatePastLength(true).setAlignment(RIGHT).build());
	}
	@Test
	public void testValues_5()
	{
		assertEquals("te", StringFormatter.create("test", 2).setTruncatePastLength(true).setAlignment(LEFT).build());
		assertEquals("es", StringFormatter.create("test", 2).setTruncatePastLength(true).setAlignment(CENTER).build());
		assertEquals("st", StringFormatter.create("test", 2).setTruncatePastLength(true).setAlignment(RIGHT).build());
	}
	@Test
	public void testValues_6()
	{
		assertEquals("t", StringFormatter.create("test", 1).setTruncatePastLength(true).setAlignment(LEFT).build());
		assertEquals("e", StringFormatter.create("test", 1).setTruncatePastLength(true).setAlignment(CENTER).build());
		assertEquals("t", StringFormatter.create("test", 1).setTruncatePastLength(true).setAlignment(RIGHT).build());
	}
	@Test
	public void testValues_7()
	{
		assertEquals("test&&", StringFormatter.create("test", 6).setFiller('&').setAlignment(LEFT).build());
		assertEquals("&test&", StringFormatter.create("test", 6).setFiller('&').setAlignment(CENTER).build());
		assertEquals("&&test", StringFormatter.create("test", 6).setFiller('&').setAlignment(RIGHT).build());
	}
	@Test
	public void testValues_8()
	{
		assertEquals("te", StringFormatter.create("test", 2).setFiller('&').setTruncatePastLength(true).setAlignment(LEFT).build());
		assertEquals("es", StringFormatter.create("test", 2).setFiller('&').setTruncatePastLength(true).setAlignment(CENTER).build());
		assertEquals("st", StringFormatter.create("test", 2).setFiller('&').setTruncatePastLength(true).setAlignment(RIGHT).build());
	}

}

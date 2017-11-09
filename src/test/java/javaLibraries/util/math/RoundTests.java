package javaLibraries.util.math;

import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.*;

public class RoundTests
{
	
	@Test
	public void testRoundDoubleZeroDecimalPlaces()
	{
		assertEquals(2, Round.round(2.3, 0), 0);
		assertEquals(3, Round.round(2.6, 0), 0);
		assertEquals(3, Round.round(2.5, 0), 0);
		
		assertEquals(-2, Round.round(-2.3, 0), 0);
		assertEquals(-3, Round.round(-2.6, 0), 0);
		assertEquals(-2, Round.round(-2.5, 0), 0);
		assertEquals(-3, Round.round(-2.500001, 0), 0);
	}
	
	@Test
	public void testRoundDoublePositiveDecimalPlaces()
	{
	    double num = 1.23456789;
	    
	    assertEquals(1.0, Round.round(num, 0), 0);
	    assertEquals(1.2, Round.round(num, 1), 0);
	    assertEquals(1.23, Round.round(num, 2), 0);
	    assertEquals(1.235, Round.round(num, 3), 0);
	    assertEquals(1.2346, Round.round(num, 4), 0);
	    assertEquals(1.23457, Round.round(num, 5), 0);
	    assertEquals(1.234568, Round.round(num, 6), 0);
	    assertEquals(1.2345679, Round.round(num, 7), 0);
	    assertEquals(1.23456789, Round.round(num, 8), 0);
	    assertEquals(1.23456789, Round.round(num, 9), 0);
	}
	
	@Test
	public void testRoundDoubleNegativeDecimalPlaces()
	{
	    double num = 12345678.9;
	    
	    assertEquals(12345679, Round.round(num, 0), 0);
	    assertEquals(12345680, Round.round(num, -1), 0);
	    assertEquals(12345700, Round.round(num, -2), 0);
	    assertEquals(12346000, Round.round(num, -3), 0);
	    assertEquals(12350000, Round.round(num, -4), 0);
	    assertEquals(12300000, Round.round(num, -5), 0);
	    assertEquals(12000000, Round.round(num, -6), 0);
	    assertEquals(10000000, Round.round(num, -7), 0);
	    assertEquals(0, Round.round(num, -8), 0);
	}
	
	private void assertRoundToLengthEquals(final double input, final int length, final double expected)
	{
		assertEquals(expected, Round.roundToLength(input, length), 0);
	}
	
	@Test (expected = InvalidParameterException.class)
	public void testRoundToLengthThrowsException_1()
	{
		Round.roundToLength(0.0, 1);
	}
	@Test (expected = InvalidParameterException.class)
	public void testRoundToLengthThrowsException_2()
	{
		Round.roundToLength(0.0, 2);
	}
	@Test (expected = InvalidParameterException.class)
	public void testRoundToLengthThrowsException_3()
	{
		Round.roundToLength(-1.0, 3);
	}
	@Test (expected = InvalidParameterException.class)
	public void testRoundToLengthThrowsException_4()
	{
		Round.roundToLength(-9.5, 3);
	}
	@Test (expected = InvalidParameterException.class)
	public void testRoundToLengthThrowsException_5()
	{
		Round.roundToLength(-0.5, 3);
	}
	
	@Test
	public void testRoundToLengthPasses_1()
	{
		Round.roundToLength(0.0, 3);
	}
	@Test
	public void testRoundToLengthPasses_2()
	{
		Round.roundToLength(0.5, 3);
		Round.roundToLength(-0.5, 4);
		Round.roundToLength(5.0, 3);
		Round.roundToLength(9.4, 3);
		Round.roundToLength(-9.5, 4);
	}
	
	@Test
	public void testRoundToLength_1()
	{
		assertRoundToLengthEquals(0, 3, 0);
	}
	@Test
	public void testRoundToLength_2()
	{
		assertRoundToLengthEquals(0.5, 3, 0.5);
	}
	@Test
	public void testRoundToLength_3()
	{
		assertRoundToLengthEquals(5.5, 3, 5.5);
	}
	@Test
	public void testRoundToLength_4()
	{
		assertRoundToLengthEquals(9.5, 3, 9.5);
		assertRoundToLengthEquals(9.5, 4, 9.5);
		assertRoundToLengthEquals(9.51, 3, 9.5);
	}
	@Test
	public void testRoundToLength_5()
	{
		assertRoundToLengthEquals(19.515, 4, 19.5);
		assertRoundToLengthEquals(19.515, 5, 19.52);
	}

}

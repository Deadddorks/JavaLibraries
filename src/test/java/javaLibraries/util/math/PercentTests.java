package javaLibraries.util.math;

import javaLibraries.util.math.exceptions.InvalidPercentException;
import org.junit.Test;
import static org.junit.Assert.*;

public class PercentTests
{
	
	@Test
	public void testRandom()
	{
		Percent p = new Percent(50);
		for (int i = 0; i < 50; i++)
		{
			System.out.println(p.randomTest());
		}
	}
	
	@Test
	public void testPercentCompareTo()
	{
	    Percent p1 = new Percent(50);
	    Percent p2 = new Percent(50);
	    Percent p3 = new Percent(40);
	    Percent p4 = new Percent(60);
	    Percent p5 = new Percent(100);
	    
	    assertEquals(1, p5.compareTo(p4));
	    assertEquals(0, p1.compareTo(p2));
	    assertEquals(1, p1.compareTo(p3));
	    assertEquals(-1, p1.compareTo(p4));
	}
	
	@Test (expected = InvalidPercentException.class)
	public void testInvalidPercent_1()
	{
		new Percent(-0.001);
	}
	@Test (expected = InvalidPercentException.class)
	public void testInvalidPercent_2()
	{
		new Percent(100.001);
	}
	
}

package javaLibraries.util.cycle;

import javaLibraries.util.cycle.exceptions.InvalidIntRangeException;
import javaLibraries.util.cycle.exceptions.InvalidLoopSizeException;
import org.junit.Test;
import static org.junit.Assert.*;

public class CyclicIntListTest
{
	
	@Test
	public void testCreationNoErrors()
	{
	    CyclicIntList list;
	    
	    list = new CyclicIntList(3);
	    list = new CyclicIntList(2);
	    list = new CyclicIntList(1);
	    
	    list = new CyclicIntList(2, 5);
	    list = new CyclicIntList(2, 4);
	    list = new CyclicIntList(2, 3);
	    
	    list = new CyclicIntList(1, 3, 1);
	    list = new CyclicIntList(1, 3, 2);
	    list = new CyclicIntList(1, 3, 3);
	}
	
	@Test (expected = InvalidLoopSizeException.class)
	public void testThrowsException_1()
	{
		CyclicIntList list = new CyclicIntList(0);
	}
	@Test (expected = InvalidLoopSizeException.class)
	public void testThrowsException_2()
	{
		CyclicIntList list = new CyclicIntList(1, 1);
	}
	@Test (expected = InvalidIntRangeException.class)
	public void testThrowsException_3()
	{
		CyclicIntList list = new CyclicIntList(-1);
	}
	@Test (expected = InvalidIntRangeException.class)
	public void testThrowsException_4()
	{
		CyclicIntList list = new CyclicIntList(1, 0);
	}
	@Test (expected = InvalidIntRangeException.class)
	public void testThrowsException_5()
	{
		CyclicIntList list = new CyclicIntList(1, 3, 0);
	}
	@Test (expected = InvalidIntRangeException.class)
	public void testThrowsException_6()
	{
		CyclicIntList list = new CyclicIntList(1, 3, 4);
	}
	
	@Test
	public void testIteratesToTopNoWrap()
	{
		CyclicIntList list = new CyclicIntList(0, 5);
		assertEquals(0, (int) list.get());
		for (int i = 1; i < 5; i++)
		{
			assertEquals(i, (int) list.getNext());
		}
	}
	@Test
	public void testIteratesToBottomNoWrap()
	{
		CyclicIntList list = new CyclicIntList(0, 5, 5);
		assertEquals(5, (int) list.get());
		for (int i = 4; i >= 0; i--)
		{
			assertEquals(i, (int) list.getPrev());
		}
	}
	
	@Test
	public void testLoopsGoingUp()
	{
		int min = 0;
		int max = 7;
		int start = 5;
		int count = 50;
		CyclicIntList list = new CyclicIntList(min, max, start);
		
		for (int i = 0; i < count; i++)
		{
			start++;
			start = start > max ? min : start;
			
			assertEquals(start, (int) list.getNext());
		}
	}
	@Test
	public void testLoopsGoingDown()
	{
		int min = 0;
		int max = 7;
		int start = 5;
		int count = 50;
		CyclicIntList list = new CyclicIntList(min, max, start);
		
		for (int i = 0; i < count; i++)
		{
			start--;
			start = start < min ? max : start;
			
			assertEquals(start, (int) list.getPrev());
		}
	}
	
}

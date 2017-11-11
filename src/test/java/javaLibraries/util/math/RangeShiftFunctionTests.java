package javaLibraries.util.math;

import org.junit.Test;
import static org.junit.Assert.*;

public class RangeShiftFunctionTests
{
	
	@Test
	public void test_1()
	{
	    RangeShiftFunction funct = new RangeShiftFunction(0, 1, 0, 3);
	    assertEquals(0, funct.oldToNew(0), 0);
	    assertEquals(0, funct.newToOld(0), 0);
	    
	    assertEquals(3, funct.oldToNew(1), 0);
	    assertEquals(1, funct.newToOld(3), 0);
	}
	
	@Test
	public void test_2()
	{
		RangeShiftFunction funct = new RangeShiftFunction(1, 5, 2, 10);
		
		for (int i = 1; i <= 5; i++)
		{
			assertEquals(2 * i, funct.oldToNew(i), 0);
			assertEquals(i, funct.newToOld(2 * i), 0);
		}
	}
	
}

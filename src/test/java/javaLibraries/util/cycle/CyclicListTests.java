package javaLibraries.util.cycle;

import javaLibraries.util.cycle.exceptions.InvalidLoopSizeException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class CyclicListTests
{
	
	private List<String> getStringList()
	{
		return new ArrayList<>(Arrays.asList(new String[] {"A", "B", "C", "D"}));
	}
	private CyclicList<String> getCyclicList()
	{
		return new CyclicList<>(getStringList());
	}
	
	@Test
	public void testCreatingListValid()
	{
		CyclicList<String> list = new CyclicList<>(Arrays.asList(new String[] {"A", "B"}));
	}
	@Test (expected = InvalidLoopSizeException.class)
	public void testCreatingListInvalid_1()
	{
		CyclicList<String> list = new CyclicList<>(Arrays.asList(new String[] {"A"}));
	}
	@Test (expected = InvalidLoopSizeException.class)
	public void testCreatingListInvalid_2()
	{
		CyclicList<String> list = new CyclicList<>(Arrays.asList(new String[] {}));
	}
	@Test (expected = InvalidLoopSizeException.class)
	public void testCreatingListInvalid_3()
	{
		CyclicList<String> list = new CyclicList<>(null);
	}
	
	@Test
	public void testLoopSize()
	{
		final int testSize = 100;
		
	    List<String> elements = new ArrayList<>();
	    elements.add("");
		
	    CyclicList<String> list;
		for (int i = 2; i < testSize; i++)
		{
			elements.add("");
			list = new CyclicList<>(elements);
			assertEquals("List size equals element size: ["+i+"]", i, list.getLoopSize());
		}
	}
	
	@Test
	public void testListIteratesProperlyExcludingWrapping()
	{
		List<String> elements = getStringList();
		CyclicList<String> list = getCyclicList();
		
		for (int i = 0; i < list.getLoopSize(); i++)
		{
			assertEquals("Value equals what it should be:", elements.get(i), list.get());
			if (i + 1 < list.getLoopSize())
			{
				list.next();
			}
		}
	}
	
	@Test
	public void testListIteratesBackwardsProperlyExcludingWrapping()
	{
		List<String> elements = getStringList();
		CyclicList<String> list = getCyclicList();
		
		list.next();
		list.next();
		list.next();
		
		for (int i = list.getLoopSize() - 1; i >= 0; i--)
		{
			assertEquals("Value equals what it should be:", elements.get(i), list.get());
			if (i > 0)
			{
				list.prev();
			}
		}
	}
	
	@Test
	public void testLoopsProperlyLoopingForward()
	{
		final int testSize = 10;
		
		List<String> elements = getStringList();
		CyclicList<String> list = getCyclicList();
		
		for (int i = 0; i < testSize; i++)
		{
			for (int j = 0; j < list.getLoopSize(); j++)
			{
				assertEquals(elements.get(j), list.get());
				list.next();
			}
		}
	}
	
	@Test
	public void testLoopsProperlyLoopingBackward()
	{
		final int testSize = 10;
		
		List<String> elements = getStringList();
		CyclicList<String> list = getCyclicList();
		
		for (int i = 0; i < testSize; i++)
		{
			for (int j = list.getLoopSize() - 1; j >= 0; j--)
			{
				assertEquals(elements.get(j), list.getPrev());
			}
		}
	}
	
}

package javaLibraries.util.math;
import org.junit.Test;
import static org.junit.Assert.*;

public class RandomTests
{
	
	@Test
	public void testRandomInt0_Max()
	{
		final boolean printEvery = false;
		final int max = 10;
		final int iterationCount = 1000;
		
		int minCreated = 0;
		int maxCreated = 0;
		
		int created;
		long sum = 0;
		for (int i = 0; i < iterationCount; i++)
		{
			created = Random.randomInt(max);
			
			assertTrue(created >= 0);
			assertTrue(created <= max);
			
			sum += created;
			if (i == 0)
			{
				minCreated = created;
				maxCreated = max;
			}
			else
			{
				minCreated = Math.min(created, minCreated);
				maxCreated = Math.max(created, maxCreated);
			}
			if (printEvery)
			{
				System.out.println("<"+created+">");
			}
		}
		
		System.out.println(" --- Testin Random Int 0-["+max+"] --- ");
		System.out.println("Min Created: [" + minCreated + "]");
		System.out.println("Max Created: [" + maxCreated + "]");
		System.out.println("Average: ["+(1f * sum / iterationCount)+"]");
	}
	
	@Test
	public void testRandomIntMin_Max()
	{
		final boolean printEvery = false;
		final int min = 5;
		final int max = 15;
		final int iterationCount = 1000;
		
		int minCreated = 0;
		int maxCreated = 0;
		
		int created;
		long sum = 0;
		for (int i = 0; i < iterationCount; i++)
		{
			created = Random.randomInt(min, max);
			
			assertTrue(created >= min);
			assertTrue(created <= max);
			
			sum += created;
			if (i == 0)
			{
				minCreated = created;
				maxCreated = max;
			}
			else
			{
				minCreated = Math.min(created, minCreated);
				maxCreated = Math.max(created, maxCreated);
			}
			if (printEvery)
			{
				System.out.println("<"+created+">");
			}
		}
		
		System.out.println(" --- Testin Random Int ["+min+"]-["+max+"] --- ");
		System.out.println("Min Created: [" + minCreated + "]");
		System.out.println("Max Created: [" + maxCreated + "]");
		System.out.println("Average: ["+(1f * sum / iterationCount)+"]");
	}
	
	@Test
	public void testRandomDouble0_Max()
	{
		final boolean printEvery = false;
		final double max = 10;
		final int iterationCount = 1000;
		
		double minCreated = 0;
		double maxCreated = 0;
		
		double created;
		double sum = 0;
		for (int i = 0; i < iterationCount; i++)
		{
			created = Random.randomDouble(max);
			
			assertTrue(created >= 0);
			assertTrue(created <= max);
			
			sum += created;
			if (i == 0)
			{
				minCreated = created;
				maxCreated = max;
			}
			else
			{
				minCreated = Math.min(created, minCreated);
				maxCreated = Math.max(created, maxCreated);
			}
			if (printEvery)
			{
				System.out.println("<"+created+">");
			}
		}
		
		System.out.println(" --- Testin Random Double 0.0-["+max+"] --- ");
		System.out.println("Min Created: [" + minCreated + "]");
		System.out.println("Max Created: [" + maxCreated + "]");
		System.out.println("Average: ["+(1f * sum / iterationCount)+"]");
	}
	
	@Test
	public void testRandomDoubleMin_Max()
	{
		final boolean printEvery = false;
		final double min = 5;
		final double max = 15;
		final int iterationCount = 1000;
		
		double minCreated = 0;
		double maxCreated = 0;
		
		double created;
		double sum = 0;
		for (int i = 0; i < iterationCount; i++)
		{
			created = Random.randomDouble(min, max);
			
			assertTrue(created >= min);
			assertTrue(created <= max);
			
			sum += created;
			if (i == 0)
			{
				minCreated = created;
				maxCreated = max;
			}
			else
			{
				minCreated = Math.min(created, minCreated);
				maxCreated = Math.max(created, maxCreated);
			}
			if (printEvery)
			{
				System.out.println("<"+created+">");
			}
		}
		
		System.out.println(" --- Testin Random Double ["+min+"]-["+max+"] --- ");
		System.out.println("Min Created: [" + minCreated + "]");
		System.out.println("Max Created: [" + maxCreated + "]");
		System.out.println("Average: ["+(1f * sum / iterationCount)+"]");
	}

}

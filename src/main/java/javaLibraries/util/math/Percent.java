package javaLibraries.util.math;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import javaLibraries.util.math.exceptions.InvalidPercentException;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class Percent implements Comparable<Percent>
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	private float percent;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public Percent(final float percent)
	{
		init(percent);
	}
	public Percent(final double percent)
	{
		init((float) percent);
	}
	
	private void init(final float percent)
	{
		if (percent < 0 || percent > 100)
		{
			throw new InvalidPercentException(percent);
		}
		this.percent = percent;
	}
	
	public boolean randomTest()
	{
		return compareTo(getRandomPercent()) >= 0;
	}
	
	public static Percent getRandomPercent()
	{
		return new Percent(Random.randomDouble(100));
	}
	
	@Override
	public int compareTo(final Percent o)
	{
		if (percent == 100)
		{
			return 1;
		}
		return (int) Math.signum(Float.compare(percent, o.percent));
	}
	
	@Override
	public String toString()
	{
		return "{Percent} {percent: ["+percent+"%]}";
	}
	
}

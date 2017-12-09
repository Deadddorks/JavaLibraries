package javaLibraries.util.math;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import javaLibraries.util.math.exceptions.InvalidPercentException;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/**
 * Holds a float between 0 and 100, and holds utilities such as random % of time
 *
 * @author Deaddorks
 */
public class Percent implements Comparable<Percent>
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	private float percent;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * Creates a new Percent
	 *
	 * @param percent float value of a Percent
	 */
	public Percent(final float percent)
	{
		init(percent);
	}
	/**
	 * Creates a new Percent from a double by casting the double to a float
	 *
	 * @param percent double (float) value of a Percent
	 */
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
	
	/**
	 * Gets the float value of the Percent
	 *
	 * @return the float value of the Percent
	 */
	public float getPercent()
	{
		return percent;
	}
	
	/**
	 * Creates a random Percent and gets whether this Percent is greater
	 * than the randomly generated one
	 *
	 * @return true [percent%] of the time
	 */
	public boolean randomTest()
	{
		return compareTo(getRandomPercent()) >= 0;
	}
	/**
	 * Creates a random Percent and gets whether the specified Percent is greater
	 * than the randomly generated one
	 *
	 * @return true [percent%] of the time
	 */
	public static boolean randomTest(final float percent)
	{
		return randomTest(new Percent(percent));
	}
	/**
	 * Creates a random Percent and gets whether the specified Percent is greater
	 * than the randomly generated one
	 *
	 * @return true [percent%] of the time
	 */
	public static boolean randomTest(final double percent)
	{
		return randomTest(new Percent(percent));
	}
	/**
	 * Creates a random Percent and gets whether the specified Percent is greater
	 * than the randomly generated one
	 *
	 * @return true [percent%] of the time
	 */
	public static boolean randomTest(final Percent percent)
	{
		return percent.randomTest();
	}
	
	/**
	 * Generates a random Percent between 0 and 100
	 *
	 * @return a random Percent between 0 and 100
	 */
	public static Percent getRandomPercent()
	{
		return new Percent(Random.randomDouble(100));
	}
	
	/**
	 * Compares this Percent to another
	 *
	 * @param o another Percent for comparison
	 * @return (-1 : less than, 0 : equal to, 1 : greater than)
	 */
	@Override
	public int compareTo(final Percent o)
	{
		return (int) Math.signum(Float.compare(percent, o.percent));
	}
	
	/**
	 * Gets a String representation of this Percent
	 *
	 * @return a String representation of this Percent
	 */
	@Override
	public String toString()
	{
		return "{Percent} {percent: ["+percent+"%]}";
	}
	
}

package javaLibraries.util.time;

// ~~~~~~~~~~ Imports ~~~~~~~~~~

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/**
 * Turn a time in nanos to other time units
 *
 * @author Deaddorks
 */
public class Duration
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	private final long durationAsNanos;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * Creates a Duration with the specified nano-second duration
	 *
	 * @param durationAsNanos the specified nano-second duration
	 */
	public Duration(final long durationAsNanos)
	{
		this.durationAsNanos = durationAsNanos;
	}
	
	/**
	 * Gets the duration in long as nanos
	 *
	 * @return the duration as nanos
	 */
	public long asNanos()
	{
		return durationAsNanos;
	}
	/**
	 * Gets the duration in long as millis
	 *
	 * @return the duration as nanos
	 */
	public long asMillis()
	{
		return Math.round(durationAsNanos / Math.pow(10, 6));
	}
	/**
	 * Gets the duration in long as secs
	 *
	 * @return the duration as nanos
	 */
	public long asSecs()
	{
		return Math.round(asSecsExact());
	}
	/**
	 * Gets the duration in double as secs
	 *
	 * @return the duration as nanos
	 */
	public double asSecsExact()
	{
		return durationAsNanos / Math.pow(10, 9);
	}
	
}

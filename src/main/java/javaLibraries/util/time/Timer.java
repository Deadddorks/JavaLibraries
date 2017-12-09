package javaLibraries.util.time;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import javaLibraries.util.time.exceptions.TimerNotRunningException;

import java.security.InvalidParameterException;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/**
 * Used in order to start/stop a timer, and read how long since the start
 *
 * @author Deaddorks
 */
public class Timer
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	public enum TimeUnit {NANOS, MILLIS, SECS}
	
	private static final boolean AUTO_START_DEFAULT = false;
	private static final TimeUnit DEFAULT_DEFAULT_TIME_UNIT = TimeUnit.MILLIS;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	private boolean running;
	private long startTime;
	
	private TimeUnit defaultTimeUnit;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/**
	 * Creates a Timer with all of the defaults
	 */
	public Timer()
	{
		init(AUTO_START_DEFAULT, DEFAULT_DEFAULT_TIME_UNIT);
	}
	/**
	 * Creates a Timer with default autoStart and the specified defaultTimeUnit
	 *
	 * @param defaultTimeUnit the specified defaultTimeUnit
	 */
	public Timer(final TimeUnit defaultTimeUnit)
	{
		init(AUTO_START_DEFAULT, defaultTimeUnit);
	}
	/**
	 * Creates a Timer with default defaultTimeUnit and the specified autoStart
	 *
	 * @param autoStart the specified autoStart
	 */
	public Timer(final boolean autoStart)
	{
		init(autoStart, DEFAULT_DEFAULT_TIME_UNIT);
	}
	/**
	 * Creates a Timer with the specified autoStart and defaultTimeUnit
	 *
	 * @param autoStart the specified autoStart
	 * @param defaultTimeUnit the specified defaultTimeUnit
	 */
	public Timer(final boolean autoStart, final TimeUnit defaultTimeUnit)
	{
		init(autoStart, defaultTimeUnit);
	}
	
	private void init(final boolean autoStart, final TimeUnit defaultTimeUnit)
	{
		if (defaultTimeUnit == null)
		{
			throw new InvalidParameterException("'defaultTimeUnit' can not be 'null'");
		}
		this.defaultTimeUnit = defaultTimeUnit;
		stop();
		if (autoStart)
		{
			start();
		}
	}
	
	/**
	 * Starts the Timer
	 */
	public void start()
	{
		startTime = System.nanoTime();
		running = true;
	}
	/**
	 * Stops the Timer<br>
	 * The time can not be read while the Timer is stopped
	 */
	public void stop()
	{
		startTime = -1;
		running = false;
	}
	
	/**
	 * Gets the elapsed time based on the specified defaultTime
	 *
	 * @return the elapsed time based on the specified defaultTime
	 */
	public long read()
	{
		switch (defaultTimeUnit)
		{
			case NANOS:
				return readNanos();
			case MILLIS:
				return readMillis();
			case SECS:
				return readSecs();
			default:
				throw new RuntimeException("Invalid default time");
		}
	}
	
	/**
	 * Gets the elapsed time as a Duration
	 *
	 * @return the elapsed time as a Duration
	 */
	public Duration readDuration()
	{
		if (!running)
		{
			throw new TimerNotRunningException();
		}
		return new Duration(System.nanoTime() - startTime);
	}
	/**
	 * Gets the elapsed time as nanos
	 *
	 * @return the elapsed time as nanos
	 */
	public long readNanos()
	{
		return readDuration().asNanos();
	}
	/**
	 * Gets the elapsed time as millis (rounded)
	 *
	 * @return the elapsed time as millis (rounded)
	 */
	public long readMillis()
	{
		return readDuration().asMillis();
	}
	/**
	 * Gets the elapsed time as secs (rounded)
	 *
	 * @return the elapsed time as secs (rounded)
	 */
	public long readSecs()
	{
		return readDuration().asSecs();
	}
	/**
	 * Gets the elapsed time as seconds (double)
	 *
	 * @return the elapsed time as seconds (double)
	 */
	public double readSecsExact()
	{
		return readDuration().asSecsExact();
	}
	
}

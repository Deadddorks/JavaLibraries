package javaLibraries.util.time;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import javaLibraries.util.time.exceptions.ErrorSleepingException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/**
 * Holds useful methods dealing with time, such as sleep, and getting date/time
 *
 * @author Deaddorks
 */
public class Time
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	private static final boolean THROW_SLEEP_EXCEPTION_DEFAULT = false;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	private Time() {}
	
	/**
	 * Sleeps for timeInMs milli-seconds, and throws ErrorSleepingException based on the default
	 *
	 * @param timeInMs milli-seconds to sleep
	 */
	public static void sleep(final long timeInMs)
	{
		sleep(timeInMs, THROW_SLEEP_EXCEPTION_DEFAULT);
	}
	/**
	 * Sleeps for timeInMs milli-seconds, and throws ErrorSleepingException based on the specified value
	 *
	 * @param timeInMs milli-seconds to sleep
	 * @param throwExceptionOnFailure whether or not to throw ErrorSleepingException on failure
	 */
	public static void sleep(final long timeInMs, final boolean throwExceptionOnFailure)
	{
		try
		{
			Thread.sleep(timeInMs);
		}
		catch (InterruptedException e)
		{
			if (throwExceptionOnFailure)
			{
				throw new ErrorSleepingException();
			}
			else
			{
				System.out.println("Error trying to sleep.");
			}
		}
	}
	
	/**
	 * Gets the current LocalDate
	 *
	 * @return the current LocalDate
	 */
	public static LocalDate getDate()
	{
		return LocalDate.now();
	}
	
	/**
	 * Gets the current LocalTime
	 *
	 * @return the current LocalTime
	 */
	public static LocalTime getTime()
	{
		return LocalTime.now();
	}
	
	/**
	 * Gets the current LocalDateTime
	 *
	 * @return the current LocalDateTime
	 */
	public static LocalDateTime getDateTime()
	{
		return LocalDateTime.now();
	}
	
}

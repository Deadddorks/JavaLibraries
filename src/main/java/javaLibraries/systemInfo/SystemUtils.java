package javaLibraries.systemInfo;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Toolkit;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/**
 * Utilities for accessing System data
 *
 * @author Deaddorks
 */
public class SystemUtils
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	private SystemUtils() {}
	
	public static ScreenLocation getCurrentMousePosition()
	{
		return new ScreenLocation(MouseInfo.getPointerInfo().getLocation());
	}
	public static Dimension getCurrentScreenSize()
	{
		return Toolkit.getDefaultToolkit().getScreenSize();
	}
	
	public static String getClipboardString()
	{
		return new ClipboardHandler().getClipboardString();
	}
	public static void setClipboardString(final String string)
	{
		new ClipboardHandler().setClipboardString(string);
	}
	
}

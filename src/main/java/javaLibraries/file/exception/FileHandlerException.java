package javaLibraries.file.exception;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import java.io.File;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class FileHandlerException extends Exception
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public FileHandlerException(final File file)
	{
		super("Error handling File at location: ["+file.getAbsolutePath()+"]");
	}
	public FileHandlerException(final String message)
	{
		super(message);
	}
	
}

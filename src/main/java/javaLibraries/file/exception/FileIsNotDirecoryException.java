package javaLibraries.file.exception;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import java.io.File;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class FileIsNotDirecoryException extends RuntimeException
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public FileIsNotDirecoryException(final File file)
	{
		super("File at location ["+file+"] is not a directory");
	}
	
}

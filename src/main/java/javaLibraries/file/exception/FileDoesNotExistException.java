package javaLibraries.file.exception;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import java.io.File;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class FileDoesNotExistException extends FileHandlerException
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public FileDoesNotExistException(final File file)
	{
		super("File does not exist at location: ["+file.getAbsolutePath()+"]");
	}
	
}

package javaLibraries.file.exception.interation;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import java.io.File;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class FileReadException extends FileInteractionException
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public FileReadException(final File file, final int lineNumber)
	{
		super("reading from", file, lineNumber);
	}
	
}

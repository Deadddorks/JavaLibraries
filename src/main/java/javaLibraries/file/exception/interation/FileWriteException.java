package javaLibraries.file.exception.interation;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import java.io.File;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class FileWriteException extends FileInteractionException
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public FileWriteException(final File file, final int lineNumber)
	{
		super("writing to", file, lineNumber);
	}
	
}

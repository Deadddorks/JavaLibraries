package javaLibraries.file.exception.creation;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import javaLibraries.file.exception.FileHandlerException;

import java.io.File;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class FileCreationException extends FileHandlerException
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public FileCreationException(final File file)
	{
		super("Could not create file at FilePath: ["+file.getAbsolutePath()+"]");
	}
	
}

package javaLibraries.file.exception.interation;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import javaLibraries.file.exception.FileHandlerException;

import java.io.File;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class FileInteractionException extends FileHandlerException
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public FileInteractionException(final File file)
	{
		super("Error interacting with File at location: ["+file.getAbsolutePath()+"]");
	}
	public FileInteractionException(final String interaction, final File file)
	{
		super("Error " + interaction + " File at location: ["+file.getAbsolutePath()+"]");
	}
	public FileInteractionException(final String interaction, final File file, final int lineNumber)
	{
		super("Error " + interaction + " File at location: ["+file.getAbsolutePath()+"]. Error occurred on line: ["+lineNumber+"]");
	}
	
}

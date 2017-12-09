package javaLibraries.systemInfo;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

/**
 * Add and retrieve Strings to the clipboard
 *
 * @author Deaddorks
 */
public class ClipboardHandler implements ClipboardOwner
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	@Override
	public void lostOwnership(final Clipboard clipboard, final Transferable contents)
	{
		System.out.println("Lost ownership");
	}
	
	public String getClipboardString()
	{
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable contents = clipboard.getContents(null);
		
		if (contents != null && contents.isDataFlavorSupported(DataFlavor.stringFlavor))
		{
			try
			{
				return (String) contents.getTransferData(DataFlavor.stringFlavor);
			}
			catch (IOException | UnsupportedFlavorException e)
			{
				return null;
			}
		}
		else
		{
			return null;
		}
	}
	
	public void setClipboardString(final String string)
	{
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(string), this);
	}
	
}

package javaLibraries.file;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import javaLibraries.file.exception.FileDoesNotExistException;
import javaLibraries.file.exception.creation.FileCreationException;
import javaLibraries.file.exception.interation.FileCloseException;
import javaLibraries.file.exception.interation.FileOpenException;
import javaLibraries.file.exception.interation.FileReadException;
import javaLibraries.file.exception.interation.FileWriteException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class FileHandler
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	private FileHandler() {}
	
	public static List<String> readLinesFromFile(final String filePath)
			throws FileOpenException, FileReadException, FileCloseException, FileDoesNotExistException
	{
		return readLinesFromFile(new File(filePath));
	}
	public static List<String> readLinesFromFile(final File file)
			throws FileOpenException, FileReadException, FileCloseException, FileDoesNotExistException
	{
		
		if (!file.exists())
		{
			throw new FileDoesNotExistException(file);
		}
		
		BufferedReader reader = null;
		List<String> lines = new ArrayList<>();
		
		try
		{
			reader = new BufferedReader(new FileReader(file));
		}
		catch (IOException e)
		{
			throw new FileOpenException(file);
		}
		
		int lineNumber = 1;
		try
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				lines.add(line);
			}
		}
		catch (IOException e)
		{
			throw new FileReadException(file, lineNumber);
		}
		finally
		{
			try
			{
				reader.close();
			}
			catch (IOException e)
			{
				throw new FileCloseException(file);
			}
		}
		
		return lines;
	}
	
	public static void writeLinesToFile(final String filePath, final List<String> data)
			throws FileOpenException, FileCloseException, FileWriteException, FileDoesNotExistException, FileCreationException
	{
		writeLinesToFile(new File(filePath), data);
	}
	public static void writeLinesToFile(final String filePath, final List<String> data, final boolean createFileIfDNE)
			throws FileOpenException, FileCloseException, FileWriteException, FileDoesNotExistException, FileCreationException
	{
		writeLinesToFile(new File(filePath), data, createFileIfDNE);
	}
	public static void writeLinesToFile(final File file, final List<String> data)
			throws FileOpenException, FileCloseException, FileWriteException, FileDoesNotExistException, FileCreationException
	{
		writeLinesToFile(file, data, true);
	}
	public static void writeLinesToFile(final File file, final List<String> data, final boolean createFileIfDNE)
			throws FileOpenException, FileCloseException, FileWriteException, FileDoesNotExistException, FileCreationException
	{
		sendDataToFile(file, data, createFileIfDNE, false);
	}
	
	public static void appendLinesToFile(final String filePath, final List<String> data)
			throws FileOpenException, FileCloseException, FileWriteException, FileDoesNotExistException, FileCreationException
	{
		appendLinesToFile(new File(filePath), data);
	}
	public static void appendLinesToFile(final File file, final List<String> data)
			throws FileOpenException, FileCloseException, FileWriteException, FileDoesNotExistException, FileCreationException
	{
		sendDataToFile(file, data, false, true);
	}
	
	private static void sendDataToFile(final File file, final List<String> data,final boolean createFileIfDNE, final boolean append)
			throws FileOpenException, FileCloseException, FileWriteException, FileDoesNotExistException, FileCreationException
	{
	
		if (!file.exists())
		{
			if (createFileIfDNE)
			{
				FileHandler.createFile(file);
			}
			else
			{
				throw new FileDoesNotExistException(file);
			}
		}
		
		BufferedWriter writer = null;
		
		try
		{
			writer = new BufferedWriter(new FileWriter(file, append));
		}
		catch(IOException e)
		{
			throw new FileOpenException(file);
		}
		
		int lineNumber = 1;
		try
		{
			for (String line : data)
			{
				if (lineNumber != 1 || append)
				{
					writer.newLine();
				}
				writer.write(line);
				
				lineNumber++;
			}
		}
		catch(IOException e)
		{
			throw new FileWriteException(file, lineNumber);
		}
		finally
		{
			try
			{
				writer.close();
			}
			catch(IOException e)
			{
				throw new FileCloseException(file);
			}
		}
	
	}
	
	public static boolean deleteFile(final String filePath)
	{
		return deleteFile(new File(filePath));
	}
	public static boolean deleteFile(final File file)
	{
		return file.delete();
	}
	
	public static boolean deleteDirectory(final String filePath)
	{
		return deleteDirectory(new File(filePath));
	}
	public static boolean deleteDirectory(final File file)
	{
		for (File internalFile : file.listFiles())
		{
			if (internalFile.isFile())
			{
				deleteFile(internalFile);
			}
			else if (internalFile.isDirectory())
			{
				deleteDirectory(internalFile);
			}
		}
		
		return deleteFile(file);
	}
	
	public static boolean createDirectoryToFile(final String filePath)
	{
		return createDirectoryToFile(new File(filePath));
	}
	public static boolean createDirectoryToFile(final File file)
	{
		return file.getParentFile().mkdirs();
	}
	
	public static boolean createFile(final String filePath) throws FileCreationException
	{
		return createFile(new File(filePath));
	}
	public static boolean createFile(final File file) throws FileCreationException
	{
		return createFileWithExistsLimiter(file, false);
	}
	public static boolean createFileIfDoesntExist(final String filePath) throws FileCreationException
	{
		return createFileIfDoesntExist(new File(filePath));
	}
	public static boolean createFileIfDoesntExist(final File file) throws FileCreationException
	{
		return createFileWithExistsLimiter(file, true);
	}
	
	private static boolean createFileWithExistsLimiter(final File file, final boolean onlyCreateNewIfNonExistent) throws FileCreationException
	{
		if (file.exists() && onlyCreateNewIfNonExistent)
		{
			return false;
		}
		
		createDirectoryToFile(file);
		if (file.exists() && !onlyCreateNewIfNonExistent)
		{
			file.delete();
		}
		
		try
		{
			file.createNewFile();
		}
		catch (IOException e)
		{
			throw new FileCreationException(file);
		}
		
		return true;
	}
	
}

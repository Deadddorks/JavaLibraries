package javaLibraries.file;

import javaLibraries.file.exception.creation.FileCreationException;
import org.junit.Test;

import static org.junit.Assert.*;

public class FileCreationTests
{
	
	@Test
	public void testCreatesFilesOnlyWhenItShould()
	{
		String filePath1 = "test/file1.txt";
		String filePath2 = "test/dir1/file1.txt";
		String filePath3 = "test/file2.txt";
		String filePath4 = "test/dir1/file2.txt";
		
		try
		{
			assertTrue(FileHandler.createFile(filePath1));
		}
		catch (FileCreationException e)
		{
			throw new RuntimeException(e.getMessage());
		}
		try
		{
			assertTrue(FileHandler.createFile(filePath2));
		}
		catch (FileCreationException e)
		{
			throw new RuntimeException(e.getMessage());
		}
		
		try
		{
			assertTrue(FileHandler.createFile(filePath1));
		}
		catch (FileCreationException e)
		{
			throw new RuntimeException(e.getMessage());
		}
		try
		{
			assertTrue(FileHandler.createFile(filePath2));
		}
		catch (FileCreationException e)
		{
			throw new RuntimeException(e.getMessage());
		}
		
		try
		{
			assertTrue(FileHandler.createFileIfDoesntExist(filePath3));
		}
		catch (FileCreationException e)
		{
			throw new RuntimeException(e.getMessage());
		}
		try
		{
			assertTrue(FileHandler.createFileIfDoesntExist(filePath4));
		}
		catch (FileCreationException e)
		{
			throw new RuntimeException(e.getMessage());
		}
		
		try
		{
			assertFalse(FileHandler.createFileIfDoesntExist(filePath3));
		}
		catch (FileCreationException e)
		{
			throw new RuntimeException(e.getMessage());
		}
		try
		{
			assertFalse(FileHandler.createFileIfDoesntExist(filePath4));
		}
		catch (FileCreationException e)
		{
			throw new RuntimeException(e.getMessage());
		}
	}
	
	@Test
	public void testCreateDirectoryToFile()
	{
		String filePath1 = "test/file3.txt";
		String filePath2 = "test/dir2/file3.txt";
		
		assertFalse(FileHandler.createDirectoryToFile(filePath1));
		assertTrue(FileHandler.createDirectoryToFile(filePath2));
	}
	
}

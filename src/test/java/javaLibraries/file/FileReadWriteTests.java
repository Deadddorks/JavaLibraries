package javaLibraries.file;

import javaLibraries.file.exception.FileHandlerException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FileReadWriteTests
{

	private String baseDir = "test";
	
	@Test
	public void testBasicReadAndWriteFile() throws FileHandlerException
	{
		String fileName = "file.txt";
		String filePath = baseDir + "/" + fileName;
		
		List<String> linesIn = new ArrayList<>(Arrays.asList(new String[] {"Kalin", "Marcus", "Jacob"}));
		List<String> linesOut;
		
		FileHandler.createFile(filePath);
		FileHandler.writeLinesToFile(filePath, linesIn);
		linesOut = FileHandler.readLinesFromFile(filePath);
		
		assertEquals(linesIn.size(), linesOut.size());
		for (int i = 0; i < linesIn.size(); i++)
		{
			assertEquals(linesIn.get(i), linesOut.get(i));
		}
		
		assertTrue(FileHandler.deleteDirectory(baseDir));
	}

}

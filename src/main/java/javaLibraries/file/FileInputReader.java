package javaLibraries.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Consumer;

public class FileInputReader
{
	
	public static void read(final File file, final Consumer<String> action)
	{
		try (BufferedReader reader = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				action.accept(line);
			}
		}
		catch (IOException e)
		{
			System.out.println("Error reading file. " + e.getClass().getSimpleName() + ", " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public static void read(final File file, final Consumer<String[]> action, final String split)
	{
		try (BufferedReader reader = new BufferedReader(new FileReader(file)))
		{
			String line;
			while ((line = reader.readLine()) != null)
			{
				action.accept(line.split(split));
			}
		}
		catch (IOException e)
		{
			System.out.println("Error reading file. " + e.getClass().getSimpleName() + ", " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}

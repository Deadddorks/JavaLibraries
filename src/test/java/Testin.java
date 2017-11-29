import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class Testin
{

	@Test
	public void test()
	{
		
		String path = "test/file1.txt";
		
		PrintWriter writer = null;
		
		try
		{
			writer = new PrintWriter(new FileWriter(path, true));
			
			writer.println("Hello File! (Append)");
		}
		catch (IOException e)
		{
			System.out.println("Error writing to file");
		}
		finally
		{
			writer.close();
		}
	
	}

}

import javaLibraries.file.FileInputReader;
import person.Person;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Testin
{
	
	public Testin()
	{
		List<Person> people = new ArrayList<>();
		
		FileInputReader.read(new File("data/Data.txt"), s -> {
			people.add(new Person(s[0], s[1], Integer.parseInt(s[2])));
		}, " ");
		
		for (Person p : people)
		{
			System.out.println(p.toString());
		}
	}
	
	public static void main(String[] args)
	{
	    Testin testin = new Testin();
	}
	
}

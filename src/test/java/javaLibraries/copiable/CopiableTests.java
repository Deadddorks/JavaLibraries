package javaLibraries.copiable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CopiableTests
{

	private List<Person> getPeople()
	{
		List<Person> people = new ArrayList<>();
		people.add(new Person("Kalin", 19));
		people.add(new Person("Janine", 16));
		people.add(new Person("Marcus", 19));
		return people;
	}
	
	@Test
	public void printPeople()
	{
		List<Person> people = getPeople();
		
		for (Person p : people)
		{
			System.out.println(p);
		}
		
	}
	
	@Test
	public void testCopiableFollowsRules()
	{
		List<Person> people = getPeople();
		
		for (Person p : people)
		{
			assertTrue(p.equals(p.copyOf()));
			assertFalse(p == p.copyOf());
			
			Person copy = p.copyOf();
			p.setAge(-1);
			
			assertFalse(p.equals(copy));
		}
	}
	
}

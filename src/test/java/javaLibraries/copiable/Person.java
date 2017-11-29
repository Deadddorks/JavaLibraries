package javaLibraries.copiable;

public class Person implements Copiable<Person>
{
	
	private final String name;
	private int age;
	
	public Person(final String name, final int age)
	{
		this.name = name;
		this.age = age;
	}
	
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int age)
	{
		this.age = age;
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (!(obj instanceof Person))
		{
			return false;
		}
		
		Person other = (Person) obj;
		
		return name.equalsIgnoreCase(other.name) && age == other.age;
	}
	
	@Override
	public String toString()
	{
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
	
	@Override
	public Person copyOf()
	{
		return new Person(name, age);
	}
}

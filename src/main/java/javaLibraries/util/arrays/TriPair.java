package javaLibraries.util.arrays;

// ~~~~~~~~~~ Imports ~~~~~~~~~~

// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class TriPair<A, B, C>
{
	
	// ~~~~~~~~~~ Constants ~~~~~~~~~~
	
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	private final A a;
	private final B b;
	private final C c;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public TriPair(final A a, final B b, final C c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public A getA()
	{
		return a;
	}
	public B getB()
	{
		return b;
	}
	public C getC()
	{
		return c;
	}
	
}

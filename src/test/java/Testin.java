import javaLibraries.util.math.NumberFormatter;

public class Testin
{
	
	public Testin()
	{
		double[] doubles = new double[] {0.0, 1.1, 12.12, 123.123, 1234.1234, 12345.12345, 123456.123456, 1234567.1234567, 12345678.12345678, 123456789.123456789, 1234567890.1234567890};
		
		System.out.println(" --- '+' --- ");
		for (double d : doubles)
		{
			System.out.println(NumberFormatter.formatDouble(d));
		}
		System.out.println(" --- '-' --- ");
		for (double d : doubles)
		{
			System.out.println(NumberFormatter.formatDouble(-1 * d));
		}
	}
	
	public static void main(String[] args)
	{
	    Testin testin = new Testin();
	}
	
}

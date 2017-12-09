
import org.junit.Test;
import static org.junit.Assert.*;
import static javaLibraries.util.logger.ColorString.*;
import javaLibraries.util.logger.StringColor;
import static javaLibraries.util.logger.StringColor.*;

public class Testin
{
	
	@Test
	public void testVehicle()
	{
		Vehicle vehicle = new Vehicle("Yamaha", "YZF-R6", 2001);
		System.out.println(vehicle.toString());
	}
	
	public class Vehicle
	{
		private String make;
		private String model;
		private int year;
		
		public Vehicle(final String make, final String model, final int year)
		{
			this.make = make;
			this.model = model;
			this.year = year;
		}
		
		@Override
		public String toString()
		{
			final StringColor BRACKETS = RED;
			final StringColor VARIABLES = BLUE;
			return asColor(BRACKETS, "{") + "Vehicle" + asColor(BRACKETS, "}") + " " +
					asColor(BRACKETS, "{") + "make: ["+asColor(VARIABLES, make)+"], model: ["+asColor(VARIABLES, model)+"], year: ["+asColor(VARIABLES, Integer.toString(year))+"]" +
					asColor(BRACKETS, "}");
		}
	}
	
}

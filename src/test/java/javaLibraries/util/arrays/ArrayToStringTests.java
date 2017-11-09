package javaLibraries.util.arrays;

import javaLibraries.constants.Alignment;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayToStringTests
{

	@Test
	public void testRunsNoErrors()
	{
	    String[] strings = new String[] {"Kalin", "Janine", "Marcus", "Jacob", "Alexander"};
	    String arrayAsString = ArrayToString.create1D(strings).setTopBorder('-').setBottomBorder('^').setLeftBorder("[").setRightBorder("]").build();
	    System.out.println(arrayAsString);
	}
	
	@Test
	public void test1D_1()
	{
		assertEquals("Kalin    "+'\n'+"Janine   "+'\n'+"Marcus   "+'\n'+"Jacob    "+'\n'+"Alexander",
				ArrayToString.create1D(new String[] {"Kalin", "Janine", "Marcus", "Jacob", "Alexander"}).build());
	}
	@Test
	public void test1D_2()
	{
		assertEquals("[Kalin    ]"+'\n'+"[Janine   ]"+'\n'+"[Marcus   ]"+'\n'+"[Jacob    ]"+'\n'+"[Alexander]",
				ArrayToString.create1D(new String[] {"Kalin", "Janine", "Marcus", "Jacob", "Alexander"}).setLeftBorder("[").setRightBorder("]").build());
	}
	@Test
	public void test1D_3()
	{
		assertEquals("-----------\n"+"[Kalin    ]"+'\n'+"[Janine   ]"+'\n'+"[Marcus   ]"+'\n'+"[Jacob    ]"+'\n'+"[Alexander]"+"\n^^^^^^^^^^^",
				ArrayToString.create1D(new String[] {"Kalin", "Janine", "Marcus", "Jacob", "Alexander"}).setTopBorder('-').setBottomBorder('^').setLeftBorder("[").setRightBorder("]").build());
	}
	@Test
	public void test1D_4()
	{
		assertEquals("-----------\n"+"[  Kalin  ]"+'\n'+"[ Janine  ]"+'\n'+"[ Marcus  ]"+'\n'+"[  Jacob  ]"+'\n'+"[Alexander]"+"\n^^^^^^^^^^^",
				ArrayToString.create1D(new String[] {"Kalin", "Janine", "Marcus", "Jacob", "Alexander"}).setAlignment(Alignment.CENTER).setTopBorder('-').setBottomBorder('^').setLeftBorder("[").setRightBorder("]").build());
	}
	@Test
	public void test1D_5()
	{
		assertEquals("-----------\n"+"[    Kalin]"+'\n'+"[   Janine]"+'\n'+"[   Marcus]"+'\n'+"[    Jacob]"+'\n'+"[Alexander]"+"\n^^^^^^^^^^^",
				ArrayToString.create1D(new String[] {"Kalin", "Janine", "Marcus", "Jacob", "Alexander"}).setAlignment(Alignment.RIGHT).setTopBorder('-').setBottomBorder('^').setLeftBorder("[").setRightBorder("]").build());
	}
	@Test
	public void test1D_6()
	{
		assertEquals("-----------\n"+"[Kalin    ]"+'\n'+"[Janine   ]"+'\n'+"[Marcus   ]"+'\n'+"[Jacob    ]"+'\n'+"[Alexander]"+"\n-----------",
				ArrayToString.create1D(new String[] {"Kalin", "Janine", "Marcus", "Jacob", "Alexander"}).setTopBorder('-').setBorders(ArrayToString.ArrayBuilder1D.Style.SURROUNDED).build());
	}

}

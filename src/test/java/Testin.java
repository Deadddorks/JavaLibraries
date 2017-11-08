import org.junit.Test;
import static org.junit.Assert.*;

public class Testin
{
	
	@Test
	public void test()
	{
		int min = 0;
		int max = 7;
		int j = 0;
		int i = min;
		while (j < 20)
		{
			j++;
			i = ++i > max ? min : i;
			System.out.println(i);
		}
	}

}

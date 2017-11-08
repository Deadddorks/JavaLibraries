import org.junit.Test;
import static org.junit.Assert.*;

public class Testin
{
	
	@Test
	public void test()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("A");
		builder.append("B");
		builder.append("C");
		String string = builder.toString();
		System.out.println("[" + string + "]");
	}

}

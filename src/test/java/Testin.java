import javaLibraries.systemInfo.SystemUtils;
import org.apache.commons.lang.StringEscapeUtils;

public class Testin
{

	public Testin()
	{
		for (char c : SystemUtils.getClipboardString().toCharArray())
		{
			System.out.println("\""+Character.toString(c)+"\" ("+c+") ["+Character.isDigit(c)+"]");
		}
	}
	
	public static void main(String[] args)
	{
	    Testin testin = new Testin();
	}
	
}

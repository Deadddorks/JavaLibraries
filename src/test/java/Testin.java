import javaLibraries.systemInfo.SystemInfo;
import org.apache.commons.lang.StringEscapeUtils;

public class Testin
{

	public Testin()
	{
		for (char c : SystemInfo.getClipboardString().toCharArray())
		{
			System.out.println("\""+Character.toString(c)+"\" ("+c+") ["+Character.isDigit(c)+"]");
		}
	}
	
	public static void main(String[] args)
	{
	    Testin testin = new Testin();
	}
	
}

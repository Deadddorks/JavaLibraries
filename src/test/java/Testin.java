import javaLibraries.util.time.Time;
import javaLibraries.util.time.Timer;

public class Testin
{

	public Testin()
	{
		Timer timer = new Timer();
		timer.start();
		Time.sleep(1000);
		System.out.println(timer.read());
	}
	
	public static void main(String[] args)
	{
	    Testin testin = new Testin();
	}
	
}

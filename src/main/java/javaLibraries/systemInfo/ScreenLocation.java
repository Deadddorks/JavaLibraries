package javaLibraries.systemInfo;

// ~~~~~~~~~~ Imports ~~~~~~~~~~
import java.awt.Point;
// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

public class ScreenLocation implements Comparable<ScreenLocation>
{
	
	// ~~~~~~~~~~ Variables ~~~~~~~~~~
	private final int x;
	private final int y;
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	public ScreenLocation(final int x, final int y)
	{
		this.x = x;
		this.y = y;
	}
	public ScreenLocation(final Point point)
	{
		this.x = (int) point.getX();
		this.y = (int) point.getY();
	}
	
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	
	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (!(obj instanceof ScreenLocation))
		{
			return false;
		}
		ScreenLocation otherLoc = (ScreenLocation) obj;
		
		return x == otherLoc.x && y == otherLoc.y;
		
	}
	
	@Override
	public int compareTo(final ScreenLocation o)
	{
		int xComp = (int) Math.signum(Integer.compare(x, o.x));
		int yComp = (int) Math.signum(Integer.compare(y, o.y));
		
		if (xComp == 0 && yComp == 0)
		{
			return 0;
		}
		else if (xComp <= 0 && yComp <= 0)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
}

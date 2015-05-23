
public class Player
{
	private boolean up,
					left,
					right;
	private boolean alive;
	private int x,
				y;
	private int gravity;
	
	public  Player()
	{
		up = false;
		left = false;
		right = false;
		alive = true;
		x = 0;
		y = 0;
		gravity = -1;
	}
	public void update(int x, int y)
	{
		if (left)
		{
			x-=1;
		}
		else if (right)
		{
			x+=1;
		}
	}
	public void render()
	{
		
	}
	public int getX()
	{
		return x;
	}
	public int getY()
	{
		return y;
	}
	public void setUp(boolean b)
	{
		up = b;
	}
	public void setLeft(boolean b)
	{
		left = b;
	}
	public void setright(boolean b)
	{
		right = b;
	}
}


public class Player
{
	private boolean up,
					left,
					right;
	private boolean alive;
	private int x,
				y;
	private int gravity;
	
	public  Player(int x,int y)
	{
		up = false;
		left = false;
		right = false;
		alive = true;
		this.x = x;
		this.y = y;
		gravity = -1;
	}
	public void update()
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
	public void setRight(boolean b)
	{
		right = b;
	}
}

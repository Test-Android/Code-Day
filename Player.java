
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
	public void update()
	{
		
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
	
}
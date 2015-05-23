import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;



public class grid 
{
	int[][] grid ;
	int x ,  y ;
	final int mutiplyer16bit = 16 ;
	int insetLeft;
	int insetTop;
	Player p;
	 
	public grid(int xvalue , int yvalue, Player p, int insetLeft, int insetTop)
	{
		this.insetLeft = insetLeft;
		this.insetTop = insetTop;
		this.x = xvalue ; 
		this.y = yvalue ;
		this.p = p;
		grid = new int[this.x][this.y];
		grid[2][3] = 1;
		grid[3][3] = 1;
		grid[4][3] = 1;
		grid[5][3] = 1;
	}
	public void setPositionNumAndDraw(Graphics g,int x , int y, int num )
	{
		grid[x][y] = num ;
	}
	public int getPositionNum(int x , int y ){return grid[x][y] ;}
	
	public void drawplayer(Graphics g , Image i )
	{
//		g.drawImage(i, playery, playerx, mutiplyer16bit*2, mutiplyer16bit*2, null);
	}
	public void updatePlayer()
	{
		if(grid[p.getX()][p.getY()+1] != 1)
		{
			if(p.getY() + 1 <  29)
				p.setY(p.getY() + 1);
			else
				p.setState(false);
		}
		p.update();
	}
	public void makenewcolumn()
	{
		int ypostion;
		ypostion =  y-1 ; 
		while(ypostion < y -3)
			ypostion = (int) Math.random()* y ; 
		
		grid[x-1][ypostion] = 1; 
		grid[x-1][ypostion+1] = 1; 
		grid[x-1][ypostion+2] = 1; 
		
	}
	 public void update()
	 {
		for(int x = 0; x < this.x - 1; x++)
		{
			for(int y =0; y < this.y; y++)
			{
				grid[x][y] = grid[x + 1][y];
				grid[x+1][y] = 0;
			}
		}
		updatePlayer();
	 }
	 public void render(Graphics2D bbg)
	 {
		for(int x = 0; x < this.x; x++)
		{
			for(int y = 0; y < this.y; y++)
			{
				if(grid[x][y] == 0)
	       		{
	       			bbg.setColor(Color.GRAY);
	       			bbg.fillRect(x *16 + insetLeft, y*16 + insetTop,16,16);
	       		}
	       		else if(grid[x][y] == 1)
	       		{
	       			bbg.setColor(Color.BLACK);
	       			bbg.fillRect(x *16 + insetLeft, y*16 + insetTop,16,16);
	       		}
			}
	    }
		p.render(bbg);
	 }

}

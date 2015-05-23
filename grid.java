import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;



public class grid 
{
	int[][] grid ;
	int x ,  y ;
	int playerx, playery ,playernum;
	final int mutiplyer16bit = 16 ;
	int insetLeft;
	int insetTop;
	
	public grid(int xvalue , int yvalue, int playerx,int playery, int insetLeft, int insetTop)
	{
		this.insetLeft = insetLeft;
		this.insetTop = insetTop;
		this.x = xvalue ; 
		this.y = yvalue ;
		this.playerx = playerx ; 
		this.playery = playery;
		this.playernum = 2;
		grid = new int[this.x][this.y];
		grid[playerx][playery] = 2 ; 
	}
	public void drawgrid(Graphics2D g)
	{
		for (int x = 0 ; x < this.x ; x ++)
			for (int y = 0 ; y < this.y ; y ++)
			{
				if(grid[x][y] == 1)
				g.drawRect(x*mutiplyer16bit + insetLeft, y*mutiplyer16bit + insetTop, mutiplyer16bit, mutiplyer16bit);
			}
	}
	public void setPositionNumAndDraw(Graphics g,int x , int y, int num )
	{
		grid[x][y] = num ;
	}
	public int getPositionNum(int x , int y ){return grid[x][y] ;}
	
	public void drawplayer(Graphics g , Image i )
	{
		g.drawImage(i, playery, playerx, mutiplyer16bit*2, mutiplyer16bit*2, null);
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
	
}

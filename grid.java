import java.awt.Graphics;
import java.awt.Image;



public class grid 
{
	int[][] grid ;
	int x ,  y ;
	int playerx, playery ,playernum;
	final int mutiplyer16bit = 16 ;
	public grid(int xvalue , int yvalue, int playerx,int playery)
	{
		this.x = xvalue ; 
		this.y = yvalue ;
		this.playerx = playerx ; 
		this.playery = playery;
		this.playernum = 2;
		grid = new int[this.x][this.y];
	}
	public void drawgrid(Graphics g )
	{
		for (int x = 0 ; x < this.x ; x ++)
			for (int y = 0 ; x < this.y ; y ++)
				g.drawRect(x*mutiplyer16bit, y*mutiplyer16bit, mutiplyer16bit, mutiplyer16bit);
	}
	public void setPositionNumAndDraw(Graphics g,int x , int y, int num )
	{
		grid[x][y] = num ;
		g.fillRect(x*mutiplyer16bit, y*mutiplyer16bit, mutiplyer16bit, mutiplyer16bit);
		
	}
	public int getPositionNum(int x , int y ){return grid[x][y] ;}
	
	
	
}

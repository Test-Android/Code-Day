import java.awt.Graphics;


public class grid 
{
	int[][] grid ;
	int x ,  y ;
	final int mutiplyer16bit = 16 ;
	public grid(int xvalue , int yvalue )
	{
		this.x = xvalue ; 
		this.y = yvalue ;
		
		grid = new int[this.x][this.y];
	}
	public void drawgrid(Graphics g )
	{
		for (int x = 0 ; x < this.x ; x ++)
			for (int y = 0 ; x < this.y ; y ++)
				g.drawRect(x*mutiplyer16bit, y*mutiplyer16bit, mutiplyer16bit, mutiplyer16bit);
	}
}

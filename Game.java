import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

//this is the main game thread class
public class Game extends JFrame implements Runnable
{
	private Thread thread;
	private boolean running = false;
	BufferedImage backBuffer;
	Graphics g;
	grid grid;
	int x,y;
	
	public Game()
	{
		this.setTitle("Gray Space");
		this.setBounds(0,0,GraySpaceMain.WIDTH,GraySpaceMain.HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setVisible(true);
		backBuffer = new BufferedImage(640,480,BufferedImage.TYPE_INT_RGB);
		x = 0;
		y = 0;
		grid = new grid(GraySpaceMain.WIDTH / 16, GraySpaceMain.HEIGHT / 16, 0, 0);
	}
	
	public synchronized void start()
	{
		running = true;
		thread = new Thread(this,"Display");
		thread.start();
	}
	
	public synchronized void stop()
	{
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("It failed inside the stop method:)");
		}
	}
	
	public void run()
	{
		while(running)
		{
			System.out.println("RUNNING");
			update();
			render();
		}
		stop();
	}
	
	public void update()
	{
		
	}
	
	public void render()
	{
		Graphics2D g = (Graphics2D)getGraphics();
        Graphics2D bbg = (Graphics2D)backBuffer.getGraphics();
        
        bbg.setColor(Color.WHITE);
        /*bbg.fillRect(0, 0, GraySpaceMain.WIDTH, GraySpaceMain.HEIGHT);
        
        bbg.setColor(Color.black);
        bbg.fillRect(x, y, 32, 32);*/
        grid.drawgrid(bbg);
        g.drawImage(backBuffer, 0, 0, this); 
        
        
	}

}

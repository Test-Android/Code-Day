import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;

//this is the main game thread class
public class Game extends JFrame implements Runnable
{
	private Thread thread;
	private boolean running = false;
	Graphics g;
	
	public Game()
	{
		this.setTitle("Gray Space");
		this.setBounds(0,0,640,480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setVisible(true);
		g = getGraphics();
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
			render();
		}
		stop();
	}
	
	public void update()
	{
		
	}
	
	public void render()
	{
		g.setColor(Color.BLUE);
		g.drawOval(0, 0, 20, 20);
		return;
	}

}

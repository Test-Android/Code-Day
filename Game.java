import java.awt.Graphics;

import javax.swing.JFrame;

//this is the main game thread class
public class Game implements Runnable
{
	private Thread thread;
	private boolean running = false;
	private JFrame frame;
	Graphics g;
	public Game()
	{
		frame = new JFrame();
		frame.setTitle("Gray Space");
		frame.setBounds(0,0,640,480);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		frame.setVisible(true);
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
		render();
		while(running)
		{
			System.out.println("RUNNING");
		}
		stop();
	}
	
	public void update()
	{
		
	}
	
	public void render()
	{
		g = frame.getGraphics();
		g.drawOval(0, 0, 20, 20);
	}

}

import javax.swing.JFrame;

//this is the main game thread class
public class Game implements Runnable
{
	private Thread thread;
	private boolean running = false;
	
	public Game()
	{}
	
	public Game(JFrame frame)
	{
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
		
	}

}

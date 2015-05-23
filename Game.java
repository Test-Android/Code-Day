//this is the main game thread class
public class Game implements Runnable
{
	private Thread thread;
	private boolean running = false;
	
	public Game()
	{
		
	}
	
	public synchronized void start()
	{
		running = true;
	}
	
	public synchronized void stop()
	{
		running = false;
	}
	
	public void run()
	{
		while(running)
		{
			
		}
	}

}

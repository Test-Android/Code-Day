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
	private final String NAME = "Gray Space ";
	BufferedImage backBuffer;
	Graphics g;
	Player player;
	grid grid;
	int playerX, playerY;
	
	public Game()
	{
		this.setTitle(NAME);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		this.setVisible(true);
		this.setResizable(false);
		this.setBounds(0,0,GraySpaceMain.WIDTH + getInsets().right,GraySpaceMain.HEIGHT + getInsets().bottom);
		player = new Player();
		backBuffer = new BufferedImage(640 + getInsets().right,480 + getInsets().bottom,BufferedImage.TYPE_INT_RGB);
		grid = new grid((GraySpaceMain.WIDTH / 16), (GraySpaceMain.HEIGHT / 16),0,0, getInsets().left, getInsets().top);
		GraySpaceMain.bindKeys(this,player);
		playerX = 1;
		playerY = 0;
		
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
		long lastTime = System.nanoTime();
		long timer  = System.nanoTime();
		final double nanoSeconds = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta+=(now - lastTime) / nanoSeconds;
			lastTime = now;
			while(delta >= 1)
			{
				update();
				updates++;
				delta--;
			}
			render();
			
			frames++;
			if(System.currentTimeMillis() - timer > 1000)
			{
				timer += 1000;
				System.out.println("Updates: " + updates + ", Frames: " + frames);
				setTitle(NAME + " | " + updates + " updates, " + frames + ", FPS");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public void update()
	{
		if(playerX + 1 < 640/16)
			playerX++;
		else
			playerX = 1;
	}
	
	public void render()
	{
		Graphics2D g = (Graphics2D)getGraphics();
        Graphics2D bbg = (Graphics2D)backBuffer.getGraphics();
        
//        bbg.setColor(Color.WHITE);
        /*bbg.fillRect(0, 0, GraySpaceMain.WIDTH, GraySpaceMain.HEIGHT);  
        bbg.setColor(Color.black);
        bbg.fillRect(x, y, 32, 32);*/

        grid.makenewcolumn();
        grid.drawgrid(bbg);
        grid.setPositionNumAndDraw(bbg, 1, 1, 1);
//        grid.drawgrid(bbg);
        grid.setPositionNumAndDraw(bbg, playerX, playerY, 2);
        grid.setPositionNumAndDraw(bbg, playerX - 1, playerY, 0);
        for(int x = 0; x < 640/16; x++)
        {
        	for(int y = 0; y < 480/16; y++)
        	{
        		if(grid.getPositionNum(x, y) == 0)
        		{
        			bbg.setColor(Color.GRAY);
        			bbg.fillRect(getInsets().left + (x *16), getInsets().top + (y*16),16,16);
        		}
        		else if(grid.getPositionNum(x, y) == 2)
        		{
        			bbg.setColor(Color.WHITE);
        			bbg.fillRect(getInsets().left + (x *16), getInsets().top + (y*16),16,16);
        		}
        	}
        }
        g.drawImage(backBuffer, 0, 0, this); 
	}
}

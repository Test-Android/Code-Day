
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

public class GraySpaceMain extends JFrame
{
	public static final int WIDTH = 640;
	public static final int HEIGHT = 480;
	
	public void bindKeys(JFrame jFrame, Player p)
	{
		JRootPane j = jFrame.getRootPane();
		j.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("W"), "pressedUP");
		j.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released W"), "releasedUP");
		j.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("A"), "pressedLEFT");
		j.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released A"), "releasedLEFT");
		j.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("D"), "pressedRIGHT");
		j.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released D"), "releasedRIGHT");

		j.getActionMap().put("pressedUP", new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		j.getActionMap().put("releasedUP", new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			}	
		});
				j.getActionMap().put("pressedLEFT", new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		j.getActionMap().put("releasedLEFT", new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			}	
		});
		
		j.getActionMap().put("pressedRIGHT", new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			}
		});
		j.getActionMap().put("releasedRIGHT", new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
			}	
		});
	}
	public void update()
	{
	
	}
	public static void main(String args[])
	{
		Game game = new Game();
		game.start();
	}
}

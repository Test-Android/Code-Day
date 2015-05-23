

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

public class GraySpaceMain extends JFrame
{
	private void initalize()
	{
		this.setTitle("Gray Space");
		this.setBounds(0,0,640,480);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		bindKeys();
		
		Game game = new Game(this);
		game.start();
	}
	private void bindKeys()
	{
		JRootPane j = getRootPane();
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
		GraySpaceMain main = new GraySpaceMain();
		main.initalize();
	}
}

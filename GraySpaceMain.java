import javax.swing.JFrame;

//made at coday!!
public class GraySpaceMain extends JFrame
{
	private void initalize()
	{
		this.setTitle("Gray Space");
		this.setBounds(0,0,500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String args[])
	{
		GraySpaceMain main = new GraySpaceMain();
		main.initalize();
	}
}

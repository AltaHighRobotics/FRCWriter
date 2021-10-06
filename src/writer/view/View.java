package writer.view;

import writer.controller.*;
import javax.swing.JPanel;
import java.awt.Color;

public class View extends JPanel
{
	private Controller controller;

	private View(Controller controller)
	{
		super();
		this.controller = controller;
		
		setupPanel();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.GRAY);
		this.setSize(800, 600);
	}
}

package writer.view;

import writer.controller.*;
import javax.swing.JFrame;

public class Frame extends JFrame
{
	private Controller controller;
	private Panel panel;
	
	public Frame(Controller controller)
	{
		super();
		this.controller = controller;
		this.panel = new Panel(controller);
		
		setupFrame();
	}
	
	private void setupFrame()
	{
		this.setContentPane(panel);
		this.setSize(700,300);
		this.setTitle("FRC Writer");
		this.setResizable(true);
		this.setVisible(true);
	}
}

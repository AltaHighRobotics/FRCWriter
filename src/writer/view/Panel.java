package writer.view;

import writer.controller.*;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.*;
import java.awt.Color;

public class Panel extends JPanel
{
	private Controller controller;
	private JButton runButton;

	Panel(Controller controller)
	{
		super();
		this.controller = controller;
		this.runButton = new JButton("Generate Code");
		
		setupPanel();
		setUpListeners();
	}
	
	private void setupPanel()
	{
		this.setBackground(Color.DARK_GRAY);
		this.setSize(800, 600);
		
		this.add(runButton);
	}
	
	private void setUpListeners()
	{
		runButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click) 
			{
				controller.main();
			}
		});
	}
}

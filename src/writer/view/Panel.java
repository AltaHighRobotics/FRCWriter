package writer.view;

import writer.controller.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class Panel extends JPanel
{
	private Controller controller;
	private JButton runButton;
	private JComboBox <String> objectType; 
	private String [] objectList = {"Can Motor","Rio Motor", "Pneumatic"};  
	private SpinnerModel objectNumber = new SpinnerNumberModel (1,1,15,1);
	private JTextField objectName;
	
	Panel(Controller controller)
	{
		super();
		
		this.controller = controller;
		this.runButton = new JButton("Generate Code");
		this.objectType = new JComboBox<String>(objectList);
		this.objectName = new JTextField ("Function", 10);
		
		setupPanel();
		setUpListeners();
	}
	
	private void setupPanel()
	{
		JSpinner spinner = new JSpinner(objectNumber);
		
		this.setBackground(Color.DARK_GRAY);
		this.setSize(800, 600);
		this.add(objectType);
		this.add(spinner);
		this.add(objectName);
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

package writer.controller;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import writer.model.FRCWriter;

public class Controller 
{
	private FRCWriter mywrite;
	private ArrayList<String> dataList;
	private String objectName;
	private String javaSub;
	private String javaCmd;
	
	public Controller()
	{
		this.mywrite = new FRCWriter();
		this.objectName = "Jeff";
		this.javaSub = objectName + "Sub.java";
		this.javaCmd = objectName + "Command.java";
	}
	
	public void main()
	{
		getFRCData();
	}
	
	public void getFRCData()
	{	
		dataList = mywrite.processText("can", objectName, 2);
		//writeFRCFiles();
	}
	
	public void writeFRCFiles()
	{
		try
		{
			File subFile = new File(javaSub);
			if(subFile.createNewFile())
			{
				System.out.println("Sub File Created");
			}
			else
			{
				System.out.println("Sub File already exists, quitting program");
			}
		}
		catch (IOException e)
		{
			System.out.println("ERROR IOEXCEPTION");
			e.printStackTrace();
		}
		
		 try {
		      FileWriter subWriter = new FileWriter(javaSub);
		      subWriter.write(dataList.get(0));
		      subWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		 
		try
		{
			File cmdFile = new File(javaCmd);
			if(cmdFile.createNewFile())
			{
				System.out.println("Command File Created");
			}
			else
			{
				System.out.println("Command File already exists, quitting program");
			}
		}
		catch (IOException e)
		{
			System.out.println("ERROR IOEXCEPTION");
			e.printStackTrace();
		}
		
		try {
		      FileWriter cmdWriter = new FileWriter(javaCmd);
		      cmdWriter.write(dataList.get(1));
		      cmdWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}
}
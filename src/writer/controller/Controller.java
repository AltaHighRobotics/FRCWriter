package writer.controller;

import java.util.*;
import java.io.File;
import java.io.IOException;
import writer.model.FRCWriter;

public class Controller 
{
	private FRCWriter mywrite;
	private ArrayList<String> dataList;
	
	public Controller()
	{
		this.mywrite = new FRCWriter();
	}
	
	public void main()
	{
		dataList = mywrite.canMotor(1, "jeff");
		System.out.println(dataList);
		
		
//		try
//		{
//			File fileWriter = new File("MotorSub.java");
//			if(fileWriter.createNewFile())
//			{
//				System.out.println("File Created");
//			}
//			else
//			{
//				System.out.println("File already exists, overwriting new file");
//			}
//		}
//		catch (IOException e)
//		{
//			System.out.println("ERROR IOEXCEPTION");
//			e.printStackTrace();
//		}
	}
}
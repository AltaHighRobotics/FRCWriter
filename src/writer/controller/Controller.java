package writer.controller;

import java.util.*;
import java.io.File;
import java.io.IOException;

public class Controller 
{
	public void main()
	{
		try
		{
			File fileWriter = new File("MotorSub.java");
			if(fileWriter.createNewFile())
			{
				System.out.println("File Created");
			}
			else
			{
				System.out.println("File already exists, overwritting new file");
			}
		}
		catch (IOException e)
		{
			System.out.println("ERROR IOEXCEPTION");
			e.printStackTrace();
		}
	}
}
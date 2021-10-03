package writer.model;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class FRCWriter 
{
	
	public FRCWriter()
	{
		
	}
	
	public String placeholder(String objectType, String objectName, int objectNumber)
	{
		String data = "";
		
		if (objectType.toLowerCase().equals("can"))
		{
			canMotor(objectNumber, objectName);
		}
		
		return data;
	}
	

	public ArrayList <String> canMotor(int canNumber, String canName)
	{
		String subName = canName + "Sub";
		
		ArrayList <String> canMotorData = new ArrayList <String>();
		String canSub = "// Copyright (c) FIRST and other WPILib contributors. \n";
		canSub += "// Open Source Software; you can modify and/or share it under the terms of \n";
		canSub += "// the WPILib BSD license file in the root directory of this project. \n";
		canSub += "\n";
		canSub += "import edu.wpi.first.wpilibj.Victor; \n";
		canSub += "import edu.wpi.first.wpilibj2.command.SubsystemBase; \n";
		canSub += "import frc.robot.Constants; \n";
		canSub += "import com.ctre.phoenix.motorcontrol.*; \n";
		canSub += "\n";
		canSub += "public class " + subName + "Sub extends SubsystemBase { \n";
		canSub += "    /**  Creates a new " + subName + ". */ \n";
		for (int i = 0; i < canNumber; i++) 
		{
			canSub += "    private TalonFX " + canName + i + "\n";  
		}
				
		canMotorData.add(canSub);
		
		return canMotorData;
	}
	
	public String rioMotor()
	{
		String rioMotorData = "";
		
		return rioMotorData;
	}
	
	public String pneumatics()
	{
		String pneumaticsData = "";
		
		return pneumaticsData;
	}
	
	public String txtToString(String condition)
	{
		String txtToString = "";
	    try 
	    {
	    	txtToString = new String(Files.readAllBytes(Paths.get(condition)));
	    } catch (IOException exception) 
	    {
	      exception.printStackTrace();
	    }

		return txtToString;
	}
}

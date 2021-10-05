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
		String canSub = "";
		canSub += txtToString("canSub1.txt");
		canSub += "\n";
		canSub += "public class " + subName + " extends SubsystemBase { \n";
		canSub += "    /**  Creates a new " + subName + ". */ \n";
		for (int i = 0; i < canNumber; i++) 
		{
			canSub += "    private TalonFX " + canName + i + ";\n";  
		}
		canSub += "    public " + subName + "() { \n";
		for (int i = 0, i < canNumber; i++)
		{
			canSub += "        TalonFX " + canName + " = new TalonFX(Constants." + canName.toUpperCase() + "); \n";
		}
		for (int i = 0, i < canNumber; i++)
		{
			canSub += "        " + canName + ".setNeutralMode(NeutralMode.Coast); \n";
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

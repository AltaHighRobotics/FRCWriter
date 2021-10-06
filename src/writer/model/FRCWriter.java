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
		String canCmdOn = "";
		String canCmdOff = "";
		
		canSub += txtToString("canSub1.txt");
		canSub += "\n";
		canSub += "\n";
		canSub += "public class " + subName + " extends SubsystemBase { \n";
		canSub += "    /**  Creates a new " + subName + ". */ \n";
		for (int i = 0; i < canNumber; i++) 
		{
			canSub += "    private TalonFX " + canName + i + ";\n";  
		}
		canSub += "\n";
		canSub += "    public " + subName + "() { \n";
		for (int i = 0; i < canNumber; i++)
		{
			canSub += "        TalonFX " + canName + i + " = new TalonFX(Constants." + canName.toUpperCase() + i + "); \n";
		}
		for (int i = 0; i < canNumber; i++)
		{
			canSub += "        " + canName + i + ".setNeutralMode(NeutralMode.Coast); \n";
		}
		canSub += "    } \n";
		canSub += "\n";
		canSub += txtToString("canSub2.txt");
		canSub += "\n";
		canSub += "\n";
		canSub += "    public void " + canName + "On() { \n";
		for (int i = 0; i < canNumber; i++)
		{
			canSub += "        " + canName + i + ".set(ControlMode.PercentOutput, Constants." + canName.toUpperCase() + "_ON_SPEED); \n";
		}
		canSub += "    } \n";
		canSub += "\n";
		canSub += "    public void " + canName + "Off() { \n";
		for (int i = 0; i < canNumber; i++)
		{
			canSub += "        " + canName + i + ".set(ControlMode.PercentOutput, Constants." + canName.toUpperCase() + "_OFF_SPEED); \n";
		}
		canSub += "    } \n";
		canSub +="}";
		
		canMotorData.add(canSub);
		
		
		
		canCmdOn += txtToString("canCmd1.txt");
		canCmdOn += "\n";
		canCmdOn += "import frc.robot.subsystems." + canName + "Sub; \n" ;
		canCmdOn += canName + "OnCommand extends CommandBase { \n";
		canCmdOn += "  /** Creates a new " + canName + "OnCommand. */ \n";
		
		canMotorData.add(canCmdOn);
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

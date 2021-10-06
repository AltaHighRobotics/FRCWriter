package writer.model;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class FRCWriter 
{
	
	public FRCWriter()
	{
		
	}
	
	public ArrayList <String> processText(String objectType, String objectName, int objectNumber)
	{
		ArrayList <String> data = new ArrayList <String>();
		
		if (objectType.toLowerCase().equals("can"))
		{
			data = canMotor(objectNumber, objectName);
		}
		
		return data;
	}
	

	private ArrayList <String> canMotor(int canNumber, String canName)
	{
		String subName = canName + "Sub";
		
		ArrayList <String> canMotorData = new ArrayList <String>();
		String canSub = "";
		String canCmd = "";
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
		
		
		
		canCmd += txtToString("canCmd1.txt");
		canCmd += "\n";
		canCmd += "import frc.robot.subsystems." + canName + "Sub; \n" ;
		canCmd += "\n";
		canCmd += "public class "+canName + "OnCommand extends CommandBase { \n";
		canCmd += "  /** Creates a new " + canName + "OnCommand. */ \n";
		canCmd += "  private final " + canName + "Sub m_" + canName.toLowerCase() + "Sub; \n";
		canCmd += "\n";
		canCmd += "  public " + canName + "OnCommand(" +canName + "Sub " + canName.toLowerCase() + "Sub) { \n";
		canCmd += "    m_" + canName.toLowerCase() + "Sub = " + canName.toLowerCase() + "Sub; \n";
		canCmd += "    addRequirements(m_" + canName.toLowerCase() + "Sub); \n";
		canCmd += "  } \n";
		canCmd += "\n";
		
		canCmd += txtToString("canCmd2.txt");
		canCmd += "\n";
		canCmd += "    m_" + canName.toLowerCase() + "Sub." + canName + "On(); \n";
		canCmd += "  } \n";
		canCmd += "\n";
		canCmd += "  // Called once the command ends or is interrupted. \n";
		canCmd += "  @Override \n";
		canCmd += "  public void end(boolean interrupted) { \n";
		canCmd += "    m_" + canName.toLowerCase() + "Sub." + canName + "Off(); \n";
		canCmd += "  } \n";
		canCmd += "\n";
		canCmd += txtToString("canCmd3.txt");
		
		canMotorData.add(canCmd);
		
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
	
	private String txtToString(String condition)
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

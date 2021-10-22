package writer.model;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;

/**
 * Used to make robot code automatically for FRC Java
 * @author Byrnes Braden
 *
 */
public class FRCWriter 
{

    public FRCWriter() 
    {

    }

    /**
     * Uses given information to decide what method to run, and how it will run 
     * @param objectType The type of object on the robot, either a can motor, a rio motor or a pneumatic
     * @param objectName The name of the object that specifies its function
     * @param objectNumber The number of objects that is on the robot
     * @return list containing data that will be used to write future java files
     */
    public ArrayList < String > processText(String objectType, String objectName, int objectNumber) 
    {
        ArrayList < String > data = new ArrayList < String > ();

        //checks to see if a can motor is being used
        if (objectType.equals("Can Motor")) 
        {
            data = canMotor(objectNumber, objectName);
        }
        if (objectType.equals("Rio Motor")) 
        {
            data = rioMotor(objectNumber, objectName);
        }
        if (objectType.equals("Pneumatic")) 
        {
            data = pneumatics(objectNumber, objectName);
        }

        return data;
    }

    /**
     * Uses given information to create a Subsystem and Command for a can file, each stored in String canSub and canCmd respectively
     * It then stores those 2 Strings in an ArrayList, canSub at index 0 and canCmd at index 1
     * @param canNumber The number of can motors
     * @param canName The name of the can motor
     * @return list containing data that will be used to write future java files
     */
    private ArrayList < String > canMotor(int canNumber, String canName) 
    {
        String subName = canName + "Sub";

        ArrayList < String > canMotorData = new ArrayList < String > ();
        String canSub = "";
        String canCmd = "";

        //adding new text to canSub based parameters
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
        canSub += "}";

        //adds the string to a list at index 0
        canMotorData.add(canSub);

        //adding new text to canCmd based parameters

        canCmd = makeCommand(canName);
        //adding the string to a list at index 1
        canMotorData.add(canCmd);

        return canMotorData;
    }

    public ArrayList < String > rioMotor(int rioNumber, String rioName) 
    {
        ArrayList < String > rioMotorData = new ArrayList < String > ();

        String subName = rioName + "Sub";
        String rioSub = "";
        String rioCmd = "";

        rioSub += txtToString("canSub1.txt");
        rioSub += "\n";
        rioSub += "\n";
        rioSub += "public class " + subName + " extends SubsystemBase { \n";
        rioSub += "    /**  Creates a new " + subName + ". */ \n";

        for (int i = 0; i < rioNumber; i++)
        {
            rioSub += "    private Victor " + rioName + i + ";\n";
        }

        rioSub += "\n";
        rioSub += "    public " + subName + "() { \n";

        for (int i = 0; i < rioNumber; i++) 
        {
            rioSub += "        Victor " + rioName + i + " = new Victor(Constants." + rioName.toUpperCase() + i + "); \n";
        }

        rioSub += "    } \n";
        rioSub += "\n";
        rioSub += txtToString("canSub2.txt");
        rioSub += "\n";
        rioSub += "\n";
        rioSub += "    public void " + rioName + "On() { \n";

        for (int i = 0; i < rioNumber; i++) 
        {
            rioSub += "        " + rioName + i + ".set(Constants." + rioName.toUpperCase() + "_ON_SPEED); \n";
        }

        rioSub += "    } \n";
        rioSub += "\n";
        rioSub += "    public void " + rioName + "Off() { \n";

        for (int i = 0; i < rioNumber; i++) 
        {
            rioSub += "        " + rioName + i + ".set(Constants." + rioName.toUpperCase() + "_OFF_SPEED); \n";
        }

        rioSub += "    } \n";
        rioSub += "}";

        rioMotorData.add(rioSub);

        rioCmd = makeCommand(rioName);

        rioMotorData.add(rioCmd);

        return rioMotorData;
    }

    public ArrayList < String > pneumatics(int pNumber, String pName) 
    {
        ArrayList < String > pneumaticsData = new ArrayList < String > ();
        String subName = pName + "Sub";
        String pSub = "";
        String pCmd = "";

        pSub += txtToString("canSub1.txt");
        pSub += "\n";
        pSub += "\n";
        pSub += "public class " + subName + " extends SubsystemBase { \n";
        pSub += "    /**  Creates a new " + subName + ". */ \n";

        for (int i = 0; i < pNumber; i++)
        {
            pSub += "    private Final Solenoid " + pName + i + ";\n";
        }

        pSub += "\n";
        pSub += "    public " + subName + "() { \n";

        for (int i = 0; i < pNumber; i++)
        {
            pSub += "        " + pName + i + " = new Solenoid(Constants." + pName.toUpperCase() + i + "); \n";
        }

        pSub += "    } \n";
        pSub += "\n";
        pSub += txtToString("canSub2.txt");
        pSub += "\n";
        pSub += "\n";
        pSub += "    public void " + pName + "On() { \n";

        for (int i = 0; i < pNumber; i++) 
        {
            pSub += "        " + pName + i + ".set(true); \n";
        }

        pSub += "    } \n";
        pSub += "\n";
        pSub += "    public void " + pName + "Off() { \n";

        for (int i = 0; i < pNumber; i++) 
        {
            pSub += "        " + pName + i + ".set(false); \n";
        }

        pSub += "    } \n";
        pSub += "}";

        pneumaticsData.add(pSub);

        pCmd = makeCommand(pName);

        pneumaticsData.add(pCmd);
        return pneumaticsData;
    }
    
      public String makeCommand(String cmdName) 
    {
        String cmdString = "";
        cmdString += txtToString("canCmd1.txt");
        cmdString += "\n";
        cmdString += "import frc.robot.subsystems." + cmdName + "Sub; \n";
        cmdString += "\n";
        cmdString += "public class " + cmdName + "OnCommand extends CommandBase { \n";
        cmdString += "  /** Creates a new " + cmdName + "OnCommand. */ \n";
        cmdString += "  private final " + cmdName + "Sub m_" + cmdName.toLowerCase() + "Sub; \n";
        cmdString += "\n";
        cmdString += "  public " + cmdName + "OnCommand(" + cmdName + "Sub " + cmdName.toLowerCase() + "Sub) { \n";
        cmdString += "    m_" + cmdName.toLowerCase() + "Sub = " + cmdName.toLowerCase() + "Sub; \n";
        cmdString += "    addRequirements(m_" + cmdName.toLowerCase() + "Sub); \n";
        cmdString += "  } \n";
        cmdString += "\n";
        cmdString += txtToString("canCmd2.txt");
        cmdString += "\n";
        cmdString += "    m_" + cmdName.toLowerCase() + "Sub." + cmdName + "On(); \n";
        cmdString += "  } \n";
        cmdString += "\n";
        cmdString += "  // Called once the command ends or is interrupted. \n";
        cmdString += "  @Override \n";
        cmdString += "  public void end(boolean interrupted) { \n";
        cmdString += "    m_" + cmdName.toLowerCase() + "Sub." + cmdName + "Off(); \n";
        cmdString += "  } \n";
        cmdString += "\n";
        cmdString += txtToString("canCmd3.txt");

        return cmdString;
    }

      public String controltxt(String name)
      {
    	  String control = "";
    	  String subName = name + "Sub";
    	  String cmdName = name + "Command";
    	  
    	  control += txtToString("control1.txt");
    	  control += "  private final " + subName + " m_" + subName.toLowerCase() + " = new " + subName + "();";
    	  control += "  private final " + cmdName + "m_";
    	  
    	  return control;
      }
    		  
    /**
     * takes a .txt file and turns it into a string
     * @param fileName The name of the file the method will be reading
     * @return A string containing all the text from the file including indents and new lines
     */
    private String txtToString(String fileName)
    {
        String txtToString = "";
        try 
        {
            txtToString = new String(Files.readAllBytes(Paths.get(fileName)));
        } 
        catch (IOException exception)
        {
            exception.printStackTrace();
        }

        return txtToString;
    }
}

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
//        canCmd += txtToString("canCmd1.txt");
//        canCmd += "\n";
//        canCmd += "import frc.robot.subsystems." + canName + "Sub; \n";
//        canCmd += "\n";
//        canCmd += "public class " + canName + "OnCommand extends CommandBase { \n";
//        canCmd += "  /** Creates a new " + canName + "OnCommand. */ \n";
//        canCmd += "  private final " + canName + "Sub m_" + canName.toLowerCase() + "Sub; \n";
//        canCmd += "\n";
//        canCmd += "  public " + canName + "OnCommand(" + canName + "Sub " + canName.toLowerCase() + "Sub) { \n";
//        canCmd += "    m_" + canName.toLowerCase() + "Sub = " + canName.toLowerCase() + "Sub; \n";
//        canCmd += "    addRequirements(m_" + canName.toLowerCase() + "Sub); \n";
//        canCmd += "  } \n";
//        canCmd += "\n";
//        canCmd += txtToString("canCmd2.txt");
//        canCmd += "\n";
//        canCmd += "    m_" + canName.toLowerCase() + "Sub." + canName + "On(); \n";
//        canCmd += "  } \n";
//        canCmd += "\n";
//        canCmd += "  // Called once the command ends or is interrupted. \n";
//        canCmd += "  @Override \n";
//        canCmd += "  public void end(boolean interrupted) { \n";
//        canCmd += "    m_" + canName.toLowerCase() + "Sub." + canName + "Off(); \n";
//        canCmd += "  } \n";
//        canCmd += "\n";
//        canCmd += txtToString("canCmd3.txt");

        //adding the string to a list at index 1
        canMotorData.add(canCmd);

        return canMotorData;
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
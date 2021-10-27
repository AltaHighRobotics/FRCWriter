package writer.controller;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import writer.model.FRCWriter;
import writer.view.*;

public class Controller 
{
    private FRCWriter mywrite;
    private ArrayList < String > dataList;
    public String objectName;
    public String javaSub;
    public String javaCmd;
    public String javaControl; 
    private Frame window;
    private Popup popup;

    public Controller() 
    {
    	this.window = new Frame(this);
        this.mywrite = new FRCWriter();
        this.javaSub = objectName + "Sub.java";
        this.javaCmd = objectName + "Command.java";
        this.javaControl = objectName + "Control.txt";
        this.popup = new Popup();
    }

    public void main() 
    {
    	
    }

    /**
     * gets the necessary data for the java files from process text
     */
    public void getFRCData(String type, String name, int number) 
    {
        dataList = mywrite.processText(type, name, number);
        objectName = name;
        javaSub = objectName + "Sub.java";
        javaCmd = objectName + "Command.java";
        javaControl = objectName + "Control.txt";
        if (name.indexOf(" ") > -1)
        {
        	popup.displayMessage("Error! Please remove spaces from name.");
        }
        else
        {
        	writeFRCFiles();	
        }
    }

    /**
     * writes the data gotten from getFRCData() into java files
     */
    public void writeFRCFiles() 
    {
    	String pop1 = "Warning! error occured in subsystem file!";
    	String pop2 = "";
    	String pop3 = "";
        //creates subsystem java file
        try 
        {
            File subFile = new File(javaSub);
            if (subFile.createNewFile()) 
            {
            	//popup.displayMessage("Sub File Created");
            } 
            else 
            {
            	//popup.displayMessage("Sub File already exists, overwriting");
            }
        } 
        catch (IOException e) 
        {
        	popup.displayMessage("ERROR IOEXCEPTION");
            e.printStackTrace();
        }

        //writes the necessary data to subsystem java file
        try 
        {
            FileWriter subWriter = new FileWriter(javaSub);
            subWriter.write(dataList.get(0));
            subWriter.close();
            pop1 = "Subsystem successfully created.";
        } 
        catch (IOException e) 
        {
        	popup.displayMessage("ERROR IOEXCEPTION");
            e.printStackTrace();
        }

        //creates command java file
        try 
        {
            File cmdFile = new File(javaCmd);
            if (cmdFile.createNewFile()) 
            {
            	//popup.displayMessage("Command File Created");
            } 
            else 
            {
            	//popup.displayMessage("Command File already exists, quitting program");
            }
        } 
        catch (IOException e) 
        {
        	popup.displayMessage("ERROR IOEXCEPTION");
            e.printStackTrace();
        }

        //writes the necessary data to command java file
        try 
        {
            FileWriter cmdWriter = new FileWriter(javaCmd);
            cmdWriter.write(dataList.get(1));
            cmdWriter.close();
            pop2 = "Command successfully created.";
        } 
        catch (IOException e) 
        {
            popup.displayMessage("An error occurred.");
            e.printStackTrace();
        }
        try 
        {
            File controlFile = new File(javaControl);
            if (controlFile.createNewFile()) 
            {
            	//popup.displayMessage("Sub File Created");
            } 
            else 
            {
            	//popup.displayMessage("Sub File already exists, quitting program");
            }
        } 
        catch (IOException e) 
        {
            System.out.println("ERROR IOEXCEPTION");
            e.printStackTrace();
        }
        try 
        {
            FileWriter controlWriter = new FileWriter(javaControl);
            controlWriter.write(dataList.get(2));
            controlWriter.close();
            pop3 = "Control successfully created";
        } 
        catch (IOException e) 
        {
        	popup.displayMessage("An error occurred.");
            e.printStackTrace();
        }
        
        popup.displayMessage(pop1 + "\n" + pop2 + "\n" + pop3);

    }
}
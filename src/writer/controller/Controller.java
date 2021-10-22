package writer.controller;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import writer.model.FRCWriter;
import writer.view.Frame;
import writer.view.Panel;

public class Controller 
{
    private FRCWriter mywrite;
    private ArrayList < String > dataList;
    public String objectName;
    public String javaSub;
    public String javaCmd;
    public String javaControl; 
    private Frame window;

    public Controller() 
    {
    	this.window = new Frame(this);
        this.mywrite = new FRCWriter();
        this.javaSub = objectName + "Sub.java";
        this.javaCmd = objectName + "Command.java";
        this.javaControl = objectName + "Control.txt";
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
        writeFRCFiles();
    }

    /**
     * writes the data gotten from getFRCData() into java files
     */
    public void writeFRCFiles() 
    {
        //creates subsystem java file
        try 
        {
            File subFile = new File(javaSub);
            if (subFile.createNewFile()) 
            {
                //System.out.println("Sub File Created");
            } 
            else 
            {
               // System.out.println("Sub File already exists, quitting program");
            }
        } 
        catch (IOException e) 
        {
            System.out.println("ERROR IOEXCEPTION");
            e.printStackTrace();
        }

        //writes the necessary data to subsystem java file
        try 
        {
            FileWriter subWriter = new FileWriter(javaSub);
            subWriter.write(dataList.get(0));
            subWriter.close();
           // System.out.println("Successfully wrote to the file.");
        } 
        catch (IOException e) 
        {
           // System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //creates command java file
        try 
        {
            File cmdFile = new File(javaCmd);
            if (cmdFile.createNewFile()) 
            {
               // System.out.println("Command File Created");
            } 
            else 
            {
               // System.out.println("Command File already exists, quitting program");
            }
        } 
        catch (IOException e) 
        {
            //System.out.println("ERROR IOEXCEPTION");
            e.printStackTrace();
        }

        //writes the necessary data to command java file
        try 
        {
            FileWriter cmdWriter = new FileWriter(javaCmd);
            cmdWriter.write(dataList.get(1));
            cmdWriter.close();
           //System.out.println("Successfully wrote to the file.");
        } 
        catch (IOException e) 
        {
            //System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try 
        {
            File controlFile = new File(javaControl);
            if (controlFile.createNewFile()) 
            {
                //System.out.println("Sub File Created");
            } 
            else 
            {
               // System.out.println("Sub File already exists, quitting program");
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
           //System.out.println("Successfully wrote to the file.");
        } 
        catch (IOException e) 
        {
            //System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
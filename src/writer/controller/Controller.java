package writer.controller;

import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import writer.model.FRCWriter;

public class Controller {
    private FRCWriter mywrite;
    private ArrayList < String > dataList;
    private String objectName;
    private String javaSub;
    private String javaCmd;

    public Controller() 
    {
        this.mywrite = new FRCWriter();
        this.objectName = "Jeff";
        this.javaSub = objectName + "Sub.java";
        this.javaCmd = objectName + "Command.java";
    }

    public void main() 
    {
        getFRCData();
    }

    /**
     * gets the necessary data for the java files from process text
     */
    public void getFRCData() 
    {
        dataList = mywrite.processText("can", objectName, 2);
        //writeFRCFiles();
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
                System.out.println("Sub File Created");
            } 
            else 
            {
                System.out.println("Sub File already exists, quitting program");
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
            System.out.println("Successfully wrote to the file.");
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //creates command java file
        try 
        {
            File cmdFile = new File(javaCmd);
            if (cmdFile.createNewFile()) 
            {
                System.out.println("Command File Created");
            } else {
                System.out.println("Command File already exists, quitting program");
            }
        } 
        catch (IOException e) 
        {
            System.out.println("ERROR IOEXCEPTION");
            e.printStackTrace();
        }

        //writes the necessary data to command java file
        try 
        {
            FileWriter cmdWriter = new FileWriter(javaCmd);
            cmdWriter.write(dataList.get(1));
            cmdWriter.close();
            System.out.println("Successfully wrote to the file.");
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
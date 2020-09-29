package project1package;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class ContactTracer {
	
	//Taken from roster example with Array exchanged for HashMap named covidmap
    private int size;
    private static final int DEFAULT_SIZE = 10;
    //Will later implement a Hashmap named "covidmap" that
    //keeps track of the name of people with covid and uses their
    //unique covid id (double) as the key
    private HashMap <Integer,String> covidmap;
    private String className;
    private String fileName;
    private Scanner scan;
    
    public ContactTracer() {

        size = 0;
        HashMap <Integer,String> covidmap = new HashMap <Integer,String>();
        className = "a class";
        fileName = null;
        scan = new Scanner(System.in);
    }
    public ContactTracer(String cn, String fn) {
        this();
        className = cn;
        fileName = fn;
        readFile();
    }    
    
    public void addInfected(Infected s) {
    	
    	//Input names of people infected with covid 
    	
        covidmap.put(1,"Jack");
        covidmap.put(2,"Sam");
        covidmap.put(3,"Josh");
        covidmap.put(4,"Austin");
        covidmap.put(5,"James");
        
        
        System.out.println(covidmap.containsValue("Jack"));
        System.out.println(covidmap.keySet());
    }
        
    public void addPersonFromKeyboard () {

        // method that prompts the user to enter either a student or instructor

        // then the user inputs the appropriate information for that person type

        // finally adds the new person to the array

        // complete for homework #2
        String type = scan.nextLine();
        String name = scan.nextLine();
        String id = scan.nextLine();
        while (type.equals("infected")) {
            String casenumberString = scan.nextLine();
            addInfected(new Infected(name,id,Double.parseDouble(casenumberString)));
        }
        
    }
    
    public void removePerson (String id ) {
        
    	int deleteid;
    	deleteid = 3;
       covidmap.remove(0+deleteid);
    }

    
    private void readFile () {
        BufferedReader lineReader = null;
        try {
            FileReader fr = new FileReader(fileName);
            lineReader = new BufferedReader(fr);
            String line = null;
            while ((line = lineReader.readLine())!=null) {
                String name = lineReader.readLine();
                String id = lineReader.readLine();
                if (line.equals("infected")) {
                    String casenumberString = lineReader.readLine();
                    addInfected(new Infected(name,id,Double.parseDouble(casenumberString)));
                }
       
                else {
                    System.err.println("error: unnknown person type");
                }            }
        } catch (Exception e) {
            System.err.println("there was a problem with the file reader, try different read type.");
            try {
                lineReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName.substring(1))));
                String line = null;
                while ((line = lineReader.readLine())!=null) {
                    String name = lineReader.readLine();
                    String id = lineReader.readLine();
                    if (line.equals("infected")) {
                        String casenumberString = lineReader.readLine();
                        addInfected(new Infected(name,id,Double.parseDouble(casenumberString)));
                    }
                    
                    else {
                        System.err.println("error: unnknown person type");
                    }                }
            } catch (Exception e2) {
                System.err.println("there was a problem with the file reader, try again.  either no such file or format error");
            } finally {
                if (lineReader != null)
                    try {
                        lineReader.close();
                    } catch (IOException e2) {
                        System.err.println("could not close BufferedReader");
                    }
            }            
        } finally {
            if (lineReader != null)
                try {
                    lineReader.close();
                } catch (IOException e) {
                    System.err.println("could not close BufferedReader");
                }
        }
    } // end of readFile method    
    
    public void writeFile () {
        // overloaded method: this calls doWrite with file used to read data
        // use this for saving data between runs
        doWrite(fileName);
    } // end of writeFile method

    public void writeFile(String altFileName) {
        // overloaded method: this calls doWrite with different file name
        // use this for testing write
        doWrite(altFileName);        
    }// end of writeFile method
    
  
package ec.edu.espe.schweitzer_revision.controller;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author David Lopez
 */
public class FileManager {
    
    public void writeFile(String fileName,String dataLine){
        File customerData=new File(fileName);
       
        try{
        FileWriter writer = new FileWriter(customerData);
        BufferedWriter buffWriter = new BufferedWriter(writer);
        PrintWriter printWriter = new PrintWriter(buffWriter);
        
        printWriter.print(dataLine);
        printWriter.close();
        buffWriter.close();
        
        }catch(IOException e){};
    }
    
    
    public String getConstantId(String filePath){
        Scanner in = null;
        try {
            in = new Scanner(new FileReader(filePath));
        } catch (FileNotFoundException ex) {
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(in.next());
        in.close();
        String outString = sb.toString();
        
        return outString;
    }
    
    
    public String randomString(){
        
        int n = 6; //random String Length
        
        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
        } 
        return sb.toString(); 
    }
    
     public String randomStringNumber(){
        
        int n = 3; //random String Length
        
        // chose a Character random from this String 
        String AlphaNumericString = "0123456789"
                                    ; 
  
        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index 
                = (int)(AlphaNumericString.length() 
                        * Math.random()); 
  
            // add Character one by one in end of sb 
            sb.append(AlphaNumericString 
                          .charAt(index)); 
         
        } 
        return sb.toString(); 
    }
    
    
    
    
    public  void appendStrToFile(String fileName,String dataLine) 
    { 
        try {    
            // Open given file in append mode. 
            BufferedWriter out = new BufferedWriter( 
            new FileWriter(fileName, true)); 
            out.newLine();
            out.write(dataLine); 
            out.close(); 
        } 
        catch (IOException e) { 
            System.out.println("exception occoured" + e); 
        } 
    } 
    
    public String parseFile(String fileName,String searchStr) throws FileNotFoundException{  
        String desiredLine=null;
        Scanner scan = new Scanner(new File(fileName));
        while(scan.hasNext()){
            String line = scan.nextLine().toString();
            if(line.contains(searchStr)){
            desiredLine=line;
            }
        }
        return desiredLine;
    }
    
    public void removeLineFromFile(String pathFile, String lineToRemove) {
        
        File inputFile = new File(pathFile);
        File tempFile = new File(inputFile.getAbsolutePath() + ".tmp");
        
        try{
        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            if(null!=currentLine && !currentLine.equalsIgnoreCase(lineToRemove)){
                writer.write(currentLine + System.getProperty("line.separator"));
            }
        }
        writer.close(); 
        reader.close(); 
        }  catch (FileNotFoundException ex) {
            ex.printStackTrace();
          }
          catch (IOException ex) {
            ex.printStackTrace();
          }
        
        boolean delete = inputFile.delete();
        boolean successful = tempFile.renameTo(inputFile);
        
        if(delete==true&&successful==true)
            System.out.println("Se elimino exitosamente");
    }
    
     public static void modifyFile(String filePath, String oldString, String newString)
    {
        File fileToBeModified = new File(filePath);
        String oldContent = "";   
        BufferedReader reader = null;
        FileWriter writer = null;
         
        try
        {
            reader = new BufferedReader(new FileReader(fileToBeModified));
             
            //Reading all the lines of input text file into oldContent
            String line = reader.readLine();
            while (line != null) 
            {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }
            //Replacing oldString with newString in the oldContent  
            String newContent = oldContent.replaceAll(oldString, newString);
            //Rewriting the input text file with newContent
            writer = new FileWriter(fileToBeModified);  
            writer.write(newContent);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                //Closing the resources
                reader.close();
                writer.close();
            } 
            catch (IOException e) 
            {
                e.printStackTrace();
            }
        }
    }
}

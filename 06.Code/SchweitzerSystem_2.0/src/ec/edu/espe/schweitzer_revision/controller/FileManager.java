package ec.edu.espe.schweitzer_revision.controller;

import com.google.gson.Gson;
import ec.edu.espe.schweitzer_revision.model.Technician;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author David Lopez
 */
public class FileManager {
    
    public static void writeFile(String fileName,String dataLine){
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
    
    
    public static String readFile(String pathname) throws IOException {

    File file = new File(pathname);
    StringBuilder fileContents = new StringBuilder((int)file.length());        

    try (Scanner scanner = new Scanner(file)) {
        while(scanner.hasNextLine()) {
            fileContents.append(scanner.nextLine() + System.lineSeparator());
        }
        return fileContents.toString();
    }
}
    
    
    public static String getConstantId(String filePath){
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
    
 
    public static void appendStrToFile(String fileName,String dataLine) 
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
    
    public static String parseFile(String fileName,String searchStr) throws FileNotFoundException{  
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
    
     public static boolean searchFile(String fileName,String searchStr) throws FileNotFoundException{  
        Scanner scan = new Scanner(new File(fileName));
        while(scan.hasNext()){
            String line = scan.nextLine();
            if(line.contains(searchStr)){
            return true;
            }
        }
        return false;
    }
    
     public static void updateLine(String filePath, String oldString, String newString) throws IOException{
        
        Path path = Paths.get(filePath);
        List<String> fileContent = new ArrayList<>(Files.readAllLines(path, StandardCharsets.UTF_8));
      
         for (int i = 0; i < fileContent.size(); i++) {
         String a= fileContent.get(i);
                
            if (a.equals(oldString)) {
    
                fileContent.set(i, newString);
                break;
            }
        }
        Files.write(path, fileContent, StandardCharsets.UTF_8);
    }
    
    
    public static void removeLineFromFile(String pathFile, String lineToRemove) {
        
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
    
    public static void updateTechnicianDate(String filePath, String orderId, String oldDate) throws IOException{
        
        Path path = Paths.get(filePath);
        FileManager fileManager= new FileManager();
        List<String> fileContent = new ArrayList<>(Files.readAllLines(path, StandardCharsets.UTF_8));
      
         for (int i = 0; i < fileContent.size(); i++) {
         String a= fileContent.get(i);
                
            if (a.contains(oldDate)&&a.contains(orderId)) {

                String line= fileManager.parseFile(filePath,orderId);
                Gson gson= new Gson();

                Technician technician= gson.fromJson(line, Technician.class);
                
                for(int w=0; w<technician.dates.size();w++){

                    if(technician.dates.get(w).equals(oldDate)){
                       technician.dates.set(w, "000000");
                       break;
                    }
                }
                for(int h=0; h<technician.orderId.size();h++){

                    if(technician.orderId.get(h).equals(orderId)){
                       technician.orderId.set(h, "00000");
                       break;
                    }
                }
               
                String newLine= gson.toJson(technician);
                fileContent.set(i, newLine);
                break;
            }
        }
        Files.write(path, fileContent, StandardCharsets.UTF_8);
    }
    
    
    public static String encrypt(String password){
    String encryptPassword;
      
    List<String> list = new ArrayList<>(Arrays.asList(password.split("")));
     
    for(int i=0; i<list.size();i++){
        String tempString = list.get(i);
        char tempChar = tempString.charAt(0);  

        int asciiValue = (int) tempChar;
            asciiValue = asciiValue+8;

        char newChar = (char)asciiValue;
        list.set(i, String.valueOf(newChar));
    }
    
    encryptPassword = String.join("", list);
  
    return encryptPassword;
    }
     
    public static String encryptforTest(String password,int type){
    String encryptedPassword;
      
    List<String> list = new ArrayList<>(Arrays.asList(password.split("")));
     
    for(int i=0; i<list.size();i++){
        String tempString = list.get(i);
        char tempChar = tempString.charAt(0);  

        int asciiValue = (int) tempChar;
            asciiValue = asciiValue+type;

        char newChar = (char)asciiValue;
        list.set(i, String.valueOf(newChar));
    }
    
    encryptedPassword = String.join("", list);
  
    return encryptedPassword;
    }
    
    public static String decrypt(String encryptPassword){
    String decryptPassword;
      
    List<String> list = new ArrayList<>(Arrays.asList(encryptPassword.split("")));
     
    for(int i=0; i<list.size();i++){
        String tempString = list.get(i);
        char tempChar = tempString.charAt(0);  

        int asciiValue = (int) tempChar;
            asciiValue = asciiValue-8;

        char newChar = (char)asciiValue;
        list.set(i, String.valueOf(newChar));
    }
    
    decryptPassword = String.join("", list);
  
    return decryptPassword;
    }
    
    public static String decryptforTest(String encryptPassword, int arg){
    String decryptPassword;
      
    List<String> list = new ArrayList<>(Arrays.asList(encryptPassword.split("")));
     
    for(int i=0; i<list.size();i++){
        String tempString = list.get(i);
        char tempChar = tempString.charAt(0);  

        int asciiValue = (int) tempChar;
            asciiValue = asciiValue-arg;

        char newChar = (char)asciiValue;
        list.set(i, String.valueOf(newChar));
    }
    
    decryptPassword = String.join("", list);
  
    return decryptPassword;
    }
    
    
    public static void modifyFile(String filePath, String oldString, String newString){
        
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
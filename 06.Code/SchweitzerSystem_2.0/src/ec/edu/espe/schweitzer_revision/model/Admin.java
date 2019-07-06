package ec.edu.espe.schweitzer_revision.model;

import com.google.gson.Gson;
import ec.edu.espe.schweitzer_revision.controller.FileManager;
import java.util.ArrayList;

/**
 *
 * @author David Lopez
 */
public class Admin {
    
      
    public String newTechnicianId() {
      String filePath= "files\\TechnicianId.txt";
      String tempId;
      String id;
      
        FileManager updateId= new FileManager();
        
        tempId=updateId.getConstantId(filePath);
        
        int repairId = Integer.parseInt(tempId);
        repairId= repairId+1;
        id=String.valueOf(repairId);
        
        updateId.modifyFile(filePath, tempId, id);
       
       return id;
    }

    
    public String readID() {
      String filePath= "files\\TechnicianId.txt";
      String tempId;

        FileManager updateId= new FileManager();  
        tempId=updateId.getConstantId(filePath); 

       return tempId;
    }
    
    public String create(String txtName, String txtPassword){
    
    String technicianFilePath="Files\\TechnicianList.txt" ;
    String backupPath="Backup\\TechnicianList.txt";
    String cipherPath="Files\\Cipher.txt"; 
    String backupCipher="Backup\\Cipher.txt"; 
    Gson gson = new Gson();
    Technician newTechnician = new Technician();
    newTechnician.setName(txtName);
    String tempId= newTechnicianId();
    newTechnician.setId(tempId);//automatizar

    
    ArrayList<String> dates = new ArrayList<String>();
    int n= 0;
    while(n<=7){
    dates.add("000000");
    n++;
    }
    
    newTechnician.setDates(dates);
    
    ArrayList<String> orderId = new ArrayList<String>();
    int m= 0;
    while(m<=7){
    orderId.add("00000");
    m++;
    }
    
    newTechnician.setOrderId(orderId);
    String newTech = gson.toJson(newTechnician);
    FileManager.appendStrToFile(technicianFilePath,newTech);
    FileManager.appendStrToFile(backupPath,newTech);

    
    Password newUser = new Password();
    String tempIdPass= readID();
    newUser.setId(tempIdPass);
    
    newUser.setName(txtName);
    String encrypted = FileManager.encrypt(txtPassword);
    newUser.setPassword(encrypted);
    
    String newPass = gson.toJson(newUser);
    
    FileManager.appendStrToFile(cipherPath,newPass);
    FileManager.appendStrToFile(backupCipher,newPass);
    
    return tempIdPass;
    }
    
}

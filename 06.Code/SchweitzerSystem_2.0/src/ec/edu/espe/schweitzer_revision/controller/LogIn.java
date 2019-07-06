package ec.edu.espe.schweitzer_revision.controller;

import ec.edu.espe.schweitzer_revision.model.Password;
import ec.edu.espe.schweitzer_revision.model.Technician;
import ec.edu.espe.schweitzer_revision.view.FRMLoginTechnician;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Lopez
 */
public class LogIn {
      
    public boolean LogInAdmin(String txtId, String txtPassword){
        boolean success=false;
        try {
            
            String cipherPath = "Files//adCipher.txt";
            Password aux = new Password();
            Technician tech = new Technician();
            aux.setId(txtId);
            aux.setPassword(txtPassword);
           
            if(FileManager.searchFile(cipherPath, aux.getId())){
                if(tech.checkPassword(aux.getId(),aux.getPassword(),cipherPath)==true){
                success= true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FRMLoginTechnician.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return success;
    }
    
    public boolean LogInTech(String txtId, String txtPassword){
        
        boolean sucess=false;
        try {
            String cipherPath="Files\\Cipher.txt";
            String filePath= "Files\\ConstantIdLogin.txt";
            String passwordPath= "Files\\ConstantPassword.txt";
            
            Password aux = new Password();
            Technician tech = new Technician();
            aux.setId(txtId);
            aux.setPassword(txtPassword);
           
            if(FileManager.searchFile(cipherPath, aux.getId())){
                if(tech.checkPassword(aux.getId(),aux.getPassword(),cipherPath)==true){
                
                sucess=true;
                String id = txtId;
                String password = txtPassword;
            
                String content = FileManager.getConstantId(filePath);
                String contentPass = FileManager.getConstantId(passwordPath);
                
                FileManager.modifyFile(filePath,content,id);
                FileManager.modifyFile(passwordPath,contentPass,password);
                }    
            }
                
            } catch (IOException ex) {
            Logger.getLogger(FRMLoginTechnician.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sucess;
    }
}



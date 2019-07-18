package ec.edu.espe.schweitzer_revision.controller;

import com.google.gson.Gson;
import com.mongodb.DBCursor;
import ec.edu.espe.schweitzer_revision.model.Password;
import ec.edu.espe.schweitzer_revision.model.Path;
import ec.edu.espe.schweitzer_revision.model.Technician;
import ec.edu.espe.schweitzer_revision.view.FRMLoginTechnician;
import filemanager.FileManager;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David Lopez
 */
public class LogIn {
      
    public boolean LogInAdmin(String txtId, String txtPassword){
        boolean success = false;
        Password aux = new Password();
        aux.setId(txtId);
        aux.setPassword(aux.encrypt(txtPassword));
        ConnectionDataBase connection = new ConnectionDataBase();
        DBCursor cursor = connection.getDb().getCollection("AdminsCipher").find();
        while(cursor.hasNext()){
            Gson gson = new Gson();
            Password aux1 = new Password();
            aux1 = gson.fromJson(cursor.next().toString(),Password.class);
            if(aux1.getId().equals(aux.getId()) && aux1.getPassword().equals(aux.getPassword())){
                success = true;
            }
        }
        return success;
    }
    
    public boolean LogInTech(String txtId, String txtPassword){
        
        boolean sucess=false;
        try {
            String cipherPath=Path.cipher;
            String filePath=Path.logInId;
            String passwordPath= Path.logInPass;
            
            Password aux = new Password();
            Technician tech = new Technician();
            aux.setId(txtId);
            aux.setPassword(txtPassword);
           
            if(FileManager.searchFile(cipherPath, aux.getId())){
                if(tech.checkPassword(aux.getId(),aux.getPassword(),cipherPath)==true){
                
                sucess=true;
                }    
            }
            } catch (IOException ex) {
            Logger.getLogger(FRMLoginTechnician.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sucess;
    }
}



package ec.edu.espe.schweitzer_revision.controller;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import ec.edu.espe.schweitzer_revision.model.Password;
import ec.edu.espe.schweitzer_revision.model.Technician;

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
        Password aux = new Password();
        Technician tech = new Technician();
        aux.setId(txtId);
        String encrypt = aux.encrypt(txtPassword);
        aux.setPassword(encrypt);
        ConnectionDataBase connection = new ConnectionDataBase();
        BasicDBObject techCheckPass = new BasicDBObject().append("id",txtId);
        DBCursor cursor = connection.getDb().getCollection("technicianCipher").find(techCheckPass);
        if(cursor.hasNext()){
            if(tech.checkPassword(aux.getId(),aux.getPassword())){
                sucess = true;
            }
        }
        return sucess;
    }
}



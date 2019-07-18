/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.controller;

import com.mongodb.DB;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhony Naranjo
 */
public class ConnectionDataBase {
 private DB db;

 
    public ConnectionDataBase() {
     try {
         Mongo mongo = new Mongo("localhost",27017);
         db = mongo.getDB("SchweitzerSystem");
     } catch (UnknownHostException ex) {
         Logger.getLogger(ConnectionDataBase.class.getName()).log(Level.SEVERE, null, ex);
     }      
    }

    public DB getDb() {
        return db;
    }

}

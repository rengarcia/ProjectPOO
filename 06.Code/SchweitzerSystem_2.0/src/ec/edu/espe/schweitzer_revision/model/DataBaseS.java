/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.model;

/**
 *
 * @author David Lopez
 */
public class DataBaseS {
    private static DataBaseS conect;
    private String validate;

    private DataBaseS() {
        
        this.validate= validate;
    
    }

    
    
    public static DataBaseS getConect() {
   return conect;
    }

    public static void setConect(DataBaseS conect) {
        DataBaseS.conect = conect;
    }

    public String getValidate() {
        return validate;
    }

    public void setValidate(String validate) {
        this.validate = validate;
    }
    
    
}
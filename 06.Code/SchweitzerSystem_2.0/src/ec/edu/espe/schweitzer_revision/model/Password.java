package ec.edu.espe.schweitzer_revision.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author David Lopez
 */
public class Password {
    
    private String name;
    private String id;
    private String password;

   
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
   
    public String encrypt(String password){
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
    
    
}

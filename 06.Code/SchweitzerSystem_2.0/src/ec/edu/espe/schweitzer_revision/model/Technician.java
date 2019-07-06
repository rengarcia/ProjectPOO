package ec.edu.espe.schweitzer_revision.model;

import com.google.gson.Gson;
import filemanager.FileManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David Lopez
 */
public class Technician {

    private String name;
    private String id;
    public ArrayList<String> dates;
    public ArrayList<String> orderId;

    public Technician(String name, String id, ArrayList<String> dates, ArrayList<String> orderId) {
        this.name = name;
        this.id = id;
        this.dates = dates;
        this.orderId = orderId;
    }

    public Technician() {

    }

    public boolean checkPassword( String technicianId, String passwordAttempt,
                String cipherFilePath)
                throws FileNotFoundException {
        
        boolean pass = false;

        Gson gson = new Gson();

        String passwordLine = FileManager.parseFile(cipherFilePath, technicianId);
        Password password = gson.fromJson(passwordLine, Password.class);

        String actualPassword = FileManager.decrypt(password.getPassword());

        if (actualPassword.equals(passwordAttempt)) {
            pass = true;
        }

        return pass;
    }
    
    public static void updateTechnicianDate(String filePath, String orderId, String oldDate) throws IOException{
        
        java.nio.file.Path path = Paths.get(filePath);
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

    public ArrayList<String> getDates() {
        return dates;
    }

    public void setDates(ArrayList<String> dates) {
        this.dates = dates;
    }
    public ArrayList<String> getOrderId() {
        return orderId;
    }

    public void setOrderId(ArrayList<String> orderId) {
        this.orderId = orderId;
    }
}

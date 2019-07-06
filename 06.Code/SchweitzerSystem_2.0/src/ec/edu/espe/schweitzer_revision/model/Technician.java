package ec.edu.espe.schweitzer_revision.model;

import com.google.gson.Gson;
import ec.edu.espe.schweitzer_revision.controller.FileManager;
import java.io.FileNotFoundException;
import java.util.ArrayList;

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

        public boolean checkPassword(String technicianId, String passwordAttempt,
            String cipherFilePath) throws FileNotFoundException {

        boolean pass = false;

        FileManager dataLine = new FileManager();
        Gson gson = new Gson();

        String passwordLine = FileManager.parseFile(cipherFilePath, technicianId);
        Password password = gson.fromJson(passwordLine, Password.class);

        String actualPassword = dataLine.decrypt(password.getPassword());

        if (actualPassword.equals(passwordAttempt)) {
            pass = true;
        }

        return pass;
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

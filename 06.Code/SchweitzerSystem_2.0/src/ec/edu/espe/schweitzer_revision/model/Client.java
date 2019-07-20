package ec.edu.espe.schweitzer_revision.model;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import filemanager.FileManager;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author David Lopez
 */
public class Client {
    
    DB db;
    DBCollection orderTable;
    DBCollection technicianTable;
    
    
    private String name;
    private long id;
    private String address;
    private long phone;
    public Boolean flag = true;
    private Repair newRepairOrder;
    private Maintenance newMaintenanceOrder;

    public Client(String name, long id, String address, long phone, Repair newRepairOrder, Maintenance newMaintenanceOrder) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.newRepairOrder = newRepairOrder;
        this.newMaintenanceOrder = newMaintenanceOrder;
    }

    public Client() {
    }

    public static boolean AsssignOrder (ArrayList dateList, String date, ArrayList idLists,String orderId){
        boolean flag=false;
        for(int i=0;i<dateList.size();i++){
            if (date.equals(dateList.get(i))){
                System.out.println("Iguales");
               break;  
            }
            else if (dateList.get(i).equals("000000")){
                dateList.set(i, date);
                idLists.set(i,orderId);
                flag=true;
                break;
            }
                
        }
        return flag;
    }   
        
    public void cancelOrder(String orderId)
            throws FileNotFoundException, IOException {
        
       Mongo mongo = new Mongo("localhost",27017);
       db=mongo.getDB("SchweitzerSystem");
       orderTable=db.getCollection("orderTableTest");

        
        int value = Integer.parseInt(orderId);
      
        if (value < 20000) {
          Technician.updateTechnicianDate(orderId);
          BasicDBObject orderToDelete = new BasicDBObject().append("newRepairOrder.id",orderId);
          orderTable.remove(orderToDelete);
        } 
        else {
          Technician.updateTechnicianDate(orderId);
          BasicDBObject orderToDelete = new BasicDBObject().append("newMaintenanceOrder.id",orderId);
          orderTable.remove(orderToDelete);
        } 
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Repair getNewRepairOrder() {
        return newRepairOrder;
    }

    public void setNewRepairOrder(Repair newRepairOrder) {
        this.newRepairOrder = newRepairOrder;
    }

    public Maintenance getNewMaintenanceOrder() {
        return newMaintenanceOrder;
    }

    public void setNewMaintenanceOrder(Maintenance newMaintenanceOrder) {
        this.newMaintenanceOrder = newMaintenanceOrder;
    }

}

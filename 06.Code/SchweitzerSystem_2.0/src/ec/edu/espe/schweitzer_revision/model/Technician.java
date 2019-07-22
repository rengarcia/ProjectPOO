package ec.edu.espe.schweitzer_revision.model;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import ec.edu.espe.schweitzer_revision.controller.ConnectionDataBase;
import java.io.IOException;
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

    public boolean checkPassword( String technicianId, String passwordAttempt){
        
        boolean pass = false;
        Gson gson = new Gson();
        ConnectionDataBase connection = new ConnectionDataBase();
        BasicDBObject techCheckPass = new BasicDBObject().append("id",technicianId);
        DBCursor cursor = connection.getDb().getCollection("technicianCipher").find(techCheckPass);
        if(cursor.hasNext()){
            Password aux1 = new Password();
            aux1 = gson.fromJson(cursor.next().toString(),Password.class);
            if(passwordAttempt.equals(aux1.getPassword())){
                pass = true;
            }
        }
        return pass;
    }
    
    public static void updateTechnicianDate(String orderId) throws IOException{
       
       DB db;

       DBCollection technicianTable; 
       
       Mongo mongo = new Mongo("localhost",27017);
       db=mongo.getDB("SchweitzerSystem");

       technicianTable=db.getCollection("technicianTableTest");
        
       
       BasicDBObject technicianCollection = new BasicDBObject();
   
        boolean stop=true;
        String id;
        DBCursor cursorDates = technicianTable.find(technicianCollection);
        DBCursor cursorOrderId= technicianTable.find(technicianCollection);
        DBCursor techId= technicianTable.find(technicianCollection);
        
        while(cursorDates.hasNext()&&stop)
        {
          ArrayList datesList= (ArrayList<String>) cursorDates.next().get("dates");
          ArrayList idList= (ArrayList<String>) cursorOrderId.next().get("orderId");          
          id = (String)techId.next().get("id");   
          
          boolean flag = check(datesList,idList,orderId);
          if(flag)
          {     
            BasicDBObject olddoc = new BasicDBObject().append("id",id); 
            technicianCollection.append("$set",new BasicDBObject().append("dates", datesList));
            technicianTable.update(olddoc, technicianCollection,false,false);
               
            technicianCollection.append("$set",new BasicDBObject().append("orderId", idList));
            technicianTable.update(olddoc, technicianCollection,false,false);
               
            System.out.println("Sucess");
            stop=false;
          }   
        }
    }

    public static boolean check (ArrayList dateList, ArrayList idLists,String orderId){
        boolean flag=false;
        for(int i=0;i<dateList.size();i++){
            if (orderId.equals(idLists.get(i))){
               idLists.set(i,"00000");
               dateList.set(i,"000000");
               flag=true;
               break;  
            }    
        }
        return flag;
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

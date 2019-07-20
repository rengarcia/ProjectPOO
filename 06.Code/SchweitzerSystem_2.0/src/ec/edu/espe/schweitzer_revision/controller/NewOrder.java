package ec.edu.espe.schweitzer_revision.controller;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import ec.edu.espe.schweitzer_revision.model.Client;
import ec.edu.espe.schweitzer_revision.model.Maintenance;
import ec.edu.espe.schweitzer_revision.model.Order;
import ec.edu.espe.schweitzer_revision.model.Repair;
import ec.edu.espe.schweitzer_revision.view.FRMClient;
import static java.awt.image.ImageObserver.WIDTH;
import java.net.UnknownHostException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.bson.BSONObject;

/**
 *
 * @author David Lopez
 */
public class NewOrder {
    
    DB db;
    DBCollection orderTable;
    DBCollection technicianTable;
    
    Order newOrder;
    public Client setData(String txtName,String txtId, String txtAddress, String txtPhoneNumber, 
            String choice){
              
        //Get Data for Client class
        Client clientData = new Client();
     
        clientData.setName(txtName);
             
        clientData.setId(Long.valueOf(txtId));
             
        clientData.setAddress(txtAddress);
        
        clientData.setPhone(Long.valueOf(txtPhoneNumber));
        
        //temperal value for Combo Box
       
        if (choice.equals("Reparacion")){
                      
            clientData.flag=true;
        }
        
        else if (choice.equals("Mantenimiento")){

            clientData.flag=false;
        
            }
        return clientData;
    }  
    
    public Order RepairOrder(Long dateInLong,String txtReparationAddress,String txtReparationDescription,
        boolean type,int priorityChoice){
            
        boolean flag = false; 
        if(priorityChoice==1){
            flag=true;
            }        
        newOrder = new Repair( );
        newOrder.build(dateInLong, txtReparationAddress, txtReparationDescription,0,type, flag);
        
        return newOrder;
    }
    
    public Order MaitenanceOrder(long dateInLong,String txtMaintenanceAddress, 
            String txtMaintenanceDescription,int txtSesionNumber,boolean type){
       
        newOrder = new Maintenance();  
        newOrder.build (dateInLong, txtMaintenanceAddress, txtMaintenanceDescription, txtSesionNumber, type,
                Boolean.FALSE);
        return newOrder;
    }
    
    
    public void reserveOrder(Client clientData,FRMClient currentFrame) throws UnknownHostException{
        
        Mongo mongo = new Mongo("localhost",27017);
        db=mongo.getDB("SchweitzerSystem");
        orderTable=db.getCollection("orderTableTest");
        technicianTable=db.getCollection("technicianTableTest");
        
        String tempId;
        Long tempDate;

        Boolean decide = clientData.flag;

        if (decide) {
            tempId = clientData.getNewRepairOrder().getId();
            tempDate= clientData.getNewRepairOrder().getDate();
            
        } else {
            tempId = clientData.getNewMaintenanceOrder().getId();
            tempDate= clientData.getNewMaintenanceOrder().getDate();
        }

        //convert data to json format
        Gson gson = new Gson();
        String jsonClientData;
        jsonClientData = gson.toJson(clientData);

        BSONObject bson = (BSONObject)com.mongodb.util.JSON.parse(jsonClientData);        
        BasicDBObject document = new BasicDBObject();
        document.putAll(bson);
        orderTable.insert(document);

        
        BasicDBObject doc = new BasicDBObject();
        boolean stop=true;
        String id;
        DBCursor cursorDates = technicianTable.find(doc);
        DBCursor cursorOrderId= technicianTable.find(doc);
        DBCursor techId= technicianTable.find(doc);
        while(cursorDates.hasNext()&&stop)
        {
            ArrayList datesList= (ArrayList<String>) cursorDates.next().get("dates");
            ArrayList idList= (ArrayList<String>) cursorOrderId.next().get("orderId");
            id = (String)techId.next().get("id");
            
            boolean flag = Client.AsssignOrder(datesList,Long.toString(tempDate),idList,tempId);
            if(flag)
            {
                doc.append("$set",new BasicDBObject().append("dates", datesList));
                BasicDBObject olddoc = new BasicDBObject().append("id",id);
                technicianTable.update(olddoc, doc,false,false);
                
                doc.append("$set",new BasicDBObject().append("orderId",idList));
                technicianTable.update(olddoc, doc,false,false);
                
                System.out.println("Sucess");
                stop=false;
            }
            
            JOptionPane.showMessageDialog(currentFrame,"Su orden fue asignada con éxito\n"
                    + "El ID de su orden es: "+ tempId,"Orden Asignada", WIDTH);
        }
    }
}

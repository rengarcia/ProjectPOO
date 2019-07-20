package ec.edu.espe.schweitzer_revision.model;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import filemanager.FileManager;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author David Lopez
 */
public class Maintenance extends Order{
    
   private int session;
   DB db;
   DBCollection orderTable;
   DBCollection technicianTable;
  
    public Maintenance(){   
    }    
    
    @Override
    public String generateID() {
      String filePath= Path.idForNewMaintenance;
      String tempId;
 
        tempId=FileManager.getConstantId(filePath);
        
        int repairId = Integer.parseInt(tempId);
        repairId= repairId+1;
        id=String.valueOf(repairId);
        
        FileManager.modifyFile(filePath, tempId, id);
       
       return id;
    }
    
    @Override
    public void Priority(Boolean flag) {
        //nothing to do here
    }

    @Override
    public void SessionNumber(int sessionNumber) {
       this.session= sessionNumber;
    }

    @Override
    public void updateOrder(String orderId) throws FileNotFoundException {
        
    }
    
    public void updateOrder(String orderId, String descriptionUpdate, String completionDateUpdate,
            String completionOrderUpdate) throws FileNotFoundException, IOException {
        
        Mongo mongo = new Mongo("localhost",27017);
        db=mongo.getDB("SchweitzerSystem");
        orderTable=db.getCollection("orderTableTest");
        technicianTable=db.getCollection("technicianTableTest");
   
        BasicDBObject olddoc = new BasicDBObject().append("newMaintenanceOrder.id",orderId);
        
        BasicDBObject newDescription = new BasicDBObject();
        newDescription.append("$set",new BasicDBObject().append("newMaintenanceOrder.status.description"
                ,descriptionUpdate));
        
        orderTable.update(olddoc, newDescription,false,false);
       
        BasicDBObject newCompletionOrder = new BasicDBObject();
        newCompletionOrder.append("$set",new BasicDBObject().append("newMaintenanceOrder.status.orderCompleted"
                ,completionOrderUpdate));
        
        orderTable.update(olddoc, newCompletionOrder,false,false);
        
        BasicDBObject newCompletionDate = new BasicDBObject();
        newCompletionDate.append("$set",new BasicDBObject().append("newMaintenanceOrder.status.orderCompletionDate"
                ,completionDateUpdate));
        
        orderTable.update(olddoc, newCompletionDate,false,false);
 
    }
}

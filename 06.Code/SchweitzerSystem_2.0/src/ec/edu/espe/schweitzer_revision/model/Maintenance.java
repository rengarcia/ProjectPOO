package ec.edu.espe.schweitzer_revision.model;

import com.google.gson.Gson;
import filemanager.FileManager;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author David Lopez
 */
public class Maintenance extends Order{
    
   private int session;

   
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
    
    public void updateOrder(String orderId, String descriptionUpdate, String completionDateUpdate) throws FileNotFoundException, IOException {
        
        String clientOrderFilePath = Path.ClientOrders;
        String dataOrder;
        Gson gson = new Gson();
        dataOrder = FileManager.parseFile(clientOrderFilePath, orderId);
        Client dataFromFileClient = gson.fromJson(dataOrder, Client.class);
   
        dataFromFileClient.getNewMaintenanceOrder().getStatus().setDescription(descriptionUpdate);
        dataFromFileClient.getNewMaintenanceOrder().getStatus().setOrderCompletionDate(completionDateUpdate);
        
       
        String newString = gson.toJson(dataFromFileClient);
        FileManager.updateLine(clientOrderFilePath,dataOrder,newString);
        
    }
}

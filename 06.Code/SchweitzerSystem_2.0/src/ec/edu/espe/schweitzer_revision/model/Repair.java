package ec.edu.espe.schweitzer_revision.model;

import com.google.gson.Gson;
import ec.edu.espe.schweitzer_revision.controller.FileManager;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author David Lopez
 */
public class Repair extends Order{
    
    private Boolean priority;
  
    public Repair(Long date, String address, String id, String description, OrderStatus status) {
        super(date, address, id, description, status);
    } 
    
    public Repair(){   
    }
    
    @Override
    public String generateID() {
        
        String filePath= "files\\ConstantRepairId.txt";
        String tempId;
                
        tempId=FileManager.getConstantId(filePath);
        
        int repairId = Integer.parseInt(tempId);
        repairId= repairId+1;
        id=String.valueOf(repairId);
        
        FileManager.modifyFile(filePath, tempId, id);
       
       return id;
    }
    
 
    public Boolean getPriority() {
        return priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }

    @Override
    public void updateOrder(String clientOrderFilePath, String orderId) throws FileNotFoundException {
        
    }
    
    public void updateOrder(String clientOrderFilePath, String orderId, String descriptionUpdate, 
            String completionDateUpdate, String completionOrderUpdate) throws FileNotFoundException, IOException {

       String dataOrder;
  
        Gson gson = new Gson();
        dataOrder=FileManager.parseFile(clientOrderFilePath, orderId);
        Client dataFromFileClient = gson.fromJson(dataOrder,Client.class);   
        
        dataFromFileClient.getNewRepairOrder().getStatus().setDescription(descriptionUpdate);
        dataFromFileClient.getNewRepairOrder().getStatus().setOrderCompletionDate(completionDateUpdate);
        dataFromFileClient.getNewRepairOrder().getStatus().setOrderCompleted(completionOrderUpdate);
        
        String newString = gson.toJson(dataFromFileClient);
        FileManager.updateLine(clientOrderFilePath,dataOrder,newString);
        
       
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        FileManager updateId= new FileManager();
        
        tempId=updateId.getConstantId(filePath);
        
        int repairId = Integer.parseInt(tempId);
        repairId= repairId+1;
        id=String.valueOf(repairId);
        
        updateId.modifyFile(filePath, tempId, id);
       
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
    
    public void updateOrder(String clientOrderFilePath, String orderId, String descriptionUpdate, String completionDateUpdate, String completionOrderUpdate) throws FileNotFoundException, IOException {

       String dataOrder;
        FileManager dataLine=new FileManager();
        Gson gson = new Gson();
        dataOrder=dataLine.parseFile(clientOrderFilePath, orderId);
        Client dataFromFileClient = gson.fromJson(dataOrder,Client.class);   
        
        dataFromFileClient.getNewRepairOrder().getStatus().setDescription(descriptionUpdate);
        dataFromFileClient.getNewRepairOrder().getStatus().setOrderCompletionDate(completionDateUpdate);
        dataFromFileClient.getNewRepairOrder().getStatus().setOrderCompleted(completionOrderUpdate);
        
        String newString = gson.toJson(dataFromFileClient);
        FileManager.updateLine(clientOrderFilePath,dataOrder,newString);
        
       
    }
}

package ec.edu.espe.schweitzer_revision.model;

import com.google.gson.Gson;
import ec.edu.espe.schweitzer_revision.controller.FileManager;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author David Lopez
 */
public class Maintenance extends Order{
    
    private int session;

    public Maintenance(Long date, String address, String id, String description, OrderStatus status) {
        super(date, address, id, description, status);
    }

    public Maintenance(){   
    }    
    
    @Override
    public String generateID() {
      String filePath= "files\\ConstantMaintenanceId.txt";
      String tempId;
 
        tempId=FileManager.getConstantId(filePath);
        
        int repairId = Integer.parseInt(tempId);
        repairId= repairId+1;
        id=String.valueOf(repairId);
        
        FileManager.modifyFile(filePath, tempId, id);
       
       return id;
    }
    

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    @Override
    public void updateOrder(String clientOrderFilePath, String orderId) throws FileNotFoundException {
        
    }
    
    public void updateOrder(String clientOrderFilePath, String orderId, String descriptionUpdate, String completionDateUpdate) throws FileNotFoundException, IOException {

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

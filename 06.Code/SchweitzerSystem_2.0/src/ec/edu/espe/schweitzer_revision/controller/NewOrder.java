package ec.edu.espe.schweitzer_revision.controller;

import com.google.gson.Gson;
import ec.edu.espe.schweitzer_revision.model.Client;
import ec.edu.espe.schweitzer_revision.model.Maintenance;
import ec.edu.espe.schweitzer_revision.model.OrderStatus;
import ec.edu.espe.schweitzer_revision.model.Path;
import ec.edu.espe.schweitzer_revision.model.Repair;
import ec.edu.espe.schweitzer_revision.view.FRMClient;
import filemanager.FileManager;
import static java.awt.image.ImageObserver.WIDTH;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author David Lopez
 */
public class NewOrder {
    
    public Client setData(String txtName,String txtId, String txtAddress, String txtPhoneNumber, 
            String choice){
              
        //Get Data for Client class
        Client clientData = new Client();
     
        clientData.setName(txtName);
             
        clientData.setId(Long.valueOf(txtId));
             
        clientData.setAddress(txtAddress);
        
        clientData.setPhone(Long.valueOf(txtPhoneNumber));
        
        //Data for Order Status is set these values for default
       
        
        OrderStatus orderStatusData= new OrderStatus();
        orderStatusData.setDescription("null");
        orderStatusData.setOrderCompletionDate("null");
        orderStatusData.setOrderCompleted("null");
        
        //temperol value for Combo Box
       
        if (choice.equals("Reparacion")){
                      
            clientData.flag=true;
        }
        
        else if (choice.equals("Mantenimiento")){

            clientData.flag=false;
        
            }
        return clientData;
    }  
    
    public Repair RepairOrder(Long dateInLong,String txtReparationAddress,String txtReparationDescription,
        int priorityChoice){
        Repair repairData = new Repair();

            repairData.setDate(dateInLong);
    
            repairData.setAddress(txtReparationAddress);
            
            repairData.setDescription(txtReparationDescription);
           
            if(priorityChoice==1){
            repairData.setPriority(true);
            }
            else if(priorityChoice==2){
            repairData.setPriority(false);    
            }
            
            repairData.setId(repairData.generateID());
            repairData.setStatus(Status());
        
        return repairData;
    }
    
    public Maintenance MaitenanceOrder(long dateInLong,String txtMaintenanceAddress, 
            String txtMaintenanceDescription,String txtSesionNumber){
        Maintenance maintenanceData = new Maintenance();
            
            maintenanceData.setDate(dateInLong);

            maintenanceData.setAddress(txtMaintenanceAddress);

            maintenanceData.setDescription(txtMaintenanceDescription);

            maintenanceData.setSession(Integer.parseInt(txtSesionNumber));

            maintenanceData.setId(maintenanceData.generateID());
            
            maintenanceData.setStatus(Status());
        
        return maintenanceData;
    }
    
    public OrderStatus Status(){
        OrderStatus orderStatusData= new OrderStatus();
        orderStatusData.setDescription("null");
        orderStatusData.setOrderCompletionDate("null");
        orderStatusData.setOrderCompleted("null");
        
        return orderStatusData;
    }
    
    public void reserveOrder(Client clientData,FRMClient currentFrame){
        
        String clientOrderFilePath=Path.ClientOrders;
        String backupPath=Path.backupClientOrders;
        
        String tempId;

        Boolean decide = clientData.flag;

        if (decide) {
            tempId = clientData.getNewRepairOrder().getId();
        } else {
            tempId = clientData.getNewMaintenanceOrder().getId();
        }

        //convert data to json format
        Gson gson = new Gson();
        String jsonClientData;
        jsonClientData = gson.toJson(clientData);

        File firstTimeRun = new File(clientOrderFilePath);
        boolean exist = firstTimeRun.exists();
        if (exist == false) {
            FileManager.writeFile(clientOrderFilePath, jsonClientData);
            FileManager.writeFile(backupPath, jsonClientData);
        } else {
            FileManager.appendStrToFile(clientOrderFilePath, jsonClientData);
            FileManager.appendStrToFile(backupPath, jsonClientData);
        }

        Client newOrderWaiting = new Client();
        try {
            newOrderWaiting.AssignOrder(tempId);

            JOptionPane.showMessageDialog(currentFrame,"Su orden fue asignada con éxito\n"
                    + "El ID de su orden es: "+ tempId,"Orden Asignada", WIDTH);
            
        } catch (FileNotFoundException ex) {} catch (IOException ex) {
         JOptionPane.showMessageDialog(currentFrame,"Error con su orden","Error Orden", WIDTH);
         Logger.getLogger(FRMClient.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
}

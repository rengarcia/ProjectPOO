package ec.edu.espe.schweitzer_revision.controller;

import com.google.gson.Gson;
import ec.edu.espe.schweitzer_revision.model.Client;
import ec.edu.espe.schweitzer_revision.model.Maintenance;
import ec.edu.espe.schweitzer_revision.model.Order;
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

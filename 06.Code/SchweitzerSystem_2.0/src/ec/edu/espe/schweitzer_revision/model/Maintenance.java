/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.model;

import com.google.gson.Gson;
import ec.edu.espe.schweitzer_revision.controller.FileManager;
import ec.edu.espe.schweitzer_revision.frames.FRMUpdateMaintenance;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

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
        
        FileManager updateId= new FileManager();
        
        tempId=updateId.getConstantId(filePath);
        
        int repairId = Integer.parseInt(tempId);
        repairId= repairId+1;
        id=String.valueOf(repairId);
        
        updateId.modifyFile(filePath, tempId, id);
       
       return id;
    }
    
    
    public void updateOrder(String clientOrderFilePath, String orderId, String descriptionUpdate, String completionDateUpdate) throws FileNotFoundException {

        String dataOrder;
        FileManager dataLine = new FileManager();
        Gson gson = new Gson();
        dataOrder = dataLine.parseFile(clientOrderFilePath, orderId);
        Client dataFromFileClient = gson.fromJson(dataOrder, Client.class);
        String currentDescription;
        String currenteCompletionDate;
        currentDescription = dataFromFileClient.getNewMaintenanceOrder().getStatus().getDescription();
        currenteCompletionDate = dataFromFileClient.getNewMaintenanceOrder().getStatus().getOrderCompletionDate();
        FileManager.modifyFile(clientOrderFilePath, currentDescription, descriptionUpdate);
        FileManager.modifyFile(clientOrderFilePath, currenteCompletionDate, completionDateUpdate);
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    @Override
    public void updateOrder(String clientOrderFilePath, String orderId) throws FileNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

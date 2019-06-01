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
import java.util.Scanner;

/**
 *
 * @author David Lopez
 */
public class Client {

    private String name;
    private long id;
    private String address;
    private long phone;
    public Boolean flag = true;
    private Repair newRepairOrder;
    private Maintenance newMaintenanceOrder;

    public Client(String name, long id, String address, long phone, Repair newRepairOrder, Maintenance newMaintenanceOrder) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.newRepairOrder = newRepairOrder;
        this.newMaintenanceOrder = newMaintenanceOrder;
    }

    public Client() {
    }

    public void AssignOrder(String clientOrderFilePath, String TechnicianFilePath,
            String orderId)
            throws FileNotFoundException {

        String dataOrder;
        String technicianData;
        FileManager dataLine = new FileManager();

        int intOrderId = Integer.parseInt(orderId);
        dataOrder = dataLine.parseFile(clientOrderFilePath, orderId);

        Gson gson = new Gson();
        Client dataFromJsonClient = gson.fromJson(dataOrder, Client.class);
        String tempNewDateString;
        String tempNewIdString;

        if (intOrderId < 20000) {
            tempNewDateString = dataFromJsonClient.newRepairOrder.date.toString();
            tempNewIdString = dataFromJsonClient.newRepairOrder.id;
        } else {
            tempNewDateString = dataFromJsonClient.newMaintenanceOrder.date.toString();
            tempNewIdString = dataFromJsonClient.newMaintenanceOrder.id;
        }

        int n = 1;
        /*Si aumentas el tamaño de los arreglos  CAMBIA ESTE NUMERO 6*/
        while (n <= 6) {
            boolean flag = false;
            int loopTemporal = 30000 + n;
            String id = String.valueOf(loopTemporal);

            technicianData = dataLine.parseFile(TechnicianFilePath, id);
            Technician dataFromJsonTechnician = gson.fromJson(technicianData, Technician.class);
            int tempSize = dataFromJsonTechnician.dates.size();

            for (int i = 0; i <= tempSize; i++) {
                String tempOldDateString = dataFromJsonTechnician.dates.get(i);
                String tempOldIdString = dataFromJsonTechnician.orderId.get(i);
                int tempValue = Integer.parseInt(tempOldDateString);

                if (tempOldDateString.equals(tempNewDateString)) {
                    break;
                } else if (!tempOldDateString.equals(tempNewDateString)&&1000>tempValue) {
                    FileManager.modifyFile(TechnicianFilePath, tempOldDateString, tempNewDateString);
                    FileManager.modifyFile(TechnicianFilePath, tempOldIdString, tempNewIdString);
                    System.out.println("Su orden fue asignada");
                    flag = true;
                    break;
                }
            }
            if (flag == true) {
                break;
            }

            if (n == 6 && flag == false) {
                System.out.println("Lo sentimos, no hay nadie disponible en esa fecha");
            }
            n++;
        }
    }

    public void cancelOrder(String backupPath, String clientOrderFilePath, String orderId)
            throws FileNotFoundException, IOException {

        String technicianFilePath = "Files\\TechnicianList.txt";
        String linetoDelete;
        String linetoUpdate;
        FileManager dataLine = new FileManager();

        linetoDelete = dataLine.parseFile(backupPath, orderId);
        dataLine.removeLineFromFile(clientOrderFilePath, linetoDelete);
        
        //we update the Technician File
        linetoUpdate = dataLine.parseFile(backupPath, orderId);

        Gson gson = new Gson();
        Client updateTechnicianDates = gson.fromJson(linetoUpdate, Client.class);
        
        int value = Integer.parseInt(orderId);
      
        if (value < 20000) {
            long tempDate = updateTechnicianDates.newRepairOrder.date;
            String tempDeleteOldDate = Long.toString(tempDate);
            FileManager.updateTechnicianDate(technicianFilePath,orderId,tempDeleteOldDate);
        } 
        else {
            long tempDate = updateTechnicianDates.newMaintenanceOrder.date;
            String tempDeleteOldDate = Long.toString(tempDate);
            FileManager.updateTechnicianDate(technicianFilePath,orderId,tempDeleteOldDate);
        } 

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Repair getNewRepairOrder() {
        return newRepairOrder;
    }

    public void setNewRepairOrder(Repair newRepairOrder) {
        this.newRepairOrder = newRepairOrder;
    }

    public Maintenance getNewMaintenanceOrder() {
        return newMaintenanceOrder;
    }

    public void setNewMaintenanceOrder(Maintenance newMaintenanceOrder) {
        this.newMaintenanceOrder = newMaintenanceOrder;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.view;

import com.google.gson.Gson;
import ec.edu.espe.schweitzer_revision.controller.FileManager;
import ec.edu.espe.schweitzer_revision.model.Client;
import ec.edu.espe.schweitzer_revision.model.Maintenance;
import ec.edu.espe.schweitzer_revision.model.OrderStatus;
import ec.edu.espe.schweitzer_revision.model.Repair;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @author David Lopez
 */
public class RevisionSystem {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        String clientOrderFilePath="Files\\ClientOrder.txt" ;
        String backupPath="Backup\\ClientOrder.txt" ;
        String technicianFilePath="Files\\TechnicianList.txt" ;
        
        //Esto es por donde el usurio ingresa los datos y se le asigna la order
        /*
        RevisionSystem  instance= new RevisionSystem ();
        Client clientData= instance.setData();
        FileManager newDataLine = new FileManager();
        
        String tempId;   
        
        Boolean decide=clientData.flag;
        
        if(decide==true){
          tempId=clientData.getNewRepairOrder().getId();  
        }
        else {
          tempId=clientData.getNewMaintenanceOrder().getId();  
        }
        
        //convert data to json format
        Gson gson = new Gson();
        String jsonClientData;
        jsonClientData = gson.toJson(clientData);
              
        File firstTimeRun= new File(clientOrderFilePath);
        boolean exist = firstTimeRun.exists();
        if(exist==false){
        newDataLine.writeFile(clientOrderFilePath,jsonClientData);
        newDataLine.writeFile(backupPath,jsonClientData);
        }
        else {
        newDataLine.appendStrToFile(clientOrderFilePath,jsonClientData);
        newDataLine.appendStrToFile(backupPath,jsonClientData);
        }    

        Client newOrderWaiting = new Client();
        try {
            newOrderWaiting.AssignOrder(clientOrderFilePath,technicianFilePath,
                   tempId);} catch (FileNotFoundException ex){}
        */
        
        /***************************************/
        //Esto iria donde se cancelan las ordenes
        /*Client userCancelOrder= new Client();
        Scanner scannerCancel= new Scanner(System.in);
        
        System.out.println("Porfavor ingresa el id de la orden: ");
        String tempCancelOrder= scannerCancel.nextLine();
        
        userCancelOrder.cancelOrder(backupPath,clientOrderFilePath,tempCancelOrder);
        
        
        /**************************************/
        //Este seria el menu para el tecnico 
        /*Technician technician = new Technician();
        Scanner scannerTechnician= new Scanner(System.in);
        System.out.println("Porfavor ingresa tu id: ");
        String tempTechnicianId= scannerTechnician.nextLine();
        
        technician.workStatus(clientOrderFilePath, technicianFilePath, 
                tempTechnicianId);*/
        
    }
    
    public Client setData(){
        
        //Get Data for Client class
        Client clientData = new Client();
        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese el nombre: ");
        clientData.setName(scanner.nextLine());
                
        System.out.println("Ingrese su ID: ");
        clientData.setId(scanner.nextLong());
        
        scanner.nextLine();  // fix to nextLine bug
        
        System.out.println("Ingrese su dirección: ");
        clientData.setAddress(scanner.nextLine());
        
        System.out.println("Ingrese su número de teléfono: ");
        clientData.setPhone(scanner.nextLong());
        
        //Data for Order Status is set these values for default
        FileManager randomValue = new FileManager();
        
        OrderStatus orderStatusData= new OrderStatus();
        orderStatusData.setDescription(randomValue.randomString());
        orderStatusData.setOrderCompletionDate(randomValue.randomString());
        orderStatusData.setOrderCompleted(randomValue.randomString());
        
        
        //decide wheter the client want a repair or maintenance
        System.out.println("---------------------------");
        System.out.println("Escoja una opción");
        System.out.println("1. Reparación");
        System.out.println("2. Mantenimiento");
        int orderTemporal = scanner.nextInt();
        
        
        if (orderTemporal==1){
            //Get data for Order attribute
            Repair repairData = new Repair();

            System.out.println("Ingrese la fecha del trabajo: ");
            repairData.setDate(scanner.nextLong());
            
            
            scanner.nextLine();  // fix to nextLine bug

            System.out.println("Ingrese la dirección del trabajo: ");
            repairData.setAddress(scanner.nextLine());

            System.out.println("Ingrese la descripción del trabajo: ");
            repairData.setDescription(scanner.nextLine());

            System.out.println("Es una reparación urgente:");
            System.out.println("1. Si");
            System.out.println("2. NO");
            int priorityTemporal=scanner.nextInt();
            
            if(priorityTemporal==1){
            repairData.setPriority(true);
            }
            else if(priorityTemporal==2){
            repairData.setPriority(false);    
            }
            
            repairData.setId(repairData.generateID());
            
            //Set data for Order attribute
            clientData.setNewRepairOrder(repairData);
            
            repairData.setStatus(orderStatusData);
            
            clientData.flag=true;
        }
        
        else if (orderTemporal==2){
            //Get data for Order attribute
            Maintenance maintenanceData = new Maintenance();

            System.out.println("Ingrese la fecha del trabajo: ");
            maintenanceData.setDate(scanner.nextLong());

            scanner.nextLine();  // fix to nextLine bug

            System.out.println("Ingrese la dirección del trabajo: ");
            maintenanceData.setAddress(scanner.nextLine());

            System.out.println("Ingrese la descripción del trabajo: ");
            maintenanceData.setDescription(scanner.nextLine());

            System.out.println("El numero de sesión");
            maintenanceData.setSession(scanner.nextInt());
            
            //Set data for Order attribute
            clientData.setNewMaintenanceOrder(maintenanceData);
            
            maintenanceData.setId(maintenanceData.generateID());
            
            maintenanceData.setStatus(orderStatusData);
            
            clientData.flag=false;
        }
                  
        return clientData;
    }
      
}

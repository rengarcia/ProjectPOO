/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.controller;

import com.google.gson.Gson;
import ec.edu.espe.schweitzer_revision.model.OrderStatus;
import ec.edu.espe.schweitzer_revision.model.Client;
import ec.edu.espe.schweitzer_revision.model.Repair;
import ec.edu.espe.schweitzer_revision.model.Maintenance;
import ec.edu.espe.schweitzer_revision.model.SparePart;
import ec.edu.espe.schweitzer_revision.model.Technician;
import ec.edu.espe.schweitzer_revision.view.RevisionSystem;
import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jhony Naranjo
 */
public class Menu {
    private int option = 0;
    
    Scanner scanner= new Scanner(System.in);
    String clientOrderFilePath="Files\\ClientOrder.txt" ;
    String backupPath="Backup\\ClientOrder.txt" ;
    String technicianFilePath="Files\\TechnicianList.txt" ;
    String cipherPath="Files\\Cipher.txt"; 
    String sellForm = "Files\\SellForm.txt";
    
    public void principalMenu(){
        System.out.println("Bienvenido");
        System.out.println("1.Cliente Opcion 1");
        System.out.println("2.Tecnico Opcion 2");
        System.out.println("3.Salir");
        option = scanner.nextInt();
    }      
    
    public void clientMenu(){
        System.out.println("Bienvenido");
        System.out.println("1.Agendar Orden Opcion 1");
        System.out.println("2.Cancelar Orden Opcion 2");
        System.out.println("3.Mostrar stock de productos");
        System.out.println("4.Salir");
        option = scanner.nextInt();
    }
    
     public static void readLastLine(String filePath) throws IOException{
         BufferedReader input = null;
         try {
             input = new BufferedReader(new FileReader(filePath));
         } catch (FileNotFoundException ex) {
             Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
         }

         String last = null, line;

         while ((line = input.readLine()) != null) {
             last = line;
             Gson gson = new Gson();
             ArrayList<SparePart> arraySparePart = new ArrayList<>();
             SparePart sparePart;
             sparePart = gson.fromJson(last, SparePart.class);
             arraySparePart.add(sparePart);
             System.out.println(arraySparePart.toString());
         }
    }
     
    public void sellForm() throws IOException{

        readLastLine(sellForm);

    }
    
        public Client setData(){
        
        //Get Data for Client class
        Client clientData = new Client();
        Scanner scanner= new Scanner(System.in);
        /*
            Verificacion de ingreso unicamente texto
        */
        boolean flagName = true;
        do{
            System.out.println("Ingrese el nombre: ");
            try{
                String auxName = scanner.nextLine();
                if(isTextual(auxName)){
                    clientData.setName(auxName);
                    flagName = false;
                }
            }catch(OnlyTextException e){
                System.out.println(e.getMessage());
            }
        }while(flagName);
                
        /*
            Verificacion de ingreso unicamente numerico
        */
        boolean flagID = true;
        do{
            System.out.println("Ingrese su ID: ");
            try{
                String auxID = scanner.nextLine();
                if(isNumeric(auxID)){
                    clientData.setId(Long.parseLong(auxID));
                    flagID = false;
                }
            }catch(OnlyNumberException e){
                System.out.println(e.getMessage());
            }
        }while(flagID);
        
        /*
            Verificacion de ingreso unicamente texto
        */
        boolean flagAddress = true;
        do{
            System.out.println("Ingrese su dirección: ");
            try{
                String auxAddress = scanner.nextLine();
                if(isTextual(auxAddress)){
                    clientData.setAddress(auxAddress);
                    flagAddress = false;
                }
            }catch(OnlyTextException e){
                System.out.println(e.getMessage());
            }
        }while(flagAddress);
        
        /*
            Verificacion de ingreso unicamente numerico
        */
        boolean flagPhone = true;
        do{
            System.out.println("Ingrese su número de teléfono: ");
            try{
                String auxPhone = scanner.nextLine();
                if(isNumeric(auxPhone)){
                    clientData.setPhone(Long.parseLong(auxPhone));
                    flagPhone = false;
                }
            }catch(OnlyNumberException e){
                System.out.println(e.getMessage());
            }
        }while(flagPhone);
        //Data for Order Status is set these values for default
        FileManager randomValue = new FileManager();
        
        OrderStatus orderStatusData= new OrderStatus();
        orderStatusData.setDescription(randomValue.randomString());
        orderStatusData.setOrderCompletionDate(randomValue.randomString());
        orderStatusData.setOrderCompleted(randomValue.randomString());
        
        
        //decide wheter the client want a repair or maintenance
        boolean flagTemporal = true;
        int orderTemporal = 0;
        /*
            Verificacion de ingreso unicamente numerico de dato
        */
        do{
            System.out.println("---------------------------");
            System.out.println("Escoja una opción");
            System.out.println("1. Reparación");
            System.out.println("2. Mantenimiento");
            try{
                String auxTemporal = scanner.nextLine();
                if(isNumeric(auxTemporal)){
                    orderTemporal = Integer.parseInt(auxTemporal);
                    flagTemporal = false;
                }
            }catch(OnlyNumberException e){
                System.out.println(e.getMessage());
            }
        }while(flagTemporal);
        
        switch (orderTemporal) {
            case 1: {
            //Get data for Order attribute
            Repair repairData = new Repair();
            
            /*
                Verificacion de ingreso unicamente numerico
            */
            boolean flagDate = true;
            do{
                System.out.println("Ingrese la fecha del trabajo: ");
                try{
                    String auxDate = scanner.nextLine();
                    if(isNumeric(auxDate)){
                        repairData.setDate(Long.parseLong(auxDate));
                        flagDate = false;
                    }
                }catch(OnlyNumberException e){
                    System.out.println(e.getMessage());
                }
            }while(flagDate);
            
            /*
                Verificacion de ingreso unicamente texto
            */
            boolean flagWorkAddress = true;
            do{
                System.out.println("Ingrese la dirección del trabajo: ");
                try{
                    String auxWorkAddress = scanner.nextLine();
                    if(isTextual(auxWorkAddress)){
                        repairData.setAddress(auxWorkAddress);
                        flagWorkAddress = false;
                    }
                }catch(OnlyTextException e){
                    System.out.println(e.getMessage());
                }
            }while(flagWorkAddress);
            
            boolean flagDescription = true;
            do{
                System.out.println("Ingrese la descripción del trabajo: ");
                try{
                    String auxDescription = scanner.nextLine();
                    if(isTextual(auxDescription)){
                        repairData.setDescription(auxDescription);
                        flagDescription = false;
                    }
                }catch(OnlyTextException e){
                    System.out.println(e.getMessage());
                }
            }while(flagDescription);
            
            /*
                Verificacion de ingreso unicamente numerico de dato
            */
            int priorityTemporal = 0;
            boolean flagPTemporal = true;
            do{
                System.out.println("Es una reparación urgente:");
                System.out.println("1. Si");
                System.out.println("2. NO");
                try{
                    String auxPTemporal = scanner.nextLine();
                    if(isNumeric(auxPTemporal)){
                        priorityTemporal = Integer.parseInt(auxPTemporal);
                        flagPTemporal = false;
                    }
                }catch(OnlyNumberException e){
                    System.out.println(e.getMessage());
                }
            }while(flagPTemporal);

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
            break;
           
            }
        
            case 2:{
            //Get data for Order attribute
            Maintenance maintenanceData = new Maintenance();
            
            /*
                Verificacion de ingreso unicamente numerico
            */
            boolean flagDate = true;
            do{
                System.out.println("Ingrese la fecha del trabajo: ");
                try{
                    String auxDate = scanner.nextLine();
                    if(isNumeric(auxDate)){
                        maintenanceData.setDate(Long.parseLong(auxDate));
                        flagDate = false;
                    }
                }catch(OnlyNumberException e){
                    System.out.println(e.getMessage());
                }
            }while(flagDate);
            
            /*
                Verificacion de ingreso unicamente texto
            */
            boolean flagWorkAddress = true;
            do{
                System.out.println("Ingrese la dirección del trabajo: ");
                try{
                    String auxWorkAddress = scanner.nextLine();
                    if(isTextual(auxWorkAddress)){
                        maintenanceData.setAddress(auxWorkAddress);
                        flagWorkAddress = false;
                    }
                }catch(OnlyTextException e){
                    System.out.println(e.getMessage());
                }
            }while(flagWorkAddress);
            
            boolean flagDescription = true;
            do{
                System.out.println("Ingrese la descripción del trabajo: ");
                try{
                    String auxDescription = scanner.nextLine();
                    if(isTextual(auxDescription)){
                        maintenanceData.setDescription(auxDescription);
                        flagDescription = false;
                    }
                }catch(OnlyTextException e){
                    System.out.println(e.getMessage());
                }
            }while(flagDescription);
            
            /*
                Verificacion de ingreso unicamente numerico
            */
            boolean flagSession = true;
            do{
                System.out.println("Ingrese la fecha del trabajo: ");
                try{
                    String auxSession = scanner.nextLine();
                    if(isNumeric(auxSession)){
                        maintenanceData.setSession(Integer.parseInt(auxSession));
                        flagSession = false;
                    }
                }catch(OnlyNumberException e){
                    System.out.println(e.getMessage());
                }
            }while(flagSession);
            
            //Set data for Order attribute
            clientData.setNewMaintenanceOrder(maintenanceData);
            
            maintenanceData.setId(maintenanceData.generateID());
            
            maintenanceData.setStatus(orderStatusData);
            
            clientData.flag=false;
            break;
            }
            
            default: 

        }
        return clientData;
    } 
    
    public void reserveOrder(){
                
        RevisionSystem instance = new RevisionSystem();
        Client clientData = instance.setData();
        FileManager newDataLine = new FileManager();

        String tempId;

        Boolean decide = clientData.flag;

        if (decide == true) {
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
            newDataLine.writeFile(clientOrderFilePath, jsonClientData);
            newDataLine.writeFile(backupPath, jsonClientData);
        } else {
            newDataLine.appendStrToFile(clientOrderFilePath, jsonClientData);
            newDataLine.appendStrToFile(backupPath, jsonClientData);
        }

        Client newOrderWaiting = new Client();
        try {
            newOrderWaiting.AssignOrder(clientOrderFilePath, technicianFilePath,
                    tempId);
        } catch (FileNotFoundException ex) {}
    }
    
    public void cancelOrder() throws IOException{

        Client userCancelOrder = new Client();
        Scanner scannerCancel = new Scanner(System.in);

        System.out.println("Porfavor ingresa el id de la orden: ");
        String tempCancelOrder = scannerCancel.nextLine();

        userCancelOrder.cancelOrder(backupPath, clientOrderFilePath, tempCancelOrder);

    }
    
    public void technicianMenu() throws FileNotFoundException{
    Technician technician = new Technician();
        Scanner scannerTechnician= new Scanner(System.in);
        Console con = System.console();  
        
        /*
            Verificacion de ingreso unicamente texto
        */
        boolean flagTID = true;
        String tempTechnicianId = null;
        do{
            System.out.println("Porfavor ingresa tu id: ");
            try{
                 String auxTempTechnicianId= scannerTechnician.nextLine();
                if(isTextual(auxTempTechnicianId)){
                    tempTechnicianId = auxTempTechnicianId;
                    flagTID = false;
                }
               
            }catch(OnlyTextException e){
                System.out.println(e.getMessage());
            }
        }while(flagTID);
        //
        boolean flagTPassword = true;
        String attemptPassword = null;
        do{
            System.out.println("Ingresa tu contraseña: ");
            try{
                String auxAttemptPassword= scannerTechnician.nextLine();
                if(isTextual(auxAttemptPassword)){
                    attemptPassword = auxAttemptPassword;
                    flagTPassword = false;
                }
            }catch(OnlyTextException e){
                System.out.println(e.getMessage());
            }
        }while(flagTPassword);  
        
        int n=0;
        while(n==0){
            boolean approve = technician.checkPassword(tempTechnicianId,attemptPassword,cipherPath);

            if(approve==true){
                 n=1;
                 technician.workStatus(clientOrderFilePath, technicianFilePath, cipherPath,
                 tempTechnicianId);
            }
            else{
                System.out.println("Contreseña incorrecta");
                do{
                    System.out.println("Ingresa la contraseña de nuevo: ");
                    try{
                        String auxAttemptPassword= scannerTechnician.nextLine();
                        if(isTextual(auxAttemptPassword)){
                            attemptPassword = auxAttemptPassword;
                            flagTPassword = false;
                        }
                       
                    }catch(OnlyTextException e){
                        System.out.println(e.getMessage());
                    }
                }while(flagTPassword);  
            }
        }
    }

    public Menu() {
    }

    public int getOption() {
        return option;
    }

    public void setOption(int option) {
        this.option = option;
    }

       private static boolean isNumeric(String cadena) throws OnlyNumberException{
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e){
            throw new OnlyNumberException("Ingrese numeros unicamente");
        }
    }
    
    private static boolean isTextual(String cadena) throws OnlyTextException{
        try{
            return !(cadena.contains("0")||cadena.contains("1")||cadena.contains("2")
                    ||cadena.contains("3")||cadena.contains("4")||cadena.contains("5")
                    ||cadena.contains("6")||cadena.contains("7")||cadena.contains("8")
                    ||cadena.contains("9"));
        }catch (Exception e){
            throw new OnlyTextException("Ingrese texto unicamente");
        }
    }
    
}

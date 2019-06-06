/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.controller;

import com.google.gson.Gson;
import ec.edu.espe.schweitzer_revision.model.Client;
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
        
        System.out.println("Porfavor ingresa tu id: ");
        String tempTechnicianId= scannerTechnician.nextLine();
        System.out.println("Ingresa tu contraseña: ");
        String attemptPassword= scannerTechnician.nextLine();
        
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
                System.out.println("Ingresa la contraseña de nuevo: ");
                attemptPassword= scannerTechnician.nextLine();
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
    
    
}

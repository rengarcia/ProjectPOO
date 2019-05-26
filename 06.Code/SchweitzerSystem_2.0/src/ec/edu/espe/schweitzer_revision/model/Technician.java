/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.model;
import com.google.gson.Gson;
import ec.edu.espe.schweitzer_revision.controller.FileManager;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author David Lopez
 */
public class Technician {
    private String name;
    private String id;
    ArrayList<String> dates;
    ArrayList<String> orderId;

    public Technician(String name, String id, ArrayList<String> dates, ArrayList<String> orderId) {
        this.name = name;
        this.id = id;
        this.dates = dates;
        this.orderId = orderId;
    }

    public Technician(){
    
    }   
    
    public void workStatus(String clientOrderFilePath,String technicianFilePath, String technicianId) 
            throws FileNotFoundException{
    
    Scanner scanner= new Scanner(System.in);    
    String dataTechnician;
    FileManager dataLine=new FileManager();
    Gson gson = new Gson();
    
    dataTechnician=dataLine.parseFile(technicianFilePath, technicianId);
    Technician dataFromFileTechnician = gson.fromJson(dataTechnician,Technician.class);  
    
    System.out.println("Bienvenido  "+dataFromFileTechnician.getName());
    
    System.out.println("\nEstos son las ordenes que tienes asignadas: ");
    System.out.println(dataFromFileTechnician.getOrderId());
    System.out.println("\nEn estas fechas: ");
    System.out.println(dataFromFileTechnician.getDates()); 
    int tempOption;
    System.out.println("\n Escoja: ");
    System.out.println("1. Reparaciones");
    System.out.println("2. Mantenimeintos");
    tempOption=scanner.nextInt();
    scanner.nextLine();
    
        if(tempOption==1){
        System.out.println("\n Ingresa el id de la orden que deseas actualizar: ");
        String tempOderId= scanner.nextLine();

        Repair repair = new Repair();
        repair.updateOrder(clientOrderFilePath, tempOderId);
        }
        else if (tempOption==2){
        System.out.println("\n Ingresa el id de la orden que deseas actualizar: ");
        String tempOderId= scanner.nextLine();

        Maintenance maintenance = new Maintenance();
        maintenance.updateOrder(clientOrderFilePath, tempOderId);
        }
    }
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<String> getDates() {
        return dates;
    }

    public void setDates(ArrayList<String> dates) {
        this.dates = dates;
    }

    public ArrayList<String> getOrderId() {
        return orderId;
    }

    public void setOrderId(ArrayList<String> orderId) {
        this.orderId = orderId;
    }
}

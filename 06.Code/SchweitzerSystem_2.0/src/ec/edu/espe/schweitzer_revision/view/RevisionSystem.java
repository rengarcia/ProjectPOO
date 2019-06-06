   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.view;

import ec.edu.espe.schweitzer_revision.controller.FileManager;
import ec.edu.espe.schweitzer_revision.controller.Menu;
import ec.edu.espe.schweitzer_revision.model.Client;
import ec.edu.espe.schweitzer_revision.model.Maintenance;
import ec.edu.espe.schweitzer_revision.model.OrderStatus;
import ec.edu.espe.schweitzer_revision.model.Repair;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author David Lopez
 */
public class RevisionSystem {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Menu menu = new Menu();
        do {
            menu.principalMenu();
            switch (menu.getOption()) {
                case 1:
                    do {
                        menu.setData();
                      
                    } while (menu.getOption() == 1 || menu.getOption() == 2);
                    break;
                case 2:
                    menu.technicianMenu();
                    break;
                case 3:
                    System.exit(0);

            }
        } while (menu.getOption() >= 1 || menu.getOption() <= 3);

    }
    
    public Client setData(){
        
        //Get Data for Client class
        Client clientData = new Client();
        Scanner scanner= new Scanner(System.in);
        System.out.println("Ingrese su nombre: ");
        clientData.setName(scanner.nextLine());
                
        System.out.println("Ingrese su ID (Cuatro últimos dígitos de su cédula): ");
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
        
        switch (orderTemporal) {
            case 1: {
            //Get data for Order attribute
            Repair repairData = new Repair();

            System.out.println("Ingrese la fecha del trabajo (dd/mm/aa): ");
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
            break;
           
            }
        
            case 2:{
            //Get data for Order attribute
            Maintenance maintenanceData = new Maintenance();

            System.out.println("Ingrese la fecha del trabajo(dd/mm/aa): ");
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
            break;
            }
            
            default: 

        }
        return clientData;
    }  
}

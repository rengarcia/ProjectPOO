/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.view;

import com.google.gson.Gson;
import com.csvreader.CsvWriter;
import ec.edu.espe.schweitzer_revision.model.Client;
import ec.edu.espe.schweitzer_revision.model.Maintenance;
import ec.edu.espe.schweitzer_revision.model.Technician;
import ec.edu.espe.schweitzer_revision.model.Order;
import ec.edu.espe.schweitzer_revision.model.Repair;
import ec.edu.espe.schweitzer_revision.model.SparePart;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Main {
    static int indice=0;
    static ArrayList<Client> clients = new ArrayList<Client>();
    static ArrayList<Technician> technicians = new ArrayList<Technician>();
    static ArrayList<SparePart> spareparts = new ArrayList<SparePart>();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
      start();
    }
    public static void start()
    {
        Scanner sn = new Scanner(System.in);
        boolean salir = false,salir2 = false;
        int opcion,opcion2; 
        Long opcion3;
        String opcion4;
        technicians.add(new Technician("Manuel",Long.valueOf("111111")));
        technicians.add(new Technician("Carol",Long.valueOf("101010")));
        technicians.add(new Technician("Roberto",Long.valueOf("121212")));
        technicians.add(new Technician("Juan",Long.valueOf("131313")));
        technicians.add(new Technician("Samuel",Long.valueOf("141414")));
        spareparts.add(new SparePart("Fuente de poder",14,"F1",15));
        spareparts.add(new SparePart("Disco Duro",30,"D1",15));
        spareparts.add(new SparePart("Pantalla",100,"P1",15));
        spareparts.add(new SparePart("Teclado",50,"T1",15));
        spareparts.add(new SparePart("Memoria Ram",20,"M1",15));
               
         while (!salir) {
            salir2=false;       
            System.out.println("1. Cliente opción 1");
            System.out.println("2. Tecnico Opción 2");
            System.out.println("3. Repuestos Opción 3");
            System.out.println("4. Salir");
 
            try {
 
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();
 
                switch (opcion) {
                    case 1:
                        menuDesicion();
                        break;
                    case 2:
                       
                           while (!salir2)
                           {
                                System.out.println("Ingrese ID , si desea salir presione 0");
                                opcion2 = sn.nextInt();
                                if(opcion2==0)
                                {
                                    salir2=true;
                                }
                                for (int i = 0; i < technicians.size(); i++) {
                                    if(technicians.get(i).getId()==opcion2)
                                    {
                                    if(technicians.get(i).getDisponibility()==0)
                                    {
                                    System.out.println("Bienvenid@: "+ technicians.get(i).getName()+
                                    " no tienes ordenes de trabajo");
                                    }
                                    if(technicians.get(i).getDisponibility()!=0)
                                    {
                                         System.out.println("Bienvenid@: "+ technicians.get(i).getName()+
                                     " La fecha de entrega es para :"+ technicians.get(i).getDisponibility());
                                    System.out.println("Orden Realizada(1), pendiente(2), provisional(3)");
                                    opcion2 = sn.nextInt(); 
                                    switch(opcion2){
                                        case 1:
                                            technicians.get(i).finishOrder();
                                            break;
                                        case 3:
                                            System.out.println("Ingrese nueva fecha de orden");
                                             opcion3 = sn.nextLong(); 
                                            technicians.get(i).updateOrder(opcion3);
                                            
                                     }
                                    
                                    }
                                    }
                               }
                               
                               
                           }
                           fillCSVClientes();
                            fillCSVTechnician();
                            fillCSVSparePart();
                        break;
                    case 3:
                        for (int i = 0; i < spareparts.size(); i++) {
                                    System.out.println(spareparts.get(i).listItem());
                               }
                               System.out.println("Ingrese codigo repuesto a usar: ");
                                             opcion4 = sn.next(); 
                               for (int i = 0; i < spareparts.size(); i++) {
                                   if(spareparts.get(i).getId().compareTo(opcion4)==0)
                                   {
                                       spareparts.get(i).updateQuantity();
                                   }
                               }
                                 
                             fillCSVClientes();
                            fillCSVTechnician();
                            fillCSVSparePart();
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }
    
    public static void menuDesicion(){
        int opcion;
        char answer;
        int cancel;
        do{
            do{
                  System.out.println("\nBienvenid@");
                  System.out.println("Digite la opción que desea realizar: ");
                  System.out.println("1. Agendar una Orden");
                  System.out.println("2. Cancelar una Orden");
                  opcion = input.nextInt();
            }while(opcion<1 || opcion>3);
            
            switch(opcion){
                case 1: 
                        reserveOrder();
                        fillCSVClientes();
                        fillCSVTechnician();
                        fillCSVSparePart();
                        break;
                case 2: 
                    System.out.println("Ingrese numero de cédula ");
                    cancel = input.nextInt();
                    for (int i = 0; i < clients.size(); i++) {
                         if (clients.get(i).getId()==cancel) {
                                clients.remove(i);
                                technicians.get(i).finishOrder();
                            } 
                    }
                    fillCSVClientes();
                    fillCSVTechnician();
                    fillCSVSparePart();
                    break;
                      
            }
            System.out.println("\nDesea realizar alguna otra actividad (s/n)");
            answer = input.next().charAt(0);
        }while(answer=='s' || answer=='S');
    }
    
    public static void reserveOrder(){
        fillDataOrder();
    }
    public static void fillDataTechnician()
    {
        
    }
    public static void fillCSVClientes(){
           try{
         
           
             CsvWriter  escribirUsuarios = new CsvWriter ("Clientes.csv");
   
            escribirUsuarios.write("name");
            escribirUsuarios.write("id");
            escribirUsuarios.write("adress");
            escribirUsuarios.write("phone");
            escribirUsuarios.write("newOrder");
            escribirUsuarios.endRecord(); 
             for(Client cliente : clients) {
                escribirUsuarios.write(cliente.getName());
                escribirUsuarios.write(Long.toString(cliente.getId()));
                escribirUsuarios.write(cliente.getAddress());
                escribirUsuarios.write(Long.toString(cliente.getPhone()));
                escribirUsuarios.write(cliente.getNewOrder().getDate());
                escribirUsuarios.write(cliente.getNewOrder().getAddress());
                escribirUsuarios.write(Integer.toString(cliente.getNewOrder().getId()));
                escribirUsuarios.write(cliente.getNewOrder().getDate());
               // escribirUsuarios.write(String.valueOf(cliente.getNewOrder().getType()));
                escribirUsuarios.write(cliente.getNewOrder().getDescription());
                escribirUsuarios.endRecord(); 
            }

            escribirUsuarios.close();

        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public static void fillCSVTechnician()
    {
        try{
         
           
             CsvWriter  escribirUsuarios = new CsvWriter ("Technician.csv");
   
            escribirUsuarios.write("name");
            escribirUsuarios.write("id");
            escribirUsuarios.write("disponibility");
             escribirUsuarios.write("status");
              escribirUsuarios.endRecord(); 
             for(Technician tecnicos : technicians) {
                escribirUsuarios.write(tecnicos.getName());
                escribirUsuarios.write(Long.toString(tecnicos.getId()));
                escribirUsuarios.write(Long.toString(tecnicos.getDisponibility()));
                escribirUsuarios.write(tecnicos.getStatus().getDescription());
                
                escribirUsuarios.endRecord(); 
            }
            
          
           
            escribirUsuarios.close();
        
            
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
       
    }
     public static void fillCSVSparePart()
    {
        try{
         
           
             CsvWriter  escribirUsuarios = new CsvWriter ("SpareParts.csv");
   
            escribirUsuarios.write("name");
            escribirUsuarios.write("price");
            escribirUsuarios.write("id");
             escribirUsuarios.write("quantity");
              escribirUsuarios.endRecord(); 
             for(SparePart partes : spareparts) {
                escribirUsuarios.write(partes.getName());
                escribirUsuarios.write(Float.toString(partes.getPrice()));
                escribirUsuarios.write(partes.getId());
                escribirUsuarios.write(Integer.toString(partes.getQuantity()));
                
                escribirUsuarios.endRecord(); 
            }
            
      
            escribirUsuarios.close();
        
            
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
       
    }
    public static void fillDataClient(Order order){
        String name;
        long id;
        String address;
        long phone;
        
        System.out.println("=================================");
        System.out.println("\tDatos del cliente");
        System.out.println("==================================");
        System.out.println("Ingrese su nombre:");
        input.nextLine();
        name = input.nextLine();
        System.out.println("Ingrese su número de C.I:");
        id = input.nextLong();
        System.out.println("Ingrese su número de teléfono:");
        phone = input.nextLong();
        System.out.println("Ingrese su dirección:");
        input.nextLine();
        address = input.nextLine();
        
        Client client = new Client(name, id, address, phone, order);
        clients.add(client);
        fillCSVClientes();             
        
            for (int i = 0; i < technicians.size(); i++) {
             technicians.get(i).setName(clients.get(indice).assignOrder(technicians.get(i)).getName());  
             technicians.get(i).setStatus(clients.get(indice).assignOrder(technicians.get(i)).getStatus()); 
             technicians.get(i).setId(clients.get(indice).assignOrder(technicians.get(i)).getId());
             technicians.get(i).setDisponibility(clients.get(indice).assignOrder(technicians.get(i)).getDisponibility()); 
             
             
         } 
         clients.get(0).contador0();   
         indice++;
        
         
        
    }
    
    public static void fillDataOrder(){
        String date;
        String address;
        char type;
        boolean priority;
        String description;
        char desicion;
        int numbOfSession = 0;
        Order order;
        
        System.out.println("=================================");
        System.out.println("\tDatos de la orden");
        System.out.println("==================================");
        System.out.println("Ingrese la fecha para su orden:");
        input.nextLine();
        date = input.nextLine();
        System.out.println("Ingrese la dirección de la orden:");
        address = input.nextLine();
        System.out.println("Ingrese la descripción de su orden:");
        description = input.nextLine();
        System.out.println("Ingrese el tipo de la orden: reparación(r)/mantenimiento(m):");
        type = input.next().charAt(0);
        
        if(type=='r' || type=='R'){
            System.out.println("¿Su reparación es de carácter urgente (s/n)?:");
            desicion=input.next().charAt(0);
            
            if(desicion=='s' || desicion =='S'){
                priority = true;
                 order = new Repair(priority, date, address, description);
                 fillDataClient(order);
            }
        }else{
            numbOfSession++;
            order = new Maintenance(numbOfSession, date, address, description);
            fillDataClient(order);
        }
    }
}


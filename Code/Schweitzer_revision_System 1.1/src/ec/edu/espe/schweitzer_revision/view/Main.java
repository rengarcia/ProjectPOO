/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.view;

import ec.edu.espe.schweitzer_revision.model.Client;
import ec.edu.espe.schweitzer_revision.model.Order;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class Main {
    
    static ArrayList<Client> clients = new ArrayList<Client>();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args){
      menuDesicion();
        
        
    }
    
    public static void menuDesicion(){
        int opcion;
        char answer;
        do{
            do{
                  System.out.println("\nBienvenid@");
                  System.out.println("Digite la opción que desea realizar: ");
                  System.out.println("1. Agendar una Orden");
                  System.out.println("2. Cancelar una Orden");
                  opcion = input.nextInt();
            }while(opcion<1 || opcion>2);
            
            switch(opcion){
                case 1: 
                        reserveOrder();
                case 2: //to do
            }
            
            System.out.println("\nDesea realizar alguna otra actividad (s/n)");
            answer = input.next().charAt(0);
        }while(answer=='s' || answer=='S');
    }
    
    public static void reserveOrder(){
        fillDataOrder();

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
    }
    
    public static void fillDataOrder(){
        String date;
        String address;
        char type;
        boolean priority = true;
        String description;
        char desicion;
        
        System.out.println("=================================");
        System.out.println("\tDatos de la orden");
        System.out.println("==================================");
        System.out.println("Ingrese la fecha para su orden:");
        input.nextLine();
        date = input.nextLine();
        System.out.println("Ingrese la dirección de la orden:");
        address = input.nextLine();
        System.out.println("Ingrese el tipo de la orden: reparación(r)/mantenimiento(m):");
        type = input.next().charAt(0);
        
        if(type=='r' || type=='R'){
            System.out.println("¿Su reparación es de carácter urgente (s/n)?:");
            desicion=input.next().charAt(0);
            
            if(desicion=='s' || desicion =='S'){
                priority = true;
            }else{
                priority = false;
            }
        }
        
        System.out.println("Ingrese la descripción de su orden:");
        input.nextLine();
        description = input.nextLine();
        
        Order order = new Order(date, address, type, priority, description);
        fillDataClient(order);
    }
    
}


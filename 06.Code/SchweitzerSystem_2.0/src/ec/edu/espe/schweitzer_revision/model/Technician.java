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
    public ArrayList<String> dates;
    ArrayList<String> orderId;

    public Technician(String name, String id, ArrayList<String> dates, ArrayList<String> orderId) {
        this.name = name;
        this.id = id;
        this.dates = dates;
        this.orderId = orderId;
    }

    public Technician() {

    }

    public boolean checkPassword(String technicianId, String passwordAttempt,
            String cipherFilePath) throws FileNotFoundException {

        boolean pass = false;

        FileManager dataLine = new FileManager();
        Gson gson = new Gson();

        String passwordLine = dataLine.parseFile(cipherFilePath, technicianId);
        Password password = gson.fromJson(passwordLine, Password.class);

        String actualPassword = dataLine.decrypt(password.getPassword());

        if (actualPassword.equals(passwordAttempt)) {
            pass = true;
        }

        return pass;
    }

    public void workStatus(String clientOrderFilePath, String technicianFilePath,
            String cipherPath, String technicianId)
            throws FileNotFoundException {

        Scanner scanner = new Scanner(System.in);
        String dataTechnician;
        FileManager dataLine = new FileManager();
        Gson gson = new Gson();

        dataTechnician = dataLine.parseFile(technicianFilePath, technicianId);
        Technician dataFromFileTechnician = gson.fromJson(dataTechnician, Technician.class);

        System.out.println("Bienvenido  " + dataFromFileTechnician.getName());

        System.out.println("\nEstos son las ordenes que tienes asignadas: ");
        System.out.println(dataFromFileTechnician.getOrderId());
        System.out.println("\nEn estas fechas: ");
        
        System.out.println(dataFromFileTechnician.dates);
        int tempOption;
        System.out.println("\n Escoja: ");
        System.out.println("1. Reparaciones");
        System.out.println("2. Mantenimeintos");
        System.out.println("3. Cambiar Contrseña");
        tempOption = scanner.nextInt();
        scanner.nextLine();

        switch (tempOption) {
            case 1: {
                System.out.println("\n Ingresa el id de la orden que deseas actualizar: ");
                String tempOderId = scanner.nextLine();
                Repair repair = new Repair();
                repair.updateOrder(clientOrderFilePath, tempOderId);
                break;
            }
            case 2: {
                System.out.println("\n Ingresa el id de la orden que deseas actualizar: ");
                String tempOderId = scanner.nextLine();
                Maintenance maintenance = new Maintenance();
                maintenance.updateOrder(clientOrderFilePath, tempOderId);
                break;
            }
            case 3: {
                System.out.println("Ingrese la nueva contraseña: ");
                String newPassword = scanner.nextLine();
                String encryptPassword = dataLine.encrypt(newPassword);

                String passwordLine = dataLine.parseFile(cipherPath, technicianId);
                Password password = gson.fromJson(passwordLine, Password.class);
                String currentPassword = password.getPassword();

                dataLine.modifyFile(cipherPath, currentPassword, encryptPassword);
                System.out.println("Contraseña actualizada");
            }
            default:
                break;
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

    /*public ArrayList<String> getDates() {
        return dates;
    }

    public void setDates(ArrayList<String> dates) {
        this.dates = dates;
    }*/
    public ArrayList<String> getOrderId() {
        return orderId;
    }

    public void setOrderId(ArrayList<String> orderId) {
        this.orderId = orderId;
    }
}

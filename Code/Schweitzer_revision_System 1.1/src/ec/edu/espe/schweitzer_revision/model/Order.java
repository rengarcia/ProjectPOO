/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.model;

/**
 *
 * @author Andres Garcia
 */
public class Order {
    private String date;
    private String address;
    private int id;
    private char type;
    private boolean priority;
    private String description;

    public Order(String date, String address, char type, boolean priority, String description) {
        this.date = date;
        this.address = address;
        this.type = type;
        this.priority = priority;
        this.description = description;
    }

    public void generateID(){
        // to do
    }
    
    public void setPriority(){
        // to do
    }
    
}

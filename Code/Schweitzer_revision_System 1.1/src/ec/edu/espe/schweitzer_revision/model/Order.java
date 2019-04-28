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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

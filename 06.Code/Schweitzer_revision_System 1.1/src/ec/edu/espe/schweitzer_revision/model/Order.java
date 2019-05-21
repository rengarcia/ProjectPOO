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
public abstract class Order {
    private String date;
    private String address;
    private static int id;
    private String description;
    private OrderStatus status;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
  
    public Order(String date, String address, int id, String description, OrderStatus status) {
        this.date = date;
        this.address = address;
        this.id = id;
        this.description = description;
        this.status = status;
    }

    public Order(String date, String address,String description) {
        this.date = date;
        this.address = address;
        this.description = description;
    }
    
    public abstract void generateID();
    public abstract void updateOrder();
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andres Garcia
 */
public class Client {
    private String name;
    private long id;
    private String address;
    private long phone;
    private Order newOrder;
    int contador=0,contador2=0;

    public Client(String name, long id, String address, long phone, Order newOrder) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.phone = phone;
        this.newOrder = newOrder;
    }

    public Technician assignOrder(Technician technician){

        if (contador==0) 
        {
                if(technician.getDisponibility()==0)
            {
                technician= new Technician(technician.getName(),technician.getId(),Long.valueOf(this.newOrder.getDate()),new OrderStatus(this.newOrder.getDescription(),this.newOrder.getType(),false));
                contador2++;
            }
        }
        if(contador2==4)
        {
            contador++;
        }
        return technician;
    }
    public void contador0()
    {
        contador=0;
        contador2=0;
    }
    public void cancelorder(){
        this.name = "0";
        this.id = 0;
        this.address = "0";
        this.phone = 0;
        this.newOrder = new Order("0","0","0".charAt(0),false,"0");
    }
    
    public void displaySparePartList(SparePart item){
        // to do
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Order getNewOrder() {
        return newOrder;
    }

    public void setNewOrder(Order newOrder) {
        this.newOrder = newOrder;
    }
    
}

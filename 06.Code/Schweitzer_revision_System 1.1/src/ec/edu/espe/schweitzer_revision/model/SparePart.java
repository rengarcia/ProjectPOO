/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.model;

/**
 *
 * @author Jhony Naranjo
 */
public class SparePart {
    private String name;
    private float price;
    private String id;
    private int quantity;

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public SparePart(String name, float price, String id, int quantity) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.quantity = quantity;
    }

    public void updateQuantity(){
       this.quantity--;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String listItem(){
        return "El producto "+ this.name +" tiene el valor de "+ this.price+ " con el id: "+ this.id+ " y se encuentra en stock: "+ this.quantity;
    }
}

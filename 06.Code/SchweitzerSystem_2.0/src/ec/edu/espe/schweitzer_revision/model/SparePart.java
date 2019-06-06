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
    private Float price;
    private int stock;

    public SparePart(String name, Float price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public SparePart() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return "Nombre -->" + name + ", Precio -->" + price + ", Stock -->" + stock;
    }
    
    
}

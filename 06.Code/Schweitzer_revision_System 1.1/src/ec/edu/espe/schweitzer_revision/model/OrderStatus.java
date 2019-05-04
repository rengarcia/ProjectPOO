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
public class OrderStatus {
    private String description;
    private char type;
    private boolean orderCompletionDate;

    public OrderStatus(String description, char type, boolean orderCompletionDate) {
        this.description = description;
        this.type = type;
        this.orderCompletionDate = orderCompletionDate;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOrderCompletionDate() {
        return orderCompletionDate;
    }

    public void setOrderCompletionDate(boolean orderCompletionDate) {
        this.orderCompletionDate = orderCompletionDate;
    }
    
}

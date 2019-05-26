/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.model;

/**
 *
 * @author David Lopez
 */
public class OrderStatus {
    private String description;
    private String orderCompletionDate;
    private String orderCompleted;

    public OrderStatus(String description, String orderCompletionDate, String orderCompleted) {
        this.description = description;
        this.orderCompletionDate = orderCompletionDate;
        this.orderCompleted = orderCompleted;
    }
    
    public OrderStatus(){        
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOrderCompletionDate() {
        return orderCompletionDate;
    }

    public void setOrderCompletionDate(String orderCompletionDate) {
        this.orderCompletionDate = orderCompletionDate;
    }

    public String getOrderCompleted() {
        return orderCompleted;
    }

    public void setOrderCompleted(String orderCompleted) {
        this.orderCompleted = orderCompleted;
    }
        
}

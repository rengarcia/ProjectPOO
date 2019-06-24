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

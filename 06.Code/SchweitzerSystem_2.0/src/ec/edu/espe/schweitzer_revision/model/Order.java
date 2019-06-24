package ec.edu.espe.schweitzer_revision.model;
import java.io.FileNotFoundException;

/**
 *
 * @author David Lopez
 */
public abstract class Order {
    Long date;
    private String address;
    String id;
    private String description;
    private OrderStatus status;
   
    
    public Order(){
        
    }

    public Order(Long date, String address, String id, String description, OrderStatus status) {
        this.date = date;
        this.address = address;
        this.id = id;
        this.description = description;
        this.status = status;
    }
    
    
    public abstract String generateID();
    
    public abstract void updateOrder(String clientOrderFilePath,String orderId) 
            throws FileNotFoundException;
    
    
    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    } 
}

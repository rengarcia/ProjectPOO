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

    public void build (Long date, String address, String description,
            int sessionNumber,Boolean type, Boolean flag){ 
        this.date = date;
        this.address = address;
        this.description = description;
        this.id=generateID();
        
        if(type){
            Priority(flag);
        }
        else if (type==false){
            SessionNumber(sessionNumber);
        }
        
        this.status= defaultStatus();
    }
    
    public abstract String generateID();
    
    public abstract void Priority(Boolean flag);
    
    public abstract void SessionNumber(int sessionNumber);
    
    public OrderStatus defaultStatus(){
        OrderStatus orderStatusData= new OrderStatus();
        orderStatusData.setDescription("null");
        orderStatusData.setOrderCompletionDate("null");
        orderStatusData.setOrderCompleted("null");
        
        return orderStatusData;
    }
    
    
    public abstract void updateOrder(String orderId) 
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

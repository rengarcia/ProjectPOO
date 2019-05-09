/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.model;
import java.util.List;
/**
 *
 * @author Jhony Naranjo
 */
public class Technician {
    private String name;
    private long id;
    public  Long disponibility;
    private OrderStatus status;

    


    public Technician(String name, Long id) {
        this.name = name;
        this.id = id;
        this.disponibility=Long.valueOf("0");
        this.status = new OrderStatus("No definido","0".charAt(0),false);
    }

    public Technician(String name, long id, Long disponibility, OrderStatus status) {
        this.name = name;
        this.id = id;
        this.disponibility = disponibility;
        this.status = status;
    }

    public Long getDisponibility() {
        return disponibility;
    }

    public void setDisponibility(Long disponibility) {
        this.disponibility = disponibility;
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



    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public void updateOrder(Long o){
        this.disponibility=o;
    }
    
    public void finishOrder(){
        this.disponibility=Long.valueOf("0");
        this.status = new OrderStatus("0","0".charAt(0),false);
    }
}

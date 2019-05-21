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
public class Repair extends Order {
    
    private boolean priority;

    public Repair(boolean priority, String date, String address, String description) {
        super(date, address, description);
        this.priority = priority;
    }

    @Override
    public void generateID() {
        // to do
    }

    @Override
    public void updateOrder() {
        // to do
    }

}

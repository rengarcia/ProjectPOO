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
public class Maintenance extends Order {
    private int session;

    public Maintenance(int session, String date, String address, String description) {
        super(date, address, description);
        this.session = session;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.model;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andres Garcia
 */
public class TechnicianTest {
    
    public TechnicianTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getDisponibility method, of class Technician.
     */
    @Test
    public void testGetDisponibility() {
        System.out.println("getDisponibility");
        Technician instance = null;
        Long expResult = null;
        Long result = instance.getDisponibility();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDisponibility method, of class Technician.
     */
    @Test
    public void testSetDisponibility() {
        System.out.println("setDisponibility");
        Long disponibility = null;
        Technician instance = null;
        instance.setDisponibility(disponibility);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Technician.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Technician instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Technician.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Technician instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Technician.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Technician instance = null;
        long expResult = 0L;
        long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Technician.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        long id = 0L;
        Technician instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Technician.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Technician instance = null;
        OrderStatus expResult = null;
        OrderStatus result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Technician.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        OrderStatus status = null;
        Technician instance = null;
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateOrder method, of class Technician.
     */
    @Test
    public void testUpdateOrder() {
        System.out.println("updateOrder");
        Long o = null;
        Technician instance = null;
        instance.updateOrder(o);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of finishOrder method, of class Technician.
     */
    @Test
    public void testFinishOrder() {
        System.out.println("finishOrder");
        Technician instance = null;
        instance.finishOrder();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

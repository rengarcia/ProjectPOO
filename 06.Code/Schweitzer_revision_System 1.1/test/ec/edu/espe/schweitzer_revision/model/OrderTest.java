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
public class OrderTest {
    
    public OrderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getDate method, of class Order.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Order instance = null;
        String expResult = "";
        String result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Order.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String date = "";
        Order instance = null;
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Order.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Order instance = null;
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class Order.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Order instance = null;
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Order.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Order instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Order.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Order instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Order.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Order instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Order.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Order instance = null;
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Order.
     */
    @Test
    public void testGetStatus() {
        System.out.println("getStatus");
        Order instance = null;
        OrderStatus expResult = null;
        OrderStatus result = instance.getStatus();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Order.
     */
    @Test
    public void testSetStatus() {
        System.out.println("setStatus");
        OrderStatus status = null;
        Order instance = null;
        instance.setStatus(status);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generateID method, of class Order.
     */
    @Test
    public void testGenerateID() {
        System.out.println("generateID");
        Order instance = null;
        instance.generateID();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateOrder method, of class Order.
     */
    @Test
    public void testUpdateOrder() {
        System.out.println("updateOrder");
        Order instance = null;
        instance.updateOrder();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class OrderImpl extends Order {

        public OrderImpl() {
            super("", "", "");
        }

        public void generateID() {
        }

        public void updateOrder() {
        }
    }
    
}

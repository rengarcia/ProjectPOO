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
public class OrderStatusTest {
    
    public OrderStatusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getType method, of class OrderStatus.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        OrderStatus instance = null;
        char expResult = ' ';
        char result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class OrderStatus.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        char type = ' ';
        OrderStatus instance = null;
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class OrderStatus.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        OrderStatus instance = null;
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class OrderStatus.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        OrderStatus instance = null;
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOrderCompletionDate method, of class OrderStatus.
     */
    @Test
    public void testIsOrderCompletionDate() {
        System.out.println("isOrderCompletionDate");
        OrderStatus instance = null;
        boolean expResult = false;
        boolean result = instance.isOrderCompletionDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOrderCompletionDate method, of class OrderStatus.
     */
    @Test
    public void testSetOrderCompletionDate() {
        System.out.println("setOrderCompletionDate");
        boolean orderCompletionDate = false;
        OrderStatus instance = null;
        instance.setOrderCompletionDate(orderCompletionDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

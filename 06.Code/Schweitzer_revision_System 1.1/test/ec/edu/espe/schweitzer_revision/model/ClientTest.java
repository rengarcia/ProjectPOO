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
public class ClientTest {
    
    public ClientTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of assignOrder method, of class Client.
     */
    @Test
    public void testAssignOrder() {
        System.out.println("assignOrder");
        Technician technician = null;
        Client instance = null;
        Technician expResult = null;
        Technician result = instance.assignOrder(technician);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contador0 method, of class Client.
     */
    @Test
    public void testContador0() {
        System.out.println("contador0");
        Client instance = null;
        instance.contador0();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cancelorder method, of class Client.
     */
    @Test
    public void testCancelorder() {
        System.out.println("cancelorder");
        Client instance = null;
        instance.cancelorder();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of displaySparePartList method, of class Client.
     */
    @Test
    public void testDisplaySparePartList() {
        System.out.println("displaySparePartList");
        SparePart item = null;
        Client instance = null;
        instance.displaySparePartList(item);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Client.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Client instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Client.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Client instance = null;
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Client.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Client instance = null;
        long expResult = 0L;
        long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Client.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        long id = 0L;
        Client instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Client.
     */
    @Test
    public void testGetAddress() {
        System.out.println("getAddress");
        Client instance = null;
        String expResult = "";
        String result = instance.getAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class Client.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Client instance = null;
        instance.setAddress(address);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone method, of class Client.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Client instance = null;
        long expResult = 0L;
        long result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhone method, of class Client.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        long phone = 0L;
        Client instance = null;
        instance.setPhone(phone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNewOrder method, of class Client.
     */
    @Test
    public void testGetNewOrder() {
        System.out.println("getNewOrder");
        Client instance = null;
        Order expResult = null;
        Order result = instance.getNewOrder();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNewOrder method, of class Client.
     */
    @Test
    public void testSetNewOrder() {
        System.out.println("setNewOrder");
        Order newOrder = null;
        Client instance = null;
        instance.setNewOrder(newOrder);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

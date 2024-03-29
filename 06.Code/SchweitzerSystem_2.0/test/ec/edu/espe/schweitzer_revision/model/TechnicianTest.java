/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.model;

import java.io.FileNotFoundException;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author Andres Garcia
 */
public class TechnicianTest {
       Technician th = new Technician();
    
    public TechnicianTest() {
    }

    @Test
    public void testcheckPasswordfirst() throws FileNotFoundException{
        boolean actual = th.checkPassword("30003" , "omega356");
        boolean expected = true;
        assertEquals(expected, actual);
    }
    @Test
    public void testcheckPasswordfalse() throws FileNotFoundException{
        boolean actual = th.checkPassword("30003" , "veritas");
        boolean expected = false;
        assertEquals(expected, actual);
    }
    
    @Test
    public void testcheckPasswordtechnician2() throws FileNotFoundException{
        boolean actual = th.checkPassword("30002" , "beta986");
        boolean expected = true;
        assertEquals(expected, actual);
    }
    
    @Test
    public void testcheckPasswordtechnician2false() throws FileNotFoundException{
        boolean actual = th.checkPassword("30002" , "ad aspera");
        boolean expected = false;
        assertEquals(expected, actual);
    }
    
    @Test
    public void testcheckPasswordtechnician4() throws FileNotFoundException{
        boolean actual = th.checkPassword("30004" , "pi9876");
        boolean expected = true;
        assertEquals(expected, actual);
    }
    @Test
    public void testcheckPasswordtechnician4false() throws FileNotFoundException{
        boolean actual = th.checkPassword("30004" , "indigo");
        boolean expected = false;
        assertEquals(expected, actual);
    }
    @Test
    public void testcheckPasswordtechnician5() throws FileNotFoundException{
        boolean actual = th.checkPassword("30005" , "fi9436");
        boolean expected = true;
        assertEquals(expected, actual);
    }
    @Test
    public void testcheckPasswordtechnician5false() throws FileNotFoundException{
        boolean actual = th.checkPassword("30005" , "abstract");
        boolean expected = false;
        assertEquals(expected, actual);
    }
    @Test(expected = java.lang.NullPointerException.class)
    public void testcheckPasswordinecistentechnician() throws FileNotFoundException{
        boolean actual = th.checkPassword("30001" , "pi9876");
    }
    @Test
    public void testcheckPasswordtechnician6() throws FileNotFoundException{
        boolean actual = th.checkPassword("30006" , "epsilon025");
        boolean expected = true;
        assertEquals(expected, actual);
    }
    @Test
    public void testcheckPasswordtechnician6false() throws FileNotFoundException{
        boolean actual = th.checkPassword("30006" , "gamma531");
        boolean expected = false;
        assertEquals(expected, actual);
    }
    @Test
    public void testcheckPasswordtechnician6false2() throws FileNotFoundException{
        boolean actual = th.checkPassword("30006" , "/)-.(");
        boolean expected = false;
        assertEquals(expected, actual);
    }
    @Test
    public void testcheckPasswordtechnician6true() throws FileNotFoundException{
        boolean actual = th.checkPassword("30006" , "holamundo");
        boolean expected = true;
        assertEquals(expected, actual);
    }
    @Test(expected = java.lang.NullPointerException.class)
    public void testcheckPasswordtechniciaanotherpath() throws FileNotFoundException{
        boolean actual = th.checkPassword("30006" , "holamundo");
    }
}

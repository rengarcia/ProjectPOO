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
        boolean actual = th.checkPassword("30002" , "jm|iA@>" , "Files/Cipher.txt");
        boolean expected = true;
        assertEquals(expected, actual);
    }
    
}

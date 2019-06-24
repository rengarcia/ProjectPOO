/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.schweitzer_revision.tests;

import ec.edu.espe.schweitzer_revision.controller.FileManager;
import ec.edu.espe.schweitzer_revision.model.SparePart;
import ec.edu.espe.schweitzer_revision.model.Technician;
import java.io.FileNotFoundException;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Andres Garcia
 */
public class TestsEncrypt {
    
    FileManager fm = new FileManager();
    Technician th = new Technician();
    SparePart sp = new SparePart();
    public TestsEncrypt() {
    }

    @Test
    public void testEncryptionStandar() {
        String actual = fm.encrypt("bravo16");
        String expected = "jzi~w9>";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionNumeric() {
        String actual = fm.encrypt("3821");
        String expected = ";@:9";
      assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionLetter() {
        String actual = fm.encrypt("alpha");
        String expected = "itxpi";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionLastAscii() {
        String actual = fm.encrypt("zw{}");
        String expected = "";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionSpecialCharacters() {
        String actual = fm.encrypt(":):(;)");
        String expected = "B1B0C1";
       assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionCapital() {
        String actual = fm.encrypt("GAMMA");
        String expected = "OIUUI";
       assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionSpanish() {
        String actual = fm.encrypt("óéíá");
        String expected = "òèìà";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionSentences() {
        String actual = fm.encrypt("lambda var");
        String expected = "tiujli(~iz";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionLetterSentences() {
        String actual = fm.encrypt("GRAND VILLE");
        String expected = "OZIVL(^QTTM";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus1() {
        String actual = fm.encryptforTest("Hola", 1);
        String expected = "Ipmb";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus1Numeric() {
        String actual = fm.encryptforTest("3821", 1);
        String expected = "4932";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus1Letter() {
        String actual = fm.encryptforTest("romeo", 1);
        String expected = "spnfp";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus1LastAscii() {
        String actual = fm.encryptforTest("zw{}",1);
        String expected = "{x|~";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus1SpecialCharacters() {
        String actual = fm.encryptforTest(":);):3",1);
        String expected = ";*<*;4";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus1Capital() {
        String actual = fm.encryptforTest("RHO",1);
        String expected = "SIP";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus1Spanish() {
        String actual = fm.encryptforTest("así",1);
        String expected = "btî";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus1Sentence() {
        String actual = fm.encryptforTest("buenos dias",1);
        String expected = "cvfopt!ejbt";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus1CapitalSentences() {
        String actual = fm.encryptforTest("BUENAS TARDES",1);
        String expected = "CVFOBT!UBSEFT";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus2() {
        String actual = fm.encryptforTest("Adios",2);
        String expected = "Cfkqu";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus2Numeric() {
        String actual = fm.encryptforTest("1956",2);
        String expected = "3;78";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus2Letter() {
        String actual = fm.encryptforTest("tango",2);
        String expected = "vcpiq";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus2LastAscii() {
        String actual = fm.encryptforTest("zw{}",2);
        String expected = "|y} ";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus2SpecialCharacters() {
        String actual = fm.encryptforTest(":);):2",2);
        String expected = "<+=+<4";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus2Capital() {
        String actual = fm.encryptforTest("ZOHAN",2);
        String expected = "\\QJCP";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus2Spanish() {
        String actual = fm.encryptforTest("así",2);
        String expected = "cuú";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus2Sentence() {
        String actual = fm.encryptforTest("buenos dias",2);
        String expected = "dwgpqu'fkcu"; //RESERVED "
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus2CapitalSentences() {
        String actual = fm.encryptforTest("BUENAS NOCHES",2);
        String expected = "DWGPCU'PQEJGU";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus3() {
        String actual = fm.encryptforTest("Deberes",3);
        String expected = "Ghehuhv";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus3Numeric() {
        String actual = fm.encryptforTest("1956",3);
        String expected = "4<89";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus3Letter() {
        String actual = fm.encryptforTest("argis",3);
        String expected = "dujlv";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus3LastAscii() {
        String actual = fm.encryptforTest("zwx|",3);
        String expected = "}z{ ";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus3SpecialCharacters() {
        String actual = fm.encryptforTest(":D;(:c",3);
        String expected = "=G>+=f";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus3Capital() {
            String actual = fm.encryptforTest("ACADEMIC",3);
        String expected = "DFDGHPLF";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus3Spanish() {
        String actual = fm.encryptforTest("así",3);
        String expected = "dvð";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus3Sentence() {
        String actual = fm.encryptforTest("buen dia",3);
        String expected = "exhq#gld"; //
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus3CapitalSentences() {
        String actual = fm.encryptforTest("BUENAS NOCHES",3);
        String expected = "EXHQDV#QRFKHV";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus4() {
        String actual = fm.encryptforTest("Deberes",4);
        String expected = "Hifiviw";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus4Numeric() {
        String actual = fm.encryptforTest("1953",4);
        String expected = "5=97";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus4Letter() {
        String actual = fm.encryptforTest("evkmw",4);
        String expected = "izoq{";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus4LastAscii() {
        String actual = fm.encryptforTest("zwx|",4);
        String expected = "~{|€";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus4SpecialCharacters() {
        String actual = fm.encryptforTest(":D;(:c",4);
        String expected = ">H?,>g";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus4Capital() {
            String actual = fm.encryptforTest("REAL",4);
        String expected = "VIEP";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus4Spanish() {
        String actual = fm.encryptforTest("así",4);
        String expected = "ewñ";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus4Sentence() {
        String actual = fm.encryptforTest("buena semana",4);
        String expected = "fyire$wiqere"; //
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus4CapitalSentences() {
        String actual = fm.encryptforTest("BUENAS TARDES",4);
        String expected = "FYIREW$XEVHIW";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus5() {
        String actual = fm.encryptforTest("Pruebas",5);
        String expected = "Uwzjgfx";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus5Numeric() {
        String actual = fm.encryptforTest("1719026187",5);
        String expected = "6<6>57;6=<";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus5Letter() {
        String actual = fm.encryptforTest("song",5);
        String expected = "xtsl";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus5LastAscii() {
        String actual = fm.encryptforTest("zwy{",5);
        String expected = "|~€";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus5SpecialCharacters() {
        String actual = fm.encryptforTest(":D;(:c",5);
        String expected = "?I@-?h";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus5Capital() {
            String actual = fm.encryptforTest("IMAGINE",5);
        String expected = "NRFLNSJ";
        assertEquals(expected,actual);
    }
     @Test
    public void testEncryptionplus5Spanish() {
        String actual = fm.encryptforTest("así",5);
        String expected = "fxò";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus5Sentence() {
        String actual = fm.encryptforTest("buen mes",5);
        String expected = "gzjs%rjx"; //
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionplus5CapitalSentences() {
        String actual = fm.encryptforTest("BUENAS NOCHES",5);
        String expected = "GZJSFX%STHMJX";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless5CapitalSentences() {
        String actual = fm.decryptforTest("GZJSFX%STHMJX",5);
        String expected = "BUENAS NOCHES";
        assertEquals(expected,actual);
    }
     @Test
    public void testdecryptless5Sentence() {
        String actual = fm.decryptforTest("gzjs%rjx",5);
        String expected = "buen mes" ; //
        assertEquals(expected,actual);
    }
     @Test
    public void testdecryptless5Spanish() {
        String actual = fm.decryptforTest("fxò",5);
        String expected = "así";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless5Capital() {
            String actual = fm.decryptforTest("NRFLNSJ",5);
        String expected = "IMAGINE";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless5SpecialCharacters() {
        String actual = fm.decryptforTest("?I@-?h",5);
        String expected = ":D;(:c";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptionpless5LastAscii() {
        String actual = fm.decryptforTest("|~€",5);
        String expected = "zwy{" ;
        assertEquals(expected,actual);
    }
    @Test
    public void testdescryptionless5Letter() {
        String actual = fm.decryptforTest("xtsl",5);
        String expected = "song";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless5Numeric() {
        String actual = fm.decryptforTest("6<6>57;6=<",5);
        String expected = "1719026187";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptionless5() {
        String actual = fm.decryptforTest("Uwzjgfx",5);
        String expected = "Pruebas" ;
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptionless4CapitalSentences() {
        String actual = fm.decryptforTest("FYIREW$XEVHIW",4);
        String expected = "BUENAS TARDES";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless4Sentence() {
        String actual = fm.decryptforTest("fyire$wiqere",4);
        String expected =  "buena semana"; 
        assertEquals(expected,actual);
    }
     @Test
    public void testdecryptless4Spanish() {
        String actual = fm.decryptforTest("ewñ",4);
        String expected = "así";
      assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless4Capital() {
        String actual = fm.decryptforTest("VIEP",4);
        String expected = "REAL";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless4SpecialCharacters() {
        String actual = fm.decryptforTest(">H?,>g",4);
        String expected = ":D;(:c";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless4LastAscii() {
        String actual = fm.decryptforTest("~{|€",4);
        String expected = "zwx|";
      assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless4Letter() {
        String actual = fm.decryptforTest("izoq{",4);
        String expected = "evkmw";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless4Numeric() {
        String actual = fm.decryptforTest("5=97",4);
        String expected = "1953";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless4() {
        String actual = fm.decryptforTest("Hifiviw",4);
        String expected = "Deberes";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless3CapitalSentences() {
        String actual = fm.decryptforTest("EXHQDV#QRFKHV",3);
        String expected = "BUENAS NOCHES";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless3Sentence() {
        String actual = fm.decryptforTest("exhq#gld",3);
        String expected = "buen dia"; //
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless3Spanish() {
        String actual = fm.decryptforTest("dvð" ,3);
        String expected = "así";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless3Capital() {
            String actual = fm.decryptforTest("DFDGHPLF",3);
        String expected = "ACADEMIC";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless3SpecialCharacters() {
        String actual = fm.decryptforTest("=G>+=f",3);
        String expected =  ":D;(:c";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless3LastAscii() {
        String actual = fm.decryptforTest("(}z{",3);
        String expected = "zwx|" ;
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless3Letter() {
        String actual = fm.decryptforTest("dujlv",3);
        String expected = "argis";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless3Numeric() {
        String actual = fm.decryptforTest("4<89",3);
        String expected = "1956";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless3() {
        String actual = fm.decryptforTest("Ghghuhv" ,3);
        String expected = "Dederes";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless2CapitalSentences() {
        String actual = fm.decryptforTest("DWGPCU˝PQEJGU",2);
        String expected = "BUENAS.NOCHES";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless2Sentence() {
        String actual = fm.decryptforTest("dwgpqu¨fkcu",2);
        String expected =  "buenos¦dias"; //RESERVED "
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless2Spanish() {
        String actual = fm.decryptforTest("cuú",2);
        String expected = "asø";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless2Capital() {
        String actual = fm.decryptforTest("IQJCP",2);
        String expected = "GOHAN";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless2SpecialCharacters() {
        String actual = fm.decryptforTest("<+=+<4",2);
        String expected = ":);):2";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless2LastAscii() {
        String actual = fm.decryptforTest("|y} ",2);
        String expected =  "zw{}";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless2Letter() {
        String actual = fm.decryptforTest("vcpiq",2);
        String expected =  "tango";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless2Numeric() {
        String actual = fm.decryptforTest("3;78",2);
        String expected = "1956";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptionless2() {
        String actual = fm.decryptforTest("Cfkqu",2);
        String expected =  "Adios";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless1CapitalSentences() {
        String actual = fm.decryptforTest("CVFOBT!UBSEFT",1);
        String expected = "BUENAS TARDES";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionless1Sentence() {
        String actual = fm.decryptforTest("cvfopt!ejbt" ,1);
        String expected = "buenos dias";
        assertEquals(expected,actual);
    }
    @Test
    public void testEncryptionpless1Spanish() {
        String actual = fm.decryptforTest("btî",1);
        String expected = "así" ;
        assertEquals(expected,actual);
    }
    
    @Test
    public void tesdencryptless1Capital() {
        String actual = fm.decryptforTest("SIP",1);
        String expected = "RHO" ;
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless1SpecialCharacters() {
        String actual = fm.decryptforTest(";*<*;4",1);
        String expected = ":);):3";
        assertEquals(expected,actual);
    }
    @Test
    public void tesdecryptess1Letter() {
        String actual = fm.decryptforTest("spnfp", 1);
        String expected = "romeo" ;
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless1Numeric() {
        String actual = fm.decryptforTest("4932", 1);
        String expected = "3821" ;
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptless1() {
        String actual = fm.decryptforTest("Ipmb", 1);
        String expected =  "Hola";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptionLetterSentences() {
        String actual = fm.decrypt( "OZIVL(^QTTM");
        String expected = "GRAND VILLE";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptSentences() {
        String actual = fm.decrypt("tiujli(~iz");
        String expected =  "lambda var";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptSpanish() {
        String actual = fm.decrypt("òèìà");
        String expected = "óéíá" ;
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptCapital() {
        String actual = fm.decrypt("OIUUI");
        String expected =  "GAMMA";
       assertEquals(expected,actual);
    }
    @Test
    public void testdecryptSpecialCharacters() {
        String actual = fm.decrypt("B1B0C1");
        String expected =  ":):(;)";
       assertEquals(expected,actual);
    }
     @Test
    public void testdecryptionLetter() {
        String actual = fm.decrypt("itxpi");
        String expected =  "alpha";
        assertEquals(expected,actual);
    }
    @Test
    public void testdecryptionNumeric() {
        String actual = fm.decrypt(";@:9");
        String expected =  "3821";
      assertEquals(expected,actual);
    }
    @Test
    public void testdecryptionStandar() {
        String actual = fm.decrypt("jzi~w9>");
        String expected =  "bravo16";
        assertEquals(expected,actual);
    }
    @Test
    public void testcheckPassword() throws FileNotFoundException{
        boolean actual = th.checkPassword("30001" , "hi" , "Files/Cipher.txt");
        boolean expected = false;
        assertEquals(expected, actual);
    }
   
    
}

package ü1a1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import java.util.Random;

public class PaarTest {

    Paar<Integer, Integer> paarInteger;
    Paar<String, String> paarString;
    Paar<Integer, String> paarIntegerString;

    Integer inputInteger = 43;
    Integer inputInteger2 = 55;
    String inputString = "43";
    String inputString2 = "abc";

    @BeforeEach
    void setup() {
        paarInteger = new Paar<>(inputInteger, inputInteger2);
        paarString = new Paar<>(inputString, inputString2);
        paarIntegerString = new Paar<>(inputInteger, inputString);
    }

    @AfterEach
    void teardown() {
        paarInteger = null;
        paarString = null;
        paarIntegerString = null;
    }

    @Test
    void testSetGetErstes() {
        paarInteger.setErstes(inputInteger);
        paarString.setErstes(inputString);
        assertEquals(inputInteger, paarInteger.getErstes(), "setErstes Fehler");
        assertEquals(inputString, paarString.getErstes(), "setErstes Fehler");
    }

    @Test
    void testSetGetZweites() {
        paarInteger.setZweites(inputInteger);
        paarString.setZweites(inputString);
        assertEquals(inputInteger, paarInteger.getZweites(), "setZweites Fehler");
        assertEquals(inputString, paarString.getZweites(), "setZweites Fehler");
    }

    @Test
    void testSetBeide() {
        paarInteger.setBeide(inputInteger, inputInteger2);
        paarString.setBeide(inputString, inputString2);
        paarIntegerString.setBeide(inputInteger, inputString);
        assertEquals(inputInteger, paarInteger.getErstes(), "setBeide Fehler");
        assertEquals(inputInteger2, paarInteger.getZweites(), "setBeide Fehler");
        assertEquals(inputString, paarString.getErstes(), "setBeide Fehler");
        assertEquals(inputString2, paarString.getZweites(), "setBeide Fehler");
        assertEquals(inputInteger, paarIntegerString.getErstes(), "setBeide Fehler");
        assertEquals(inputString, paarIntegerString.getZweites(), "setBeide Fehler");
    }

    @Test
    void testEquals() {
        paarInteger.setBeide(inputInteger, inputInteger);
        paarString.setBeide(inputString, inputString);
        paarIntegerString.setBeide(inputInteger, inputString);
        assertEquals(paarInteger, paarInteger);
        assertEquals(paarString, paarString);
        assertEquals(paarIntegerString, paarIntegerString);
    }

    @Test
    void testToString() {
        paarInteger.setBeide(23, 43);
        paarString.setBeide("ab", "xy");
        assertEquals("(23,43)", paarInteger.toString(), "toString Fehler");
        assertEquals("(ab,xy)", paarString.toString(), "toString Fehler");

    }
}

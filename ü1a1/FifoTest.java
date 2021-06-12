package ü1a1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class FifoTest {
    Fifo f = null;
    Lifo l = null;
    Fifo f2 = null;
    Lifo l2 = null;
    static Integer[] ai = {1,2,3,4,5};
    static Integer[] ia = {5,4,3,2,1};
    static String[] inputString = {"a", "b", "c", "d", "e"};
    static boolean[] inputBoolean = {true, false, true, true, false};

    @BeforeEach
    void setup() {
        f = new Fifo(5);
        f2 = new Fifo(5);
        l = new Lifo(5);
        l2 = new Lifo(5);
    }

    @AfterEach
    void teardown() {
        f = null;
        l = null;
        f2 = null;
        l2 = null;
    }

    @Test
    void testFifoInputString() {
        for(int i = 0; i < f.capacity(); i++) {
            f.push(inputString[i]);
            assertEquals(inputString[i], f.pop(), "String klappt nicht LULWXD KEKW");
        }
    }

    @Test
    void testFifoInputBoolean() {
        for(int i = 0; i < f.capacity(); i++) {
            f.push(inputBoolean[i]);
            assertEquals(inputBoolean[i], f.pop(), "String klappt nicht LULWXD KEKW");
        }
    }

    @Test
    void testLifoInputString() {
        for(int i = 0; i < l.capacity(); i++) {
            l.push(inputString[i]);
            assertEquals(inputString[i], l.pop(), "String klappt nicht LULWXD KEKW");
        }
    }

    @Test
    void testLifoInputBoolean() {
        for(int i = 0; i < l.capacity(); i++) {
            l.push(inputBoolean[i]);
            assertEquals(inputBoolean[i], l.pop(), "String klappt nicht LULWXD KEKW");
        }
    }

    @Test
    void testRandomFifoPog() {
        int largestNumber = Integer.MIN_VALUE;
        int smallestNumber = Integer.MAX_VALUE;
        for(int i = 0; i < 1000; i++) {
            f = new Fifo();
            assertTrue(3 <= f.capacity() && f.capacity() <= 100);
            if(f.capacity() < smallestNumber){
                smallestNumber = f.capacity();
            }
            if(f.capacity() > largestNumber){
                largestNumber = f.capacity();
            }
        }
        assertEquals(3, smallestNumber, "kleinste zahl != 3");
        assertEquals(100, largestNumber, "groesste Zahl != 100");
    }

    @Test
    void testRandomLifoPog() {
        int kleinsteZahl = Integer.MAX_VALUE;
        int groessteZahl = Integer.MIN_VALUE;
        for(int i = 0; i < 1000; i++) {
            l = new Lifo();
            assertTrue(3 <= l.capacity() && l.capacity() <= 100);
            if(l.capacity() < kleinsteZahl){
                kleinsteZahl = l.capacity();
            }
            if(l.capacity() > groessteZahl){
                groessteZahl = l.capacity();
            }
        }
        assertEquals(3, kleinsteZahl, "kleinste zahl != 3");
        assertEquals(100, groessteZahl, "groesste Zahl != 100");
    }

    @Test
    void testPushPopFifo() {
        for(Integer i:ai) {
            f.push(i);
            assertEquals(i, f.pop(), "pop() Fehler");
        }
    }

    @Test
    void testPushPopLifo() {
        for(Integer i:ai) {
            l.push(i);
            assertEquals(i, l.pop(), "pop() Fehler");
        }
    }

    @Test
    void testSizeCapacityFifo() {
        int s = 0;
        for(Integer i:ai) {
            assertEquals(f.size(), s, "Size wrong");
            assertEquals(f.capacity(), f.array.length, "f.array.length ist falsch");
            f.push(i);
            s++;
        }
    }

    @Test
    void testSizeCapacityLifo() {
        int s = 0;
        for(Integer i:ai) {
            assertEquals(l.size(), s, "Size wrong");
            assertEquals(l.capacity(), l.array.length, "f.array.length ist falsch");
            l.push(i);
            s++;
        }
    }

    @Test
    void testPopOrderLifo() {
        for(Integer i : ai) {
            l.push(i);
        }
        for(Integer i : ia) {
            assertEquals(l.pop(), i, "testPopOrderLifo");
        }
    }

    @Test
    void testPopOrderFifo() {
        for(Integer i : ai) {
            f.push(i);
        }
        for(Integer i : ai) {
            assertEquals(f.pop(), i, "testPopOrderLifo");
        }
    }

    @Test
    void moveTestFifoLifo() {
        for(Integer i : ai) {
            f.push(i);
        }
        Helper.move(f, l);
        for(Integer i : ia) {
            assertEquals(l.pop(), i, "moveTestFifoLifo Fehler");
        }
    }

    @Test
    void moveTestLifoFifo() {
        for(Integer i : ai) {
            l.push(i);
        }
        Helper.move(l, f);
        for(Integer i : ia) {
            assertEquals(f.pop(), i, "moveTestLifoFifo Fehler");
        }
    }

    @Test
    void moveTestFifoFifo() {
        for(Integer i : ai) {
            f.push(i);
        }
        Helper.move(f, f2);
        for(Integer i : ai) {
            assertEquals(f2.pop(), i, "moveTestFifoFifo");
        }
    }

    @Test
    void moveTestLifoLifo() {
        for(Integer i : ai) {
            l.push(i);
        }
        Helper.move(l, l2);
        for(Integer i : ai) {
            assertEquals(l2.pop(), i, "moveTestLifoLifo");
        }
    }
}
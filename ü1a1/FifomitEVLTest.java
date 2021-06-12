package ü1a1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class FifomitEVLTest<T> {

    FifomitEVL<Integer> f = new FifomitEVL<>();
    Integer[] zahlen = new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    @BeforeEach
    void setup() {
        for(Integer integer : zahlen) {
            f.push(integer);
        }
    }

    @AfterEach
    void teardown() {
        for(int i = 0; i < f.size(); i++) {
            f.pop();
        }
    }

    @Test
    void testPushPop() {
        f.push(300);
        for(int i = 0; i < 10; i++) {
            assertEquals(i, f.pop(), "push/pop fehler!");
        }
        assertEquals(300, f.pop(), "lulw");
    }

    @Test
    void testPeek() {
        for(int i = 0; i < f.size(); i++) {
            f.pop();
        }
        for(int i = 0; i < 10; i++) {
            f.push(i);
            assertEquals(i, f.peek(), "ich hasse es so sehr");
        }
    }

    @Test
    void testIsEmpty() {
        assertFalse(f.isEmpty());
        while(f.size() != 0){
            f.pop();
        }
        assertTrue(f.isEmpty());
    }
}

package ü1a1;

import java.util.Random;

public class Fifo<T> extends AbstractBuffer<T> {

    public Fifo(int s) {
        super(s);
    }

    public Fifo() {
        super();
    }

    public T pop() {
        if(size == 0) throw new ArrayIndexOutOfBoundsException();

        T x = array[0];
        for(int i = 0; i <= size - 2; i++) {
            array[i] = array[i + 1];
        }
        --size;
        return x;
    }
}
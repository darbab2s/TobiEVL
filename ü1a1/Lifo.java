package ü1a1;

import java.util.Random;

public class Lifo<T> extends AbstractBuffer<T> {

    public Lifo(int s) {
        super(s);
    }

    public Lifo() {
        super();
    }

    public T pop() {
        if(size == 0) throw new ArrayIndexOutOfBoundsException();
        return array[--size];
    }
}
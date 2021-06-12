package ü1a1;

import java.util.Random;

abstract class AbstractBuffer<T> implements Buffer<T> {

    protected int size = 0;
    protected T[] array;

    public AbstractBuffer(int s) {
        if(s < 0) throw new IllegalArgumentException();
        array = (T[]) new Object[s];
    }

    public AbstractBuffer() {
        array = (T[]) new Object[new Random().nextInt(98) + 3];
    }

    public void push(T i) {
        if(size >= capacity()) throw new ArrayIndexOutOfBoundsException();
        array[size++] = i;
    }

    public int capacity() {
        return array.length;
    }

    public int size() {
        return size;
    }

}
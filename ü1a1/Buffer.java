package ü1a1;

public interface Buffer<T> {

    void push(T i) throws ArrayIndexOutOfBoundsException;
    T pop() throws ArrayIndexOutOfBoundsException;
    int size();
    int capacity();
}
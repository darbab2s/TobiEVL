package ü1a1;

public interface FifoIF<T> {

    public void push(T e);
    public T pop();
    public T peek();
    public int size();
    public boolean isEmpty();
}

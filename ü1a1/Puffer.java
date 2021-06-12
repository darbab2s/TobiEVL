package ü1a1;

public interface Puffer<T> extends Iterable<T> {

    void insert(T e);
    void remove();
    int size();
    boolean isEmpty();
}

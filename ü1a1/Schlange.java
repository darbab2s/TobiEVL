package ü1a1;

public interface Schlange<T> extends Puffer<T> {

    T first();
    void insert(T e);
    void remove();

}

package ü1a1;

import java.util.NoSuchElementException;

public interface Folge<T> extends Puffer<T> {

    T get(int pos);
    void set(int pos, T e) throws NoSuchElementException;
    void remove(int pos) throws NoSuchElementException;
    void remove() throws UnsupportedOperationException;
    void insert(int pos, T e) throws NoSuchElementException;
    void insert(T e) throws UnsupportedOperationException;

}

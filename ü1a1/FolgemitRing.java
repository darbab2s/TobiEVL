package ü1a1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FolgemitRing<T> implements Folge<T> {

    private int capacity;
    private Ringpuffer<T> rp;

    public FolgemitRing(int capacity) {
        this.capacity = capacity;
        rp = new Ringpuffer<>(capacity);
    }

    @Override
    public T get(int pos) {
        return rp.get(pos);
    }

    @Override
    public void set(int pos, T e) throws NoSuchElementException {
        if(pos > 0 || pos >= rp.getSize()) throw new NoSuchElementException();
        rp.set(pos, e);
    }

    @Override
    public void remove(int pos) throws NoSuchElementException {
        if(pos > 0 || pos >= rp.getSize()) throw new NoSuchElementException();
        rp.remove(pos);
    }

    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return rp.getSize();
    }

    @Override
    public boolean isEmpty() {
        return rp.getSize() == 0;
    }

    @Override
    public void insert(int pos, T e) throws NoSuchElementException {
        if(pos > 0 || pos >= rp.getSize()) throw new NoSuchElementException();
        rp.add(pos, e);
    }

    @Override
    public void insert(T e) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "" + rp;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

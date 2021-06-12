package ü1a1;

import java.util.Iterator;

public class SchlangemitRing<T> implements Schlange<T> {

    private int capacity;
    Ringpuffer<T> rp;

    public SchlangemitRing(int capacity) {
        this.capacity = capacity;
        rp = new Ringpuffer<>(capacity);
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
    public T first() {
        T x = rp.removeFirst();
        rp.addFirst(x);
        return x;
    }

    @Override
    public void insert(T e) {
        rp.addLast(e);
    }

    @Override
    public void remove() {
        rp.removeFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}

package ü1a1;

import java.util.Iterator;

public class SchlangemitDynArray<T> implements Schlange<T> {

    private int capacity;
    private DynArray<T> dyn;

    public SchlangemitDynArray(int capacity) {
        this.capacity = capacity;
        dyn = new DynArray<>(capacity);
    }

    @Override
    public int size() {
        return dyn.getSize();
    }

    @Override
    public boolean isEmpty() {
        return dyn.getSize() == 0;
    }

    @Override
    public T first() {
        return dyn.get(0);
    }

    @Override
    public void insert(T e) {
        dyn.addLast(e);
    }

    @Override
    public void remove() {
        dyn.removeFirst();
    }

    @Override
    public Iterator<T> iterator() {
        return dyn.iterator();
    }
}

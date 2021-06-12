package ü1a1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FolgemitEVL<T> implements Folge<T> {

    private EVL<T> evl = new EVL<>();

    @Override
    public T get(int pos) {
        return null;
    }

    @Override
    public void set(int pos, T e) throws NoSuchElementException {
        evl.remove(pos);
        evl.add(pos, e);
    }

    @Override
    public void remove(int pos) throws NoSuchElementException {
        evl.remove(pos);
    }

    @Override
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return evl.size();
    }

    @Override
    public boolean isEmpty() {
        return evl.size() == 0;
    }

    @Override
    public void insert(int pos, T e) throws NoSuchElementException {
        if(pos == 0) evl.addLast(e);
        else evl.add(pos, e);
    }

    @Override
    public void insert(T e) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return "" + evl;
    }

    @Override
    public Iterator<T> iterator() {
        return evl.iterator();
    }
}

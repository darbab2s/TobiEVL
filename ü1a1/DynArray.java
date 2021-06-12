package ü1a1;

import java.util.Iterator;

public class DynArray<T> implements Iterable<T> {

    private int size = 0;
    private int capacity;
    private T[] data;
    private int cursor = 0;

    public DynArray(int capacity) {
        this.capacity = capacity;
        data = (T[]) new Object[capacity];
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public T get(int pos) {
        if(pos > size + 1) throw new ArrayIndexOutOfBoundsException();
        return data[pos];
    }

    public T set(int pos, T e) {
        T x = data[pos];
        data[pos] = e;
        return x;
    }

    public void addFirst(T e) {
        int a = size;
        if(size == capacity) increase();
        if(this.size == 0) data[size++] = e;
        else {
            T[] newData = (T[]) new Object[capacity];
            newData[0] = e;
            size = 1;
            for(int i = 0; i < a; i++) {
                newData[size++] = data[i];
            }
            data = newData;
        }
    }

    public void addLast(T e) {
        if(size == capacity) increase();
        data[size++] = e;
    }

    public void removeFirst() {
        T[] newData = (T[]) new Object[capacity];
        int a = size;
        size = 0;
        for(int i = 1; i < a; i++) {
            newData[size++] = data[i];
        }
        data = newData;
        if((double) size / (double) capacity <= 0.25) decrease();
    }

    public void removeLast() {
        T[] newData = (T[]) new Object[capacity];
        int a = size - 1;
        size = 0;
        for(int i = 0; i < a; i++) {
            newData[size++] = data[i];
        }
        data = newData;
        if((double) size / (double) capacity <= 0.25) decrease();
    }

    public void increase() {
        capacity *= 2;
        T[] newData = (T[]) new Object[capacity];
        size = 0;
        for(T e:data) newData[size++] = e;
        data = newData;
    }

    public void decrease() {
        capacity /= 2;
        T[] newData = (T[]) new Object[capacity];
        int a = size;
        size = 0;
        for(int i = 0; i < a; i++) {
            newData[size++] = data[i];
        }
        data = newData;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return cursor < capacity - 1;
            }

            @Override
            public T next() {
                return data[cursor++];
            }
        };
    }

    public String toString() {
        String s = "{";
        for(int i = 0; i < this.getSize(); i++) {
            if(i != size - 1) s = s + data[i] + ",";
            else s = s + data[i];
        }
        return s + "}";
    }


}
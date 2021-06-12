package ü1a1;

import java.util.Iterator;

public class Ringpuffer<T>  {

    private int size;
    private final int CAPACITY;
    private int vorne = -1;
    private int hinten = -1;
    private T[] data;
    private int cursor = 0;

    public Ringpuffer(int capacity) {
        this.CAPACITY = capacity;
        data = (T[]) new Object[this.CAPACITY];
    }

    public int getSize() {
        return size;
    }

    public T get(int pos) {
        int x;

        if(pos > size - 1) throw new IllegalArgumentException();
        if(vorne + pos > CAPACITY) x = vorne + pos - CAPACITY;
        else x = vorne + pos;

        return data[x];
    }

    public T set(int pos, T e) {
        int x;
        T y;
        if(pos > size - 1) throw new IllegalArgumentException();
        if(vorne + pos > CAPACITY) x = vorne + pos - CAPACITY;
        else x = vorne + pos;
        y = data[x];
        data[x] = e;
        return y;
    }

    public void addFirst(T e) {
        if(size == CAPACITY) throw new ArrayIndexOutOfBoundsException();
        else if(vorne == -1) {
            data[0] = e;
            vorne++;
            hinten++;
        } else if(vorne == 0) {
            data[CAPACITY - 1] = e;
            vorne = CAPACITY - 1;
        } else {
            data[vorne - 1] = e;
            vorne--;
        }
        size++;
    }

    public void addLast(T e) {
        if(size == CAPACITY) throw new ArrayIndexOutOfBoundsException();
        else if(hinten == -1) {
            data[0] = e;
            vorne++;
            hinten++;
        } else if(hinten == CAPACITY - 1) {
            data[0] = e;
            hinten = 0;
        } else {
            data[++hinten] = e;
        }
        size++;
    }

    //fehler lulw
    public void add(int pos, T e) {
        if(pos == vorne) {
            data[--vorne] = e;
        } else if(pos == hinten) {
            data[hinten++] = e;
        } else {
            T[] newData = (T[]) new Object[CAPACITY];
            for(int i = 0; i < pos - vorne; i++) {
                newData[vorne-- + i] = data[vorne + i];
            }
            for(int i = 0; i < hinten - pos; i++) {
                newData[pos + i] = data[pos + i];
            }
            newData[pos] = e;
            data = newData;
        }
    }

    public T removeFirst() {
        T x = data[vorne];
        if(vorne == CAPACITY - 1) vorne = 0;
        else vorne++;
        return x;
    }

    public T removeLast() {
        T x = data[hinten];
        if(hinten == 0) hinten = CAPACITY - 1;
        else hinten--;
        return x;
    }

    //fehler lulw
    public T remove(int pos) {
        T x = data[vorne + pos];
        if(vorne + pos == hinten) hinten--;
        else if(vorne + pos == vorne) vorne++;
        else {
            T[] newData = (T[]) new Object[CAPACITY];
            for(int i = 0; i < pos - vorne; i++) {
                newData[vorne + i] = data[vorne + i];
            }
            for(int i = 0; i < hinten - pos; i++) {
                newData[pos + i] = data[pos + i];
            }
            data = newData;
        }
        return x;
    }

    public String toString() {
        String s = "{";
        for(int i = 0; i < CAPACITY; i++) {
            s = s + data[i] + ",";
        }
        return s + "}";
    }
}

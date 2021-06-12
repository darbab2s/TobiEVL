package ü1a1;

public class RDVL<T> {

    Element entry = new Element(null);
    private int size = 0;

    class Element {
        T data;
        Element next = null;
        Element prev = null;

        Element(T data) {
            this.data = data;
        }
    }

    public boolean isEmpty() {
        return entry.next == null;
    }

    public int size() {
        return size;
    }

    public void add(T o) {
        Element e = new Element(o);
        Element tmp;

        if(size == 0) {
            entry.next = e;
        } else {
            tmp = entry.next;
            for(int i = 0; i < this.size() - 1; i++) {
                tmp = tmp.next;
            }
            tmp.next = e;
            e.prev = tmp;
            e.next = entry.next;
            tmp = entry.next;
            tmp.prev = e;
        }
        size++;
    }

    public T remove() {
        T x = entry.next.data;
        Element tmp1 = entry.next;
        Element tmp2 = tmp1;
        tmp2 = tmp2.next;

        for(int i = 0; i < this.size() - 1; i++) {
            tmp1 = tmp1.next;
        }
        tmp1.next = tmp2;
        tmp2.prev = tmp1;
        entry.next = tmp2;
        size--;
        return x;
    }

    public T element() {
        return entry.next.data;
    }

    public void next(int s) {
        Element tmp = entry.next;
        for(int i = 0; i < s; i++) {
            tmp = tmp.next;
        }
        entry.next = tmp;
    }

    public void prev(int s) {
        Element tmp = entry.next;
        for(int i = 0; i < s; i++) {
            tmp = tmp.prev;
        }
        entry.next = tmp;
    }

    public String toString() {
        String x = "{";
        Element tmp = entry.next;
        for(int i = 0; i < this.size(); i++) {
            x = x + tmp.data;
            if(this.size() != i + 1) x = x + ",";
            tmp = tmp.next;
        }
        x = x + "}";
        return x;
    }
}

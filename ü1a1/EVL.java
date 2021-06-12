package ü1a1;

import java.util.Iterator;

public class EVL<T> implements Iterable<T> {

    Listenelement<T> first = null;
    private int size = 0;

    class Listenelement<T> {
        T data;
        Listenelement<T> next = null;
        Listenelement(T data) {
            this.data = data;
        }
    }

    public void addLast(T o) {
        Listenelement<T> e = new Listenelement<>(o);
        Listenelement<T> tmp;

        if(first == null) {
            first = e;
        } else {
            tmp = first;
            while(tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = e;
        }
        size++;
    }

    public Listenelement<T> removeFirst() {
        Listenelement<T> tmp = first;
        first = first.next;
        size--;
        return tmp;
    }

    public void add(int pos, T o) {
        Listenelement<T> e = new Listenelement<>(o);
        Listenelement<T> tmp = first;

        for(int i = 0; i < pos - 1; i++) {
            tmp = tmp.next;
        }
        e.next = tmp.next;
        tmp.next = e;
        size++;
    }

    public Listenelement<T> remove(int pos) {
        Listenelement<T> tmp = first;
        Listenelement<T> x;

        if(pos == 0) {
            x = first;
            first = tmp.next;
        } else {
            for(int i = 0; i < pos - 1; i++) {
                tmp = tmp.next;
            }
            x = tmp.next;
            tmp.next = tmp.next.next;
        }

        size--;
        return x;
    }

    public boolean contains(T e) {
        Listenelement<T> tmp = first;
        boolean x = false;
        for(int i = 0; i < size; i++) {
            if(tmp.data.equals(e)) {
                x = true;
            }
            tmp = tmp.next;
        }
        return x;
    }

    public void zip(EVL<T> other) {
        int kleinsteListe = this.size() < other.size() ? this.size() : other.size();

        Listenelement<T> tmpListe1;
        Listenelement<T> tmpListe2;

        for(int j = 0; j < kleinsteListe; j++) {
            tmpListe1 = this.first;
            tmpListe2 = other.first;
            for (int i = 0; i < kleinsteListe - 1 - j; i++) {
                tmpListe1 = tmpListe1.next;
                tmpListe2 = tmpListe2.next;
            }
            if(j == 0) {
                if (this.size() > other.size()) tmpListe2.next = tmpListe1.next;
                tmpListe1.next = tmpListe2;
            } else {
                tmpListe2.next = tmpListe1.next;
                tmpListe1.next = tmpListe2;
            }
        }
        other.first = null;
    }

    public int size() {
         return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;
            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                Listenelement<T> tmp = first;
                for(int i = 0; i < cursor; i++) {
                    tmp = tmp.next;
                }
                cursor++;
                return tmp.data;
            }
        };
    }

    public String toString() {
        StringBuilder x = new StringBuilder("{");
        Listenelement<T> tmp = first;
        while(tmp != null) {
            if(tmp != first) x.append(",");
            x.append(tmp.data);
            tmp = tmp.next;
        }
        x.append("}");
        return x.toString();
    }
}

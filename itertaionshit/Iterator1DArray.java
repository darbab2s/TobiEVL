package itertaionshit;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterator1DArray<T> implements Iterable<T> {

    private int start;
    private int ende;
    private T[] array;

    public Iterator1DArray(T[] array) {
        this.array = array;
        start = 0;
        ende = array.length;
    }

    public Iterator1DArray(T[] array, int start) {
        this.array = array;
        this.start = start;
        this.ende = array.length;
    }

    public Iterator1DArray(T[] array, int start, int ende) {
        this.array = array;
        this.start = start;
        this.ende = ende;
    }

    private void ausgabe() {
        while(iterator().hasNext()) {
            System.out.println(iterator().next());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return start < ende;
            }

            @Override
            public T next() {
                if(!hasNext()) throw new NoSuchElementException();
                return array[start++];
            }
        };
    }
}
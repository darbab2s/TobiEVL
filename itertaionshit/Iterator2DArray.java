package itertaionshit;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterator2DArray<T> implements Iterable<T> {


    private T[][] array;
    private boolean istZeilenweise = true;
    private boolean istVorwaerts = true;


    public Iterator2DArray(T[][] array) {
        this.array = array;
    }

    public Iterator2DArray(T[][] array, boolean istZeilenweise) {
        this.array = array;
        this.istZeilenweise = istZeilenweise;
    }

    public Iterator2DArray(T[][] array, boolean istZeilenweise, boolean istVorwaerts) {
        this.array = array;
        this.istZeilenweise = istZeilenweise;
        this.istVorwaerts = istVorwaerts;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int zeilen = 0;
            private int spalten = 0;
            private int arrayL = array.length;

            @Override
            public boolean hasNext() {
                return zeilen * spalten <= Math.pow(arrayL - 1, 2);
            }

            @Override
            public T next() {
                if(istZeilenweise) {
                    if(!hasNext()) throw new NoSuchElementException();
                    if(spalten < arrayL) {
                        if(istVorwaerts) return array[zeilen][spalten++];
                        else return array[arrayL - 1 - zeilen][arrayL - 1 - spalten++];
                    }
                    else {
                        if(istVorwaerts) {
                            spalten = 0;
                            return array[++zeilen][spalten++];
                        } else {
                            spalten = 0;
                            return array[arrayL - 1 - ++zeilen][arrayL - 1 - spalten++];
                        }
                    }
                } else {
                    if(!hasNext()) throw new NoSuchElementException();
                    if(zeilen < array.length) {
                        if(istVorwaerts) return array[zeilen++][spalten];
                        else return array[arrayL - 1 - zeilen++][arrayL - 1 - spalten];
                    }
                    else {
                        if(istVorwaerts) {
                            zeilen = 0;
                            return array[zeilen++][++spalten];
                        } else {
                            zeilen = 0;
                            return array[arrayL - 1 - zeilen++][arrayL - 1 - ++spalten];
                        }

                    }
                }

            }
        };
    }
}

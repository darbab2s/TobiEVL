package ü1a1;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class Suchbaum<T> extends Binaerbaum<T> {

    private Comparator<T> comp;

    public Suchbaum() {
        super();
        this.comp = null;
    }

    public Suchbaum(Comparator<T> comp) {
        this.comp = comp;
    }

    public boolean insert(T i) {
        if (this.contains(i)) return false;
        if (start == null) start = new Knoten<T>(i);
        else insert(start, i);
        return true;
    }

    private void insert(Knoten<T> k, T i)  {
        Knoten<T> o = new Knoten<T>(i);
        if (meinCompare(i, k.data) > 0) {
            if (knotenRechtsIsNotNull(k)) insert(k.right, i);
            else k.right = o;
        } else {
            if (knotenLinksIsNotNull(k)) insert(k.left, i);
            else k.left = o;
        }
    }

    public boolean contains(T i) {
        return contains(start, i, false);
    }

    private boolean contains(Knoten<T> k, T i, boolean x) {
        if (k != null) if (meinCompare(i, k.data) == 0) x = true;
        else if (knotenLinksIsNotNull(k) && knotenRechtsIsNotNull(k)) {
            if(meinCompare(i, k.data) < 0) if (contains(k.left, i, x)) x = true;
            else if (contains(k.right, i, x)) x = true;
        } else if (knotenLinksIsNotNull(k)) {
            if (contains(k.left, i, x)) x = true;
        } else if (knotenRechtsIsNotNull(k)) {
            if (contains(k.right, i, x)) x = true;
        }
        return x;
    }

    public boolean remove(T i) {
        if(!this.contains(i)) return false;
        //Schritt 1 in jedem fall: Suche den zu löschenden Knoten!!!
        Knoten<T> loeschen = findeKnoten(start, i);
        Knoten<T> elternKnoten = findeElternKnoten(start, loeschen);
        boolean isLoeschenLeft = (int) loeschen.data < (int) elternKnoten.data;

        if(meinCompare(start.data, loeschen.data) == 0) {

        } else if(knotenLinksIsNotNull(loeschen) && knotenRechtsIsNotNull(loeschen)) {
            //Fall 1 (Knoten hat 2 Teilbäume): Knoten durch den Knoten mit dem höchsten Wert im linken Teilbaum ersetzen
            Knoten<T> loeschenLinks = loeschen.left;
            Knoten<T> loeschenRechts = loeschen.right;

            Knoten<T> tmp = findeElternKnoten(start, findeGroesstenKnoten(loeschen.left));

            Knoten<T> neu = tmp.right;
            tmp.right = null;
            if(meinCompare(neu.data, elternKnoten.data) > 0) elternKnoten.right = neu;
            else elternKnoten.left = neu;
            neu.left = loeschenLinks;
            neu.right = loeschenRechts;
        } else if(knotenLinksIsNotNull(loeschen) ^ knotenRechtsIsNotNull(loeschen)) {
            //Fall 2 (Knoten hat 1 Teilbaum): Referenzen vom ElternElternknoten auf den 1 Teilbaum machen
            if(knotenLinksIsNotNull(loeschen)) {
                if(meinCompare(elternKnoten.left.data, loeschen.data) == 0) elternKnoten.left = loeschen.left;
                else elternKnoten.right = loeschen.left;
            } else {
                if(meinCompare(elternKnoten.left.data, loeschen.data) == 0) elternKnoten.left = loeschen.right;
                else elternKnoten.right = loeschen.right;
            }
        } else {
            //Fall 3 (Knoten hat keinen Teilbaum): Referenzen im Elternknoten entfernen
            if(isLoeschenLeft) elternKnoten.left = null;
            else elternKnoten.right = null;
        }
        return true;
    }

    private Knoten<T> findeKnoten(Knoten<T> k, T i) {
        while(meinCompare(i, k.data) != 0) {
            if(meinCompare(i, k.data) > 0) k = k.right;
            else k = k.left;
        }
        return k;
    }

    private Knoten<T> findeElternKnoten(Knoten<T> start, Knoten<T> finden) {
        T data = finden.data;
        boolean gefunden = false;

        while(!gefunden) {
            //falls rechts und links vom start nicht null ist schaut der ob data gleich links/rechts von start ist
            //wenn nicht geht es je nach dem ob der Wert größer oder kleiner ist, nach rechts oder links
            //wenn links oder rechts null ist, dann checkt es nur links oder rechts
            if(knotenRechtsIsNotNull(start) && knotenLinksIsNotNull(start)) {
                if(meinCompare(data, start.data) > 0) {
                    if(meinCompare(data, start.right.data) == 0) {
                        gefunden = true;
                        continue;
                    }
                    start = start.right;
                }
                else if(meinCompare(data, start.data) < 0) {
                    if(meinCompare(data, start.left.data) == 0) {
                        gefunden = true;
                        continue;
                    }
                    start = start.left;
                }
            } else if(knotenLinksIsNotNull(start)) {
                if(meinCompare(data, start.left.data) == 0) gefunden = true;
                else start = start.left;
            } else {
                if(meinCompare(data, start.right.data) == 0) gefunden = true;
                else start = start.right;
            }
        }
        return start;
    }

    private Knoten<T> findeGroesstenKnoten(Knoten<T> k) {
        while(knotenRechtsIsNotNull(k)) {
            k = k.right;
        }
        return k;
    }

    private int meinCompare(T a, T b) {
        return comp == null ? ((Comparable<T>) a).compareTo(b) : comp.compare(a, b);
    }

    private boolean knotenLinksIsNotNull(Knoten<T> k) {
        return k.left != null;
    }

    private boolean knotenRechtsIsNotNull(Knoten<T> k) {
        return k.right != null;
    }
}

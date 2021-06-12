package ü1a1;

import java.util.NoSuchElementException;

public class IntSuchbaum extends Binaerbaum<Integer> {


    public void insert(int i) throws IllegalArgumentException {
        if (this.contains(i)) throw new IllegalArgumentException();
        if (start == null) start = new Knoten<Integer>(i);
        else insert(start, i);
    }

    //TODO: debuggen: wenn der start removet wird gibt es einen fehler ¯\_(ツ)_/¯
    public void remove(int i) throws NoSuchElementException {
        if(!this.contains(i)) throw new NoSuchElementException();
        //Schritt 1 in jedem fall: Suche den zu löschenden Knoten!!!
        Knoten loeschen = findeKnoten(start, i);
        Knoten elternKnoten = findeElternKnoten(start, loeschen);
        boolean isLoeschenLeft = (int) loeschen.data < (int) elternKnoten.data;

        if((int) start.data == (int) loeschen.data) {

        } else if(knotenLinksIsNotNull(loeschen) && knotenRechtsIsNotNull(loeschen)) {
            //Fall 1 (Knoten hat 2 Teilbäume): Knoten durch den Knoten mit dem höchsten Wert im linken Teilbaum ersetzen
            Knoten loeschenLinks = loeschen.left;
            Knoten loeschenRechts = loeschen.right;

            Knoten tmp = findeElternKnoten(start, findeGroesstenKnoten(loeschen.left));

            Knoten neu = tmp.right;
            tmp.right = null;
            if((int) neu.data > (int) elternKnoten.data) elternKnoten.right = neu;
            else elternKnoten.left = neu;
            neu.left = loeschenLinks;
            neu.right = loeschenRechts;
        } else if(knotenLinksIsNotNull(loeschen) ^ knotenRechtsIsNotNull(loeschen)) {
            //Fall 2 (Knoten hat 1 Teilbaum): Referenzen vom ElternElternknoten auf den 1 Teilbaum machen
            if(knotenLinksIsNotNull(loeschen)) {
                if(elternKnoten.left == loeschen) elternKnoten.left = loeschen.left;
                else elternKnoten.right = loeschen.left;
            } else {
                if(elternKnoten.left == loeschen) elternKnoten.left = loeschen.right;
                else elternKnoten.right = loeschen.right;
            }
        } else {
            //Fall 3 (Knoten hat keinen Teilbaum): Referenzen im Elternknoten entfernen
            if(isLoeschenLeft) elternKnoten.left = null;
            else elternKnoten.right = null;
        }
    }

    public boolean contains(int i) {
        boolean x = false;
        return contains(start, i, x);
    }

    private void insert(Knoten k, int i)  {
        Knoten<Integer> o = new Knoten<Integer>(i);
        if (i > (int) k.data) {
            if (knotenRechtsIsNotNull(k)) insert(k.right, i);
            else k.right = o;
        } else {
            if (knotenLinksIsNotNull(k)) insert(k.left, i);
            else k.left = o;
        }
    }

    private Knoten findeKnoten(Knoten k, int i) {
        while(i != (int) k.data) {
            if(i > (int) k.data) k = k.right;
            else k = k.left;
        }
        return k;
    }

    private Knoten findeElternKnoten(Knoten start, Knoten finden) {
        int data = (int) finden.data;
        boolean gefunden = false;

        while(!gefunden) {
            //falls rechts und links vom start nicht null ist schaut der ob data gleich links/rechts von start ist
            //wenn nicht geht es je nach dem ob der Wert größer oder kleiner ist, nach rechts oder links
            //wenn links oder rechts null ist, dann checkt es nur links oder rechts
            if(knotenRechtsIsNotNull(start) && knotenLinksIsNotNull(start)) {
                if(data > (int) start.data) {
                    if(data == (int) start.right.data) {
                         gefunden = true;
                        continue;
                    }
                    start = start.right;
                }
                else if(data < (int) start.data) {
                    if(data == (int) start.left.data) {
                        gefunden = true;
                        continue;
                    }
                    start = start.left;
                }
            } else if(knotenLinksIsNotNull(start)) {
                if(data == (int) start.left.data) {
                    gefunden = true;
                    continue;
                }
                else start = start.left;
            } else {
                if(data == (int) start.right.data) {
                    gefunden = true;
                    continue;
                }
                else start = start.right;
            }
        }
        return start;
    }

    private Knoten findeGroesstenKnoten(Knoten k) {
        while(knotenRechtsIsNotNull(k)) {
            k = k.right;
        }
        return k;
    }

    private boolean contains(Knoten k, int i, boolean x) {
        if (k != null) if (i == (int) k.data) x = true;
        else if (knotenLinksIsNotNull(k) && knotenRechtsIsNotNull(k)) {
            if (contains(k.left, i, x)) x = true;
            if (contains(k.right, i, x)) x = true;
        } else if (knotenLinksIsNotNull(k)) {
            if (contains(k.left, i, x)) x = true;
        } else if (knotenRechtsIsNotNull(k)) {
            if (contains(k.right, i, x)) x = true;
        }
        return x;
    }

    private boolean knotenLinksIsNotNull(Knoten k) {
        return k.left != null;
    }

    private boolean knotenRechtsIsNotNull(Knoten k) {
        return k.right != null;
    }
}
package ü1a1;

public class Binaerbaum<T> {

    protected Knoten<T> start;

    protected class Knoten<T> {
        protected T data;
        protected Knoten<T> left;
        protected Knoten<T> right;

        public Knoten(T data) {
            this.data = data;
        }
    }

    public Binaerbaum() {
        this.start = null;
    }

    public Binaerbaum(Knoten a, Knoten b, T e) {
        this.start = new Knoten(e);
        this.start.left = a;
        this.start.right = b;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public int hoehe() {
        return hoehe(this.start);
    }

    public int size() {
        return size(this.start);
    }

    public String preorder() {
        String s = "";
        return preorder(this.start, s);
    }

    public String inorder() {
        String s = "";
        return inorder(this.start, s);
    }

    public String postorder() {
        String s = "";
        return postorder(this.start, s);
    }

    private int hoehe(Knoten k) {
        return k == null ? 0 : 1 + Math.max(this.hoehe(k.left), this.hoehe(k.right));
    }

    private int size(Knoten k) {
        return k == null ? 0 : 1 + size(k.left) + size(k.right);
    }

    //hilfsmethode für preorder, es geht alle möglichen fälle durch
    private String preorder(Knoten k, String s) {
        if(knotenLinksIsNotNull(k) && knotenRechtsIsNotNull(k)) s = k.data + " " + preorder(k.left, s) + preorder(k.right, s);
        else if(knotenLinksIsNotNull(k)) s = k.data + " " + preorder(k.left, s);
        else if(knotenRechtsIsNotNull(k)) s = k.data + " " + preorder(k.right, s);
        else s = k.data + " ";
        return s;
    }

    //hilfsmethode für inorderorder, es geht alle möglichen fälle durch
    private String inorder(Knoten k, String s) {
        if(knotenLinksIsNotNull(k) && knotenRechtsIsNotNull(k)) s = inorder(k.left, s) + k.data + " " + inorder(k.right, s);
        else if(knotenLinksIsNotNull(k)) s = inorder(k.left, s) + k.data + " ";
        else if(knotenRechtsIsNotNull(k)) s = inorder(k.right, s) + k.data + " ";
        else s = k.data + " ";
        return s;
    }

    //hilfsmethode für postorder, es geht alle möglichen fälle durch
    private String postorder(Knoten k, String s) {
        if(knotenLinksIsNotNull(k) && knotenRechtsIsNotNull(k)) s = postorder(k.left, s) + postorder(k.right, s) + k.data + " ";
        else if(knotenLinksIsNotNull(k)) s = postorder(k.left, s) + k.data + " ";
        else if(knotenRechtsIsNotNull(k)) s = postorder(k.right, s) + k.data + " ";
        else s = k.data + " ";
        return s;
    }

    //hilfsmethode für toString, es geht alle möglichen fälle durch
    private String toString(Knoten k, String s) {
        if(knotenLinksIsNotNull(k) && knotenRechtsIsNotNull(k)) s = "(" + toString(k.left, s) + k.data + toString(k.right, s) + ")";
        else if(knotenLinksIsNotNull(k)) s = "(" + toString(k.left, s) + k.data + ")";
        else if(knotenRechtsIsNotNull(k)) s = "(" + k.data + toString(k.right, s) + ")";
        else s = "(" + k.data + ")";
        return s;
    }

    private boolean knotenLinksIsNotNull(Knoten k) {
        return k.left != null;
    }

    private boolean knotenRechtsIsNotNull(Knoten k) {
        return k.right != null;
    }

    public String toString() {
        String s;
        if(start != null) {
            s = start.data + "";
            return toString(start, s);
        }
        else {
            s = "";
            return s;
        }
    }
}
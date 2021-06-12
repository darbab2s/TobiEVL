package ü1a1;

public class Paar<E, Z> {

    private E erstes;
    private Z zweites;

    public Paar(E e, Z z) {
        this.setErstes(e);
        this.setZweites(z);
    }

    public E getErstes() {
        return erstes;
    }

    public Z getZweites() {
        return zweites;
    }

    public void setErstes(E e) {
        this.erstes = e;
    }
    public void setZweites(Z z) {
        this.zweites = z;
    }

    public void setBeide(E e, Z z) {
        this.setErstes(e);
        this.setZweites(z);
    }

    public boolean equals(Paar<E, Z> p) {
        return p.getErstes().equals(this.getErstes()) && p.getZweites().equals(this.getZweites());
    }

    public String toString() {
        return "(" + getErstes() + "," + getZweites() + ")";
    }
}

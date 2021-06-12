package vergleichen;

public class Boxer extends Person implements Comparable<Boxer> {

    private int gewicht;

    public Boxer(String name, String vorname, int gewicht) {
        super(name, vorname);
        this.gewicht = gewicht;
    }

    public int compareTo(Boxer other) {
        int gewichtComp = this.getGewicht() - other.getGewicht();
        if(gewichtComp != 0) return gewichtComp;
        else {
            int nameComp = this.getName().compareTo(other.getName());
            return nameComp != 0 ? nameComp : this.getVorname().compareTo(other.getVorname());
        }
    }

    public boolean equals(Boxer other) {
        return this.compareTo(other) == 0;
    }

    public int getGewicht() {
        return this.gewicht;
    }

    public String toString() {
        return this.getName() + ", " + this.getVorname() + ", " + this.gewicht;
    }

}

package vergleichen;

public class Student extends Person implements Comparable<Student> {

    private int matrikelNR;

    public Student(String name, String vorname, int matrikelNR) {
        super(name, vorname);
        this.matrikelNR = matrikelNR;
    }

    public int compareTo(Student other) {
        return this.getMatrikelNR() - other.getMatrikelNR();
    }

    public boolean equals(Student other) {
        return this.compareTo(other) == 0;
    }

    public int getMatrikelNR() {
        return this.getMatrikelNR();
    }

    public String toString() {
        return this.getName() + ", " + this.getVorname() + ", " + this.getMatrikelNR();
    }

}

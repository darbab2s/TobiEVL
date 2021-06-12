package vergleichen;

abstract public class Person {

    private String name;
    private String vorname;

    public Person(String name, String vorname) {
        this.name = name;
        this.vorname = vorname;
    }

    public String getName() {
        return this.name;
    }

    public String getVorname() {
        return this.vorname;
    }

    public String toString() {
        return this.getName() + ", " + this.getVorname();
    }

}

package vergleichen;

import java.math.BigInteger;
import java.util.Comparator;

public class ComparatorPersonVornameName implements Comparator<Person> {

    public int compare(Person person1, Person person2) {
        int vergleich = compareString(person1.getVorname(), person2.getVorname());
        if(vergleich == 0) vergleich = compareString(person1.getName(), person2.getName());
        return vergleich;
    }

    private static int compareString(String person1, String person2) {
        int kleinsterString = Math.min(person1.length(), person2.length());
        int zahl = 0;
        for(int i = 0; i < kleinsterString; i++) {

            if(compareCharAt(person1, person2, i) > 0) {
                zahl = 1;
                break;
            } else if(compareCharAt(person1, person2, i) < 0) {
                zahl = -1;
                break;
            }
        }
        if(zahl == 0) {
            if(person1.length() > person2.length()) zahl = -1;
            else if(person1.length() < person2.length()) zahl = 1;
        }
        return zahl;
    }

    private static int compareCharAt(String person1, String person2, int x) {
        return Character.compare(person1.charAt(x), person2.charAt(x));
    }

    public boolean equals(Person other) {
        return true;
    }

}

package vergleichen;

import java.util.Comparator;

public class ComparatorBoxerGewicht implements Comparator<Boxer> {

    public int compare(Boxer b1, Boxer b2) {
        return Integer.compare(b1.getGewicht(), b2.getGewicht());
    }

    public boolean equals(Boxer b1, Boxer b2) {
        return Integer.compare(b1.getGewicht(), b2.getGewicht()) == 0;
    }
}

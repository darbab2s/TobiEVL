package ü1a1;

public class Josephus {

    int n;
    int k;
    RDVL<Integer> rdvl = new RDVL<>();

    public Josephus(int n, int k) {
        this.n = n;
        this.k = k;

        for(int i = 1; i <= n; i++) {
            rdvl.add(i);
        }
    }

    public Integer loese() {
        while(rdvl.size() != 1) {
            rdvl.next(this.k - 1);
            rdvl.remove();
        }
        return rdvl.entry.next.data;
    }
}
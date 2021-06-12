package ü1a1;

import itertaionshit.Iterator1DArray;
import itertaionshit.Iterator2DArray;
import vergleichen.*;
import java.util.Comparator;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Integer[] a = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer[][] a2 = new Integer[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        EVL<Integer> evl = new EVL<>();
        for(int i = 0; i < 10; i++) {
            evl.addLast(i);
        }

        Iterator<Integer> it = evl.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
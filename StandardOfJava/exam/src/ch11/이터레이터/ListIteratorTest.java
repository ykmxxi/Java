package ch11.이터레이터;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        ListIterator it = list.listIterator();

        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println();

        while (it.hasPrevious()) {
            System.out.print(it.previous());
        }
    }
}

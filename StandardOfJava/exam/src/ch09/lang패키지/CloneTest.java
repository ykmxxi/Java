package ch09.lang패키지;

import java.util.ArrayList;
import java.util.List;

public class CloneTest {

    public static void main(String[] args) {
        ArrayList<Integer> original = new ArrayList<>(List.of(1, 2, 3, 4));
        ArrayList<Integer> copy = (ArrayList<Integer>) original.clone();

        System.out.println(copy.toString());
    }
}

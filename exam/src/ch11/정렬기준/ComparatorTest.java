package ch11.정렬기준;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {
    public static void main(String[] args) {
        String[] strings = {"cat", "Dog", "lion", "tiger"};

        Arrays.sort(strings);
        System.out.println("기본 정렬 결과: " + Arrays.toString(strings));

        Arrays.sort(strings, String.CASE_INSENSITIVE_ORDER);
        System.out.println("대소문자 구분안한 기본 정렬: " + Arrays.toString(strings));

        Arrays.sort(strings, new Descending());
        System.out.println("역순 정렬 결과: " + Arrays.toString(strings));
    }
}

class Descending implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            Comparable c1 = (Comparable) o1;
            Comparable c2 = (Comparable) o2;
            return c1.compareTo(c2) * -1;
        }
        return -1;
    }
}
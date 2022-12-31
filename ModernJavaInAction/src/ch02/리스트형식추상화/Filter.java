package ch02.리스트형식추상화;

import java.util.ArrayList;
import java.util.List;

public class Filter {
    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();

        for (T e : list) {
            if (p.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}

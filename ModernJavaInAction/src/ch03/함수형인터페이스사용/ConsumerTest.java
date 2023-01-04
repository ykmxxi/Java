package ch03.함수형인터페이스사용;

import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface Consumer<T> {
    void accept(T t);
}

public class ConsumerTest {
    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }

    public static void main(String[] args) {
        forEach(
                Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.println(i)
        );
    }
}

package ch14.람다식;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;

public class PrimitiveTypeLambdaTest {
    public static void main(String[] args) {
        IntSupplier supplier = () -> (int) (Math.random() * 100) + 1;
        IntConsumer consumer = i -> System.out.print(i + ", ");
        IntPredicate predicate = i -> i % 2 == 0;
        IntUnaryOperator unaryOperator = i -> i / 10 * 10; // 일의 자리 제거

        List<Integer> list = new ArrayList<>(10);

        makeRandomList(supplier, list);
        System.out.println(list.toString());
        printEvenNumber(predicate, consumer, list);

        List<Integer> newList = doSomething(unaryOperator, list);
        System.out.println(newList);

    }

    static void makeRandomList(IntSupplier supplier, List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(supplier.getAsInt());
        }
    }

    static void printEvenNumber(IntPredicate predicate, IntConsumer consumer, List<Integer> list) {
        System.out.print("[");
        for (Integer i : list) {
            if (predicate.test(i)) {
                consumer.accept(i);
            }
        }
        System.out.println("]");
    }

    static List<Integer> doSomething(IntUnaryOperator unaryOperator, List<Integer> list) {
        List<Integer> newList = new ArrayList<>(list.size());

        for (int i = 0; i < 10; i++) {
            newList.add(unaryOperator.applyAsInt(list.get(i)));
        }
        return newList;
    }
}

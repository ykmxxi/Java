package ch06.커스텀컬렉터;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PrimeNumberByCustomCollector {

    public static boolean isPrime(List<Integer> primes, Integer candidate) {
        double candidateRoot = Math.sqrt(candidate);
        return primes.stream()
                .takeWhile(i -> i <= candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n)
                .boxed()
                .collect(new CustomCollector());
    }

    // takeWhile은 자바 9에서 지원하므로 자바 8에서는 이 기능을 사용할 수 없다.
    // takeWhile 직접 구현하기
    /*
    public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
        int i = 0;
        for (A item : list) {
            if (!p.test(item)) { // 리스트의 현재 항목이 프레디케이트를 만족하는지 확인
                return list.subList(0, i); // 만족하지 않으면 현재 검사한 항목의 이전 항목 하위 리스트를 반환
            }
            i++;
        }
        return list;
    }
     */

    public static void main(String[] args) {
        List<Integer> primeNumbers = partitionPrimesWithCustomCollector(100).get(true);
        List<Integer> nonePrimeNumbers = partitionPrimesWithCustomCollector(100).get(false);

        System.out.println(primeNumbers);
        System.out.println(nonePrimeNumbers);

    }
}

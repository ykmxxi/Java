package ch05.숫자형스트림;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriple {
    public static void main(String[] args) {
        // 1 부터 100 사이 정수 a, b의 피타고라스 수
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100)
                .boxed()
                .flatMap(a -> // flatMap을 통해 생성된 각각의 스트림을 하나의 평준화된 스트림으로 만든다.
                        IntStream.rangeClosed(a, 100) // a로 설정해 중복을 막는다. (3, 4, 5) (4, 3, 5)
                                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                                .mapToObj(b ->
                                        new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
                );

        pythagoreanTriples.limit(5)
                .forEach(t -> System.out.println("(" + t[0] + "," + t[1] + "," + t[2] + ")"));
        System.out.println();

        // 최적화: 형식을 만족하는 세 수를 만든 다음 원하는 조건에 맞는 결과만 필터링
        Stream<double[]> enhancedPythagoreanTriples = IntStream.rangeClosed(1, 100) // a 생성
                .boxed() // Stream<Integer>로 변환
                .flatMap(a -> IntStream.rangeClosed(a, 100) // b 생성
                        .mapToObj(b -> new double[]{a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0));
        enhancedPythagoreanTriples.limit(10)
                .forEach(t -> System.out.println("(" + (int) t[0] + "," + (int) t[1] + "," + (int) t[2] + ")"));
    }
}

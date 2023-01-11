package ch05.매핑;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMappingQuiz {
    public static void main(String[] args) {
        // 1.숫자 리스트가 주어졌을 때 각 숫자의 제곱근으로 이루어진 리스트를 반환
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println(squares);

        // 2. 두 개의 숫자 리스트가 있을 떄 모든 숫자 쌍의 리스트를 반환
        // Ex: [1,2,3], [3,4] -> [(1,3), (1,4), ... (3,3), (3,4)]
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4, 5);
        List<int[]> pairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        for (int[] pair : pairs) {
            System.out.print(Arrays.toString(pair) + ", ");
        }
        System.out.println();

        // 3. 2번 퀴즈에서 합이 3으로 나누어떨어지는 숫자 쌍만 반환.
        List<int[]> multipleOfThreeParis = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j}))
                .collect(Collectors.toList());
        for (int[] pair : multipleOfThreeParis) {
            System.out.print(Arrays.toString(pair) + ", ");
        }

    }
}

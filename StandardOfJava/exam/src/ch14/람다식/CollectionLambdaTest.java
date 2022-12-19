package ch14.람다식;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollectionLambdaTest {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // list 모든 요소 출력
        list.forEach(i -> System.out.print(i + ", "));
        System.out.println();

        // list 요소 중 2와 3의 배수를 모두 제거
        list.removeIf(x -> x % 2 == 0 || x % 3 == 0);
        System.out.println(list);

        // list 각 요소에 10 곱하기
        list.replaceAll(i -> i * 10);
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        for (int i = 1; i < 5; i++) {
            map.put(String.valueOf(i), String.valueOf(i));
        }

        // map 모든 요소를 {key, value} 형식으로 출력
        map.forEach((key, value) -> System.out.print("{" + key + ", " + value + "}, "));
        System.out.println();
    }
}
package ch03;

public class OperatorEx3 {

    public static void main(String[] args) {

        int i = 5, j = 5;
        System.out.println(i++); // i 값이 증가되기 전에 참조되므로 println()에게 5를 넘겨 준 뒤 값이 증가, 5
        System.out.println(++j); // 6
        System.out.println("i = " + i + ", j = " + j); // i = 6, j = 6

        int x, y;
        x = 5;
        y = (x++) - (++x);
        System.out.println(y); // -2
        /*
        위 식은 다음과 같다.
        System.out.println(i);
        i++;
        ++j;
        System.out.println(j);
         */
    }
}

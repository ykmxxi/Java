package ch04;

// 1 부터계속 더해 나가서 몇까지 더하면 합이 입력한 수를 넘는지 알아내는 예제

import java.util.Scanner;

public class FlowEx30 {

    public static void main(String[] args) {
        int sum = 0;
        int i = 0;
        int input;

        Scanner sc = new Scanner(System.in);
        System.out.println("정수를 입력하시오. >>> ");
        input = sc.nextInt();

        while (true) {
            if (sum > input)
                break;
            ++i;
            sum += i;
        }

        System.out.println("i = " + i);
        System.out.println("sum = " + sum);
    }
}

package ch04;
// p.170

import java.util.Scanner;

public class FlowEx25 {

    public static void main(String[] args) {
        int num = 0, sum = 0;
        System.out.println("숫자 입력. (ex:1234) >>>");
        Scanner sc = new Scanner(System.in);

        String tmp = sc.nextLine();
        num = Integer.parseInt(tmp);

        while (num != 0) {
            sum += num % 10;
            System.out.printf("sum = %3d num = %d%n", sum, num);
            num /= 10;
        }

        System.out.println("각 자리수의 합 : " + sum);

    }
}

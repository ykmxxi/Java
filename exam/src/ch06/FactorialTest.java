package ch06;

// Recursive Call Exam

import java.util.Scanner;

public class FactorialTest {

    // static 메서드는 인스턴스 생성 X
    static int factorial(int n) {

        int result = 0;

        if (n == 1) {
            result = 1;
        } else if (n <= 0 || n > 12) {
            System.out.println("유효하지 않은 값입니다. 프로그램 종료");
            return -1;
        } else {
            result = n * factorial(n - 1);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("input 값을 입력 >>> ");

        int input = scanner.nextInt();
        int factorialResult = factorial(input);

        System.out.println("결과값 : " + factorialResult);

    }
}

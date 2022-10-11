package ch06;

// Recursive Call Exam

import java.util.Scanner;

public class FactorialTest {

    static int factorial(int n) {

        int result = 0;

        if (n == 1) {
            result = 1;
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

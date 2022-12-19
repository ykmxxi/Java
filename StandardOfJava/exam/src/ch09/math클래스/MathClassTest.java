package ch09.math클래스;

public class MathClassTest {
    public static void main(String[] args) {
        // 올림, 버림, 반올림
        System.out.println(Math.ceil(1.1));     // 2.0
        System.out.println(Math.floor(1.9));     // 1.0
        System.out.println(Math.round(1.1));    // 1
        System.out.println(Math.round(1.5));    // 2
        System.out.println(Math.ceil(-1.5));    // -1.0
        System.out.println(Math.floor(-1.5));    // -2.0
        System.out.println(Math.round(-1.5));   // -1
        System.out.println(Math.round(-1.9));   // -2
    }
}

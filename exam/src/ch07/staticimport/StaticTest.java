package ch07.staticimport;

public class StaticTest {

    // 클래스변수(static변수)
    static int width = 200;
    static int height = 100;

    static {    // 클래스 초기화 블럭
        // static변수의 복잡한 초기화 수행
    }

    // 클래스 메서드 (static method)
    static int max(int a, int b) {
        return a > b ? a : b;
    }
}

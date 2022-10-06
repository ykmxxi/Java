package ch06;

public class CallStackTest {

    public static void main(String[] args) {

        System.out.println("main(String[] args) 실행");
        firstMethod();
        System.out.println("main(String[] args) 종료");

    }

    static void firstMethod() {
        System.out.println("firstMethod 실행");
        secondMethod();
        System.out.println("firstMethod 종료");
    }

    static void secondMethod() {
        System.out.println("secondMethod 실행");
        System.out.println("secondMethod 종료");

    }
}

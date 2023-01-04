package ch03.함수디스크립터;

public class LambdaExpression {

    public static void process(Runnable r) {
        r.run();
    }

    public static void main(String[] args) {

        // 인수가 없으며 void를 반환하는 람다 표현식
        // 이는 Runnable 인터페이스의 run 메서드 시그니처와 같다.
        process(() -> System.out.println("This is Lambda Expression"));
        process(() -> System.out.println("This is awesome!!!"));
    }
}

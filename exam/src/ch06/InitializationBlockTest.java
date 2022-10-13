package ch06;

public class InitializationBlockTest {

    // 클래스 초기화 블럭
    static {
        System.out.println("static { }, 클래스 초기화 블럭 실행");
    }

    // 인스턴스 초기화 블럭
    {
        System.out.println("{ }, 인스턴스 초기화 블럭");
    }

    public InitializationBlockTest() {
        System.out.println("생성자");
    }

    public static void main(String[] args) {
        System.out.println("첫 번째 인스턴스 생성");
        InitializationBlockTest ibt = new InitializationBlockTest();

        System.out.println("두 번째 인스턴스 생성");
        InitializationBlockTest ibt2 = new InitializationBlockTest();
    }
}

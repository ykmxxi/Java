package ch06;

class MyMathMethod {

    // static method 는 인스턴스 변수 없이 매개변수만으로 작업가능
    static long add(long a, long b) {
        return a + b;
    }

    static long substract(long a, long b) {
        return a - b;
    }

    static long multiply(long a, long b) {
        return a * b;
    }

    static double divide(double a, double b) {
        return a / b;
    }

}

public class StaticMethodTest {

    public static void main(String[] args) {

        // static method 는 호출 시 인스턴스 생성 없이 클래스이름.메서드이름() 을 통해 호출가능
        System.out.println(MyMathMethod.add(200L, 100L));
        System.out.println(MyMathMethod.substract(200L, 100L));
        System.out.println(MyMathMethod.multiply(200L, 100L));
        System.out.println(MyMathMethod.divide(200L, 100L));
    }
}

package ch06;

class MyMath {

    long add(long a, long b) {
        return a + b;
    }

    long substract(long a, long b) {
        return a - b;
    }

    long multiplay(long a, long b) {
        return a * b;
    }

    double divide(double a, double b) {
        return a / b;
    }
}

public class MyMathTest {

    public static void main(String[] args) {

        MyMath myMath = new MyMath();

        /*
            long addResult = myMath.add(5L, 3L);
            -> long addResult = 8L;
            호출한 자리를 반환값이 대신하고 대입연산자에 의해 이 값이 변수에 저장되는 flow
         */
        long addResult = myMath.add(5L, 3L);
        long substractResult = myMath.substract(5L, 3L);
        long multiplyResult = myMath.multiplay(5L, 3L);
        double divideResult = myMath.divide(5L, 3L);

        System.out.println("Add Result : " + addResult);
        System.out.println("Substract Result : " + substractResult);
        System.out.println("Multiply Result : " + multiplyResult);
        System.out.println("Divide Result : " + divideResult);
        // divide 의 반환 타입은 double 타입이지만 인자가 자동 형변환이 가능한 타입이면 호출 가능

    }
}

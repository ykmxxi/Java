package ch08.예외메시지출력;

public class ExceptionMessageTest {
    public static void main(String[] args) {
        System.out.println(1);
        System.out.println(2);

        try {
            System.out.println(3);
            System.out.println(4);
            System.out.println(5 / 0);
        } catch (ArithmeticException arithmeticException) {
            arithmeticException.printStackTrace();
            System.out.println("예외메시지: " + arithmeticException.getMessage());
        }
        System.out.println("try-catch 빠져나옴");
    }
}

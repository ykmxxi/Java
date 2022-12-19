package ch03;

public class OperatorEx7 {

    public static void main(String[] args) {
        byte a = 10;
        byte b = 30;
        //byte c = a + b; -> 컴파일 에러 발생, 명시적으로 형변환 필요
        byte c = (byte) (a + b);
        byte d = (byte) (a * b);
        System.out.println(c);
        System.out.println(d);
    }
}

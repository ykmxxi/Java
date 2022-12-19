package ch02;

// p.81 예제

public class CastingEx4 {

    public static void main(String[] args) {

        int i = 91234567; // 8자리 10진수
        float f = (float) i;
        int i2 = (int) f;

        double d = (double) i;
        int i3 = (int) d;

        float f2 = 1.555f;
        int i4 = (int) f2;

        System.out.printf("i = %d%n", i);
        System.out.printf("f = %f, i2 = %d%n", f, i2);
        System.out.printf("d = %f, i3 = %d%n", d, i3);
        System.out.printf("(int) %f = %d%n", f2, i4);
    }
}

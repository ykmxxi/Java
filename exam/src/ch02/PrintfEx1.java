package ch02;

public class PrintfEx1 {

    public static void main(String[] args) {
        byte b = 1;
        short s = 2;
        char c = 'A';

        int finger = 10;
        long big = 100_000_000L;
        long hex = 0xFFFF_FFFF_FFFFL;

        int octNum = 010; // 8진수 10, 10진수 8
        int hexNum = 0x10; // 16진수 10, 10진수 16
        int binNum = 0b10; // 2진수 10, 10진수 2

        System.out.printf("b = %d%n", b);
        System.out.printf("finger = [%5d]%n", finger);
        System.out.printf("finger = [%-5d]%n", finger);
        System.out.printf("finger = [%05d]%n", finger);
    }
}

package ch10.형식화;

import java.text.DecimalFormat;

public class DecimalFormatTest {
    public static void main(String[] args) {
        double number1 = 100000.847;
        double number2 = 200100.398;
        double number3 = 200100.393;

        DecimalFormat format = new DecimalFormat("#,###.00");
        System.out.println(format.format(number1)); // 100,000.85
        System.out.println(format.format(number2)); // 200,100.40
        System.out.println(format.format(number3)); // 200,100.39
    }
}

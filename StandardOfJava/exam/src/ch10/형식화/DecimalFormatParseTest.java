package ch10.형식화;

import java.text.DecimalFormat;

public class DecimalFormatParseTest {
    public static void main(String[] args) {
        DecimalFormat df1 = new DecimalFormat("#,###.00");
        DecimalFormat df2 = new DecimalFormat("#.###E0");

        try {
            Number number = df1.parse("1,234,567.89");
            System.out.print("1,234,567.89" + " -> ");

            double d = number.doubleValue();
            System.out.print(d + " -> ");

            System.out.println(df2.format(number));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

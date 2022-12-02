package ch09.lang패키지;

public class ToStringTest {
    public static void main(String[] args) {
        String string = "YKM";
        java.util.Date today = new java.util.Date();

        System.out.println(string.toString());
        // YKM
        System.out.println(today.toString());
        // Fri Dec 2 18:02:11 KST 2022
    }
}
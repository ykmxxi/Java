package ch10.형식화;

import java.text.MessageFormat;

public class MessageFormatTest {
    public static void main(String[] args) {
        String message = "Name: {0} \nTel: {1} \nAge: {2} \nBirthday: {3}";

        Object[] arguments = {"홍길동", "010-1234-5678", "25", "11-12"};

        System.out.println(MessageFormat.format(message, arguments));
    }
}

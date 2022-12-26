package ch15.직렬화;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializationTest {
    public static void main(String[] args) {
        try {
            String fileName = "/Users/ykm/Desktop/자바의정석/exam/src/ch15/직렬화/UserInfo.ser";
            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);

            ObjectInputStream in = new ObjectInputStream(bis);

            UserInfo user1 = (UserInfo) in.readObject();
            UserInfo user2 = (UserInfo) in.readObject();
            ArrayList list = (ArrayList) in.readObject();

            System.out.println(user1);
            System.out.println(user2);
            System.out.println(list);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

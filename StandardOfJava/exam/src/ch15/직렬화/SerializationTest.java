package ch15.직렬화;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializationTest {
    public static void main(String[] args) {
        try {
            String fileName = "/Users/ykm/Desktop/자바의정석/exam/src/ch15/직렬화/UserInfo.ser";
            FileOutputStream fos = new FileOutputStream(fileName);
            BufferedOutputStream bos = new BufferedOutputStream(fos);

            ObjectOutputStream out = new ObjectOutputStream(bos);

            UserInfo user1 = new UserInfo("Jason", "1234", 30);
            UserInfo user2 = new UserInfo("David", "4321", 22);

            ArrayList<UserInfo> list = new ArrayList<>();

            list.add(user1);
            list.add(user2);

            out.writeObject(user1);
            out.writeObject(user2);
            out.writeObject(list);
            out.close();
            System.out.println("직렬화 완료");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

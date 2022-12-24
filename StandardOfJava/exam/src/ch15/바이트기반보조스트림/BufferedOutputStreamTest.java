package ch15.바이트기반보조스트림;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

class BufferedOutputStreamTest {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("/Users/ykm/Desktop/자바의정석/exam/src/ch15/바이트기반보조스트림/test.txt");
            BufferedOutputStream bos = new BufferedOutputStream(fos, 6);

            for (int i = '1'; i <= '9'; i++) {
                bos.write(i);
            }

            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

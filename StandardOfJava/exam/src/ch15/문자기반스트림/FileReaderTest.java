package ch15.문자기반스트림;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {
    public static void main(String[] args) {

        try {
            String fileName = "/Users/ykm/Desktop/자바의정석/exam/src/ch15/문자기반스트림/Hello.txt";
            FileInputStream fis = new FileInputStream(fileName);
            FileReader fr = new FileReader(fileName);

            int data = 0;
            System.out.print("FileInputStream: ");
            while ((data = fis.read()) != -1) {
                System.out.print((char) data); // FileInputStream사용 시 한글이 깨짐
            }

            System.out.println();
            fis.close();

            System.out.print("FileReader: ");
            while ((data = fr.read()) != -1) {
                System.out.print((char) data); // 유니코드 변환 자동 제공, 한글 정상 출력
            }

            System.out.println();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
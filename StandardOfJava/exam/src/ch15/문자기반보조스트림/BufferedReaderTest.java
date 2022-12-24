package ch15.문자기반보조스트림;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(
                    "/Users/ykm/Desktop/자바의정석/exam/src/ch15/문자기반보조스트림/BufferedReaderTest.java");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";

            for (int i = 1; (line = bufferedReader.readLine()) != null; i++) {
                if (line.indexOf(";") != -1) { // 세미콜론을 포함한 줄을 출력
                    System.out.println(i + ":" + line);
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

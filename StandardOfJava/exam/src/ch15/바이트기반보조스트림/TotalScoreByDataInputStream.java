package ch15.바이트기반보조스트림;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public class TotalScoreByDataInputStream {
    public static void main(String[] args) {
        int sum = 0;
        int score = 0;

        try (FileInputStream fis = new FileInputStream("/Users/ykm/Desktop/자바의정석/exam/src/ch15/바이트기반보조스트림/score.dat");
             DataInputStream dis = new DataInputStream(fis)) {

            while (true) {
                score = dis.readInt();
                System.out.println(score);
                sum += score;
            }

        } catch (EOFException eofException) {
            System.out.println("점수 총합은 " + sum + "입니다.");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}

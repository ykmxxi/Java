package ch15.randomaccessfile;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class PrintKoreanInfo {
    public static void main(String[] args) {
        int sum = 0;
        int count = 0;

        try {
            RandomAccessFile raf = new RandomAccessFile(
                    "/Users/ykm/Desktop/자바의정석/exam/src/ch15/randomaccessfile/score.dat", "r");

            int pointer = 4;
            while (true) {
                raf.seek(pointer);
                sum += raf.readInt();
                pointer += 16; // 번호와 3과목의 점수로 모두 4개의 int값(4x4 = 16byte)으로 되어 있기 때문에 포인터를 16씩 증가
                count += 1;
            }

        } catch (EOFException e) {
            System.out.println("국어 총점: " + sum);
            System.out.println("국어 평균: " + sum / count);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

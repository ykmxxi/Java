package ch15.randomaccessfile;

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MakeFile {
    public static void main(String[] args) {
        int[] score = {
                1, 100, 90, 93,
                2, 30, 39, 88,
                3, 85, 100, 97,
                4, 10, 20, 30,
                5, 100, 95, 100}; // 번호, 국어점수, 영어점수, 수학점수

        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(
                    "/Users/ykm/Desktop/자바의정석/exam/src/ch15/randomaccessfile/score.dat", "rw");

            for (int i = 0; i < score.length; i++) {
                randomAccessFile.writeInt(score[i]);
            }

            while (true) {
                System.out.println(randomAccessFile.readInt());
            }
        } catch (EOFException e) {
            // readInt() 호출 시 더 읽을 내용이 없으면 발생
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

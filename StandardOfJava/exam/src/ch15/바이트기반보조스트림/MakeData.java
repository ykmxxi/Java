package ch15.바이트기반보조스트림;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MakeData {
    public static void main(String[] args) {
        int[] score = {100, 90, 95, 85, 50};

        try {
            FileOutputStream fos = new FileOutputStream("/Users/ykm/Desktop/자바의정석/exam/src/ch15/바이트기반보조스트림/score.dat");
            DataOutputStream dos = new DataOutputStream(fos);

            for (int i = 0; i < score.length; i++) {
                dos.writeInt(score[i]);
            }

            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

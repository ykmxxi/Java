package ch15.바이트기반스트림;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class ByteArrayIOTest {
    public static void main(String[] args) {
        int data = 0;
        byte[] inSrc = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        byte[] outSrc = null;

        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = null;

        input = new ByteArrayInputStream(inSrc);
        output = new ByteArrayOutputStream();

        while ((data = input.read()) != -1) { // 더 이상 읽어올 데이터가 없을 때 까지 반복
            output.write(data);
        }

        outSrc = output.toByteArray();

        System.out.println("Input Source: " + Arrays.toString(inSrc));
        System.out.println("Output Source: " + Arrays.toString(outSrc));
    }
}

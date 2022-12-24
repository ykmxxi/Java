package ch15.바이트기반보조스트림;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Arrays;
import java.util.Vector;

public class ConcatBySequence {
    public static void main(String[] args) {
        byte[] arr1 = {0, 1, 2};
        byte[] arr2 = {3, 4, 5};
        byte[] arr3 = {6, 7, 8};
        byte[] outSrc = null;

        Vector vector = new Vector();
        vector.add(new ByteArrayInputStream(arr1));
        vector.add(new ByteArrayInputStream(arr2));
        vector.add(new ByteArrayInputStream(arr3));

        SequenceInputStream input = new SequenceInputStream(vector.elements());
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        int data = 0;

        try {
            while ((data = input.read()) != -1) {
                output.write(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        outSrc = output.toByteArray();

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(outSrc));
    }
}

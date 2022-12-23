package ch15.바이트기반스트림;

import java.io.FileInputStream;
import java.io.IOException;

public class FileViewer {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        int data = 0;

        while ((data = fileInputStream.read()) != -1) {
            char c = (char) data;
            System.out.print(c);
        }
    }
}

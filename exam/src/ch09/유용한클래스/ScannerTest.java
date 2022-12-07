package ch09.유용한클래스;

import java.io.File;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) throws Exception {
        Scanner fileScanner = new Scanner(new File("src/ch09/유용한클래스/data.txt"));
        int count = 0;
        int total = 0;

        while (fileScanner.hasNextLine()) {
            String line = fileScanner.nextLine();
            Scanner scanner = new Scanner(line).useDelimiter(",");
            int sum = 0;

            while (scanner.hasNextInt()) {
                sum += scanner.nextInt();
            }

            System.out.println(line + ", sum = " + sum);
            total += sum;
            count++;
        }
        System.out.println("Line: " + count + ", Total: " + total);
    }
}
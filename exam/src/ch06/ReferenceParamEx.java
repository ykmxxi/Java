package ch06;

import java.util.Arrays;

public class ReferenceParamEx {

    public static void main(String[] args) {

        int[] arr = {3, 2, 5, 1, 6, 4};

        printArray(arr);
        sortArray(arr);
        printArray(arr);    // 참조형 매개변수는 read & write
        System.out.println(sumArray(arr));
    }

    static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    static void sortArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }

    }

    static int sumArray(int[] array) {

        int sum = 0;

        for (int element : array) {
            sum += element;
        }
        return sum;
    }
}

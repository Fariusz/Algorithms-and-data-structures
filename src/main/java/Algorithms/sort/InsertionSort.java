package Algorithms.sort;

import java.util.Arrays;

public class InsertionSort {
    public static int[] sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > temp) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = temp;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        System.out.println(Arrays.toString(sort(array)));
    }
}

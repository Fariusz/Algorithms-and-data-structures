package Algorithms.sort;

import java.util.Arrays;

public class SelectionSort {
    public static int[] sort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] > array[j]) {
                    min = j;
                }
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};

        System.out.println(Arrays.toString(sort(array)));
    }
}

package Algorithms.sort;

import java.util.Arrays;

public class BubbleSort {
    public static int[] sort(int[] array) {

        for (int i1 = 0; i1 < array.length; i1++) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        System.out.println(Arrays.toString(sort(array)));
    }
}

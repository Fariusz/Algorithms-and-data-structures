package Algorithms.sort;

import java.util.Arrays;

public class MergeSort {

    public static int[] sort(int[] array) {

        divide(array);
        return array;
    }

    private static void divide(int[] array) {

        if (array.length <= 1) {
            return;
        }

        int[] array1 = new int[(array.length / 2)];
        int[] array2 = new int[array.length - (array.length / 2)];

        System.arraycopy(array, 0, array1, 0, array.length / 2);

        if (array.length - array.length / 2 >= 0)
            System.arraycopy(array, array.length / 2, array2, array.length / 2 - array.length / 2, array.length - array.length / 2);

        divide(array1);
        divide(array2);
        merge(array1, array2, array);
    }

    private static void merge(int[] leftArray, int[] rightArray, int[] array) {

        int leftSize = array.length / 2;
        int rightSize = array.length - leftSize;
        int i = 0, l = 0, r = 0; //indices

        //check the conditions for merging
        while (l < leftSize && r < rightSize) {
            if (leftArray[l] < rightArray[r]) {
                array[i] = leftArray[l];
                i++;
                l++;
            } else {
                array[i] = rightArray[r];
                i++;
                r++;
            }
        }
        while (l < leftSize) {
            array[i] = leftArray[l];
            i++;
            l++;
        }
        while (r < rightSize) {
            array[i] = rightArray[r];
            i++;
            r++;
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        System.out.println(Arrays.toString(sort(array)));
    }
}

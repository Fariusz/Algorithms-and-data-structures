package Algorithms.sort;

import java.util.Arrays;

public class BubbleSortBidirectional {
    public static int[] sort(int[] array) {


        boolean nextIter = true;
        int left = 0;
        int right = array.length;

        while (nextIter) {
            nextIter = false;

            for (int i = left; i < right - 1; ++i) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    nextIter = true;
                }
            }

            if (!nextIter) {
                break;
            }

            right--;

            for (int i = right - 1; i >= left; i--) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    nextIter = true;
                }
            }
            left++;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        System.out.println(Arrays.toString(sort(array)));
    }
}

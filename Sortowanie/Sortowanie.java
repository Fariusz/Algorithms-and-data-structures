package polsl.pl.Sortowanie;

public class Sortowanie {

    public static int[] babelkowe(int[] input) {

        for (int i = 1, size = input.length; i < size; ++i) {

            boolean nextIter = false;

            for (int j = 0; j < size - i; ++j) {
                if (input[j] > input[j + 1]) {
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                    nextIter = true;
                }
            }

            if (!nextIter) {
                break;
            }
        }
        return input;
    }

    public static int[] babelkoweDwukierunkowe(int[] input) {

        boolean nextIter = true;
        int lewo = 0;
        int prawo = input.length;

        while (nextIter == true)
        {
            nextIter = false;

            for (int i = lewo; i < prawo - 1; ++i)
            {
                if (input[i] > input[i+1]){
                    int temp = input[i];
                    input[i] = input[i+1];
                    input[i+1] = temp;
                    nextIter = true;
                }
            }

            if(nextIter == false){
                break;
            }

            prawo--;

            for (int i = prawo - 1; i >= lewo; i--)
            {
                if (input[i] > input[i + 1]){
                    int temp = input[i];
                    input[i] = input[i+1];
                    input[i+1] = temp;
                    nextIter = true;
                }
            }
            lewo++;
        }
        return input;
    }

    public static int[] szybkie(int[] input) {
        doSort(input, 0, input.length - 1);
        return input;
    }

    private static void doSort(int[] array, int left, int right) {
        if (left < right) {
            int pivot = randomPartition(array, left, right);
            doSort(array, left, pivot - 1);
            doSort(array, pivot, right);
        }
    }

    private static int randomPartition(int[] array, int left, int right) {
        int randomIndex = left + (int) (Math.random() * (right - left + 1));
        swap(array, randomIndex, right);
        return partition(array, left, right);
    }

    private static int partition(int[] array, int left, int right) {
        int mid = (left + right) >>> 1;
        int pivot = array[mid];

        while (left <= right) {
            while (array[left] < pivot) {
                ++left;
            }
            while (pivot < array[right]) {
                --right;
            }
            if (left <= right) {
                swap(array, left, right);
                ++left;
                --right;
            }
        }
        return left;
    }

    static boolean swap(int[] array, int idx, int idy) {
        int swap = array[idx];
        array[idx] = array[idy];
        array[idy] = swap;
        return true;
    }

    private static int licznik;

    public static int[] scalanie(int[] input) {
        licznik=0;
        mergeSort(input, 0, input.length);
        return input;
    }

    private static void mergeSort(int[] list, int przod, int tyl)
    {
        int srodek = (przod+tyl)/2;
        if(srodek==przod) return;
        mergeSort(list, przod, srodek);
        mergeSort(list, srodek, tyl);
        merge(list, przod, tyl);
    }

    private static void merge(int[] list, int przod, int tyl)
    {
        int dif = tyl-przod;
        int[] temp = new int[dif];
        int beg = przod, srodek = (przod+tyl)/2;
        int tmpSrodek = srodek;
        int spot = 0;

        while(beg < tmpSrodek && srodek < tyl) {
            if(list[beg] < list[srodek]) {
                temp[spot++] = list[beg++];
            } else {
                temp[spot++] = list[srodek++];
            }
        }
        while(beg < tmpSrodek)
            temp[spot++] = list[beg++];
        while(srodek < tyl)
            temp[spot++] = list[srodek++];
        for(int i = 0; i < tyl-przod; i++) {
            list[przod+i] = temp[i];
        }
    }
}

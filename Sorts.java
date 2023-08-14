import java.util.Random;

public class Sorts {

    public static int[] createIntArray(int n) {
        int[] intArray = new int[n];
        Random r = new Random();
        for (int i = 0; i < n; i++) {
            intArray[i] = r.nextInt(10000);
        }
        return intArray;
    }

    public static int[] quickPartition(int[] array, int low, int high) {
        int comparisons = 0;
        int exchanges = 0;
        int pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            comparisons++;
            if (array[j] < pivot) {
                i++;
                //Swap with pivot
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                exchanges += 2;
            }
        }
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        exchanges += 2;
        return new int[]{i + 1, comparisons, exchanges};
    }

    public static int[] insertionSort(int[] array) {
        int comparisons = 0;
        int exchanges = 0;
        for (int i = 1; i < array.length; ++i) {
            int k = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > k) {
                comparisons++;
                exchanges++;
                array[j + 1] = array[j];
                j = j - 1;
            }
            exchanges++;
            array[j + 1] = k;
        }
        return new int[]{comparisons, exchanges};
    }

    public static int[] quickSort(int[] array, int low, int high) {
        int comparisons = 0;
        int exchanges = 0;
        comparisons++;
        if (low < high) {
            int[] parts = quickPartition(array, low, high);
            int pointer = parts[0];
            comparisons += parts[1];
            exchanges += parts[2];
            //left partition QuickSort
            int[] leftPart = quickSort(array, low, pointer - 1);
            comparisons += leftPart[0];
            exchanges += leftPart[1];
            //right partition QuickSort
            int[] rightPart = quickSort(array, pointer + 1, high);
            comparisons += rightPart[0];
            exchanges += rightPart[1];
        }
        return new int[]{comparisons, exchanges};
    }

    public static int[] shellSort(int[] array) {
        int comparisons = 0;
        int exchanges = 0;
        for (int i = array.length/2; i > 0; i /= 2) {
            for (int j = i; j < array.length; j += 1) {
                int temp = array[j];
                int k;
                for (k = j; k >= i && array[k - i] > temp; k -= i) {
                    comparisons++;
                    exchanges++;
                    array[j] = array[j - i];
                }
                exchanges++;
                array[j] = temp;
            }
        }
        return new int[]{comparisons, exchanges};
    }

}

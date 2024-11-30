import java.util.Arrays;

public class main {
    
    // QuickSort
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            // Recursively sort elements before and after partition
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Pivot element
        int i = low - 1; // Smaller element index
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // Swap arrays
                swap(array, i, j);
            }
        }
        // Swap array[i + 1] and pivot
        swap(array, i + 1, high);
        return i + 1;
    }

    
    private static void swap(int[] array, int i, int j) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // MergeSort
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            //sort
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];
        // Copy data to arrays
        System.arraycopy(array, left, leftArray, 0, n1);
        System.arraycopy(array, mid + 1, rightArray, 0, n2);
        int i = 0, j = 0, k = left;
        // Merge arrays
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            array[k++] = leftArray[i++];
        }
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    // BubbleSort
    public static void bubbleSort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Swap array[j] and array[j + 1]
                    swap(array, j, j + 1);
                }
            }
        }
    }

    // Test method
    public static void main(String[] args) {
        int[] array1 = {34, 7, 23, 32, 5, 62};
        int[] array2 = array1.clone();
        int[] array3 = array1.clone();

        // QuickSort
        System.out.println("Array for QuickSort: " + Arrays.toString(array1));
        quickSort(array1, 0, array1.length - 1);
        System.out.println("Sorted Array using QuickSort: " + Arrays.toString(array1));

        // MergeSort
        System.out.println("\nArray for MergeSort: " + Arrays.toString(array2));
        mergeSort(array2, 0, array2.length - 1);
        System.out.println("Sorted Array using MergeSort: " + Arrays.toString(array2));

        // BubbleSort
        System.out.println("\nArray for BubbleSort: " + Arrays.toString(array3));
        bubbleSort(array3);
        System.out.println("Sorted Array using BubbleSort: " + Arrays.toString(array3));
    }
}
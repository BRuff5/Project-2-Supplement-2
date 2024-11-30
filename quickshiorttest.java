import java.util.Arrays;

public class quickshiorttest {

    public static void main(String[] args) {
        // Test the QuickSort
        int[] array = {34, 7, 23, 32, 5, 62};
        System.out.println("Original array: " + Arrays.toString(array));

        quickSort(array, 0, array.length - 1);
        
        System.out.println("Sorted array: " + Arrays.toString(array));
    }

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
        int pivot = array[high];
        int i = low - 1; 
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
            }
        }
        
        swap(array, i + 1, high);
        return i + 1;
    }


    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
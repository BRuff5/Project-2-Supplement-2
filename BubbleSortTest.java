import java.util.Arrays;

public class BubbleSortTest {

    public static void main(String[] args) {
        // Run tests
        runTests();
    }

    private static void runTests() {
        // Test cases
        testSort(new int[]{34, 7, 23, 32, 5, 62}, new int[]{5, 7, 23, 32, 34, 62}); // Typical case
        testSort(new int[]{}, new int[]{});  // Empty array case
        testSort(new int[]{1}, new int[]{1});  // Single element case
        testSort(new int[]{-1, -5, 0, 3, 2}, new int[]{-5, -1, 0, 2, 3}); // Negative numbers
        testSort(new int[]{2, 3, 3, 2, 1, 1}, new int[]{1, 1, 2, 2, 3, 3}); // Duplicates
        testSort(new int[]{10, -10, 0, 100, 50}, new int[]{-10, 0, 10, 50, 100}); // Mixed numbers
        testSort(new int[]{5, 5, 5}, new int[]{5, 5, 5}); // All elements same
        testSort(new int[]{2, 1}, new int[]{1, 2}); // Two elements
    }

    private static void testSort(int[] input, int[] expected) {
        int[] arrayToSort = Arrays.copyOf(input, input.length); // Make a copy to sort
        bubbleSort(arrayToSort);
        
        if (Arrays.equals(arrayToSort, expected)) {
            System.out.println("Test passed for input: " + Arrays.toString(input));
        } else {
            System.out.println("Test failed for input: " + Arrays.toString(input) + 
                               ". Expected: " + Arrays.toString(expected) + 
                               ", but got: " + Arrays.toString(arrayToSort));
        }
    }

    // BubbleSort implementation
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

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
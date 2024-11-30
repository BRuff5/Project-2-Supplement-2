import java.util.Arrays;

public class mergesorttest {
    
    public static void main(String[] args) {
        // Run tests
        runTests();
    }

    private static void runTests() {
        // Test cases
        testSort(new int[]{34, 7, 23, 32, 5, 62}, new int[]{5, 7, 23, 32, 34, 62});
        testSort(new int[]{}, new int[]{});  // Empty array case
        testSort(new int[]{1}, new int[]{1});  // Single element case
        testSort(new int[]{-1, -5, 0, 3, 2}, new int[]{-5, -1, 0, 2, 3}); // Negative numbers
        testSort(new int[]{2, 3, 3, 2, 1, 1}, new int[]{1, 1, 2, 2, 3, 3}); // Duplicates
        testSort(new int[]{10, -10, 0, 100, 50}, new int[]{-10, 0, 10, 50, 100}); // Mixed numbers
    }

    private static void testSort(int[] input, int[] expected) {
        int[] arrayToSort = Arrays.copyOf(input, input.length); // Make a copy to sort
        mergeSort(arrayToSort, 0, arrayToSort.length - 1);
        
        if (Arrays.equals(arrayToSort, expected)) {
            System.out.println("Test passed for input: " + Arrays.toString(input));
        } else {
            System.out.println("Test failed for input: " + Arrays.toString(input) + 
                               ". Expected: " + Arrays.toString(expected) + 
                               ", but got: " + Arrays.toString(arrayToSort));
        }
    }

    // MergeSort implementation
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // Sort halves
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
}

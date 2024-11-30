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
}
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        // If there's only one element or an empty array, return false (AP requires at least 2 elements)
        if (arr.length <= 1) return false;

        // Sort the array using QuickSort
        quickSort(arr, 0, arr.length - 1);

        // Calculate the common difference using the first two elements
        int diff = arr[0] - arr[1];

        // Check if the difference remains consistent across the sorted array
        for (int index = 0; index < arr.length; index++) {
            if (index + 1 != arr.length) { // Ensure we don't go out of bounds
                int elmdiff = arr[index] - arr[index + 1];
                if (elmdiff != diff) {
                    return false; // If any difference is not equal to the initial `diff`, return false
                }
            }
        }
        return true; // If all differences match, return true (it's an AP)
    }

    /**
     * Recursive QuickSort function to sort the array in O(N log N) time on average.
     *
     * @param arr  The array to be sorted.
     * @param low  The starting index of the segment to be sorted.
     * @param high The ending index of the segment to be sorted.
     */
    private void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Find the partition index
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1); // Sort elements before pivot
            quickSort(arr, pi + 1, high); // Sort elements after pivot
        }
    }

    /**
     * Partition function for QuickSort.
     * It picks the last element as the pivot, places the pivot in its correct position,
     * and places smaller elements to the left and larger elements to the right.
     *
     * @param arr  The array being sorted.
     * @param low  The starting index of the segment to partition.
     * @param high The ending index (pivot element).
     * @return The index where the pivot is placed in the sorted segment.
     */
    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the last element as pivot
        int i = low; // Pointer for the smaller element

        // Iterate through the segment and move smaller elements before `i`
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { // Swap if current element is smaller than pivot
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }

        // Place the pivot in its correct position
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i; // Return the pivot index
    }
}

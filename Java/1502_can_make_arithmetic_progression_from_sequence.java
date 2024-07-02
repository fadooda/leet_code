import java.util.Arrays;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        // If there's less than 2 elements, we can't form an arithmetic progression
        if (arr.length < 2) return false; 
        
        // Sort the array in ascending order using Arrays.sort()
        // This uses Timsort (O(N log N) in worst/average case, O(N) in best case for nearly sorted data)
        Arrays.sort(arr);

        // Calculate the common difference of the arithmetic progression
        int diff = arr[1] - arr[0];

        // Iterate through the sorted array to check if every pair has the same difference
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != diff) {
                return false; // If any difference is not equal to `diff`, it's not an AP
            }
        }
        
        // If all differences match, return true (it's an AP)
        return true;
    }
}

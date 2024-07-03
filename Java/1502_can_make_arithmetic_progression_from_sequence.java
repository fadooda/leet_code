import java.util.HashSet;

class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        if (n < 2) return false;

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        HashSet<Integer> set = new HashSet<>();

        // Find min, max and store elements in HashSet
        for (int num : arr) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        // Check if (max - min) is perfectly divisible by (n - 1)
        if ((max - min) % (n - 1) != 0) return false;

        int diff = (max - min) / (n - 1);

        // Check if all expected elements exist in HashSet
        for (int i = 0; i < n; i++) {
            if (!set.contains(min + i * diff)) {
                return false;
            }
        }

        return true;
    }
}

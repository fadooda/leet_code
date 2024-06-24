import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        // Generate all permutations of p
        Set<String> permutations = new HashSet<>();
        generatePermutations("", p, permutations);

        // Check each substring of s
        for (int i = 0; i <= s.length() - p.length(); i++) {
            String sub = s.substring(i, i + p.length());
            if (permutations.contains(sub)) {
                result.add(i);
            }
        }

        return result;
    }

    // Recursive function to generate all permutations
    private void generatePermutations(String prefix, String remaining, Set<String> permutations) {
        if (remaining.length() == 0) {
            permutations.add(prefix);
            return;
        }
        for (int i = 0; i < remaining.length(); i++) {
            generatePermutations(prefix + remaining.charAt(i), 
                                 remaining.substring(0, i) + remaining.substring(i + 1), 
                                 permutations);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findAnagrams("cbaebabacd", "abc")); // Output: [0, 6]
    }
}

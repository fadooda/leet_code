import java.util.Arrays;

class Solution {
    public String longestPalindrome(String s) {
        // Edge case: If string is empty, return empty string.
        if (s == null || s.length() == 0) {
            return "";
        }

        // Preprocess string by adding boundary characters to handle even-length palindromes.
        char[] s2 = addBoundaries(s.toCharArray());
        
        int[] p = new int[s2.length]; // Array to store palindrome radii
        int c = 0, r = 0; // `c` is the center, `r` is the rightmost palindrome boundary
        
        int m = 0, n = 0; // Expanding indices for palindrome checking
        
        // Process each character in the transformed string
        for (int i = 1; i < s2.length; i++) {
            if (i > r) {
                // If `i` is beyond the right boundary `r`, start fresh
                p[i] = 0;
                m = i - 1;
                n = i + 1;
            } else {
                // Mirror index of `i` across the center `c`
                int i2 = c * 2 - i;
                
                // Use previously computed palindrome radius for symmetry
                if (p[i2] < (r - i - 1)) {
                    p[i] = p[i2];
                    m = -1; // Skip the while loop below
                } else {
                    p[i] = r - i;
                    n = r + 1;
                    m = i * 2 - n;
                }
            }

            // Expand around `i` while characters match
            while (m >= 0 && n < s2.length && s2[m] == s2[n]) {
                p[i]++;
                m--;
                n++;
            }

            // Update center and right boundary if we found a larger palindrome
            if ((i + p[i]) > r) {
                c = i;
                r = i + p[i];
            }
        }

        // Find the longest palindrome from the computed radii
        int len = 0, centerIndex = 0;
        for (int i = 1; i < s2.length; i++) {
            if (len < p[i]) {
                len = p[i];
                centerIndex = i;
            }
        }

        // Extract the longest palindrome and remove boundaries
        char[] longestPalindrome = Arrays.copyOfRange(s2, centerIndex - len, centerIndex + len + 1);
        return String.valueOf(removeBoundaries(longestPalindrome));
    }

    // Adds boundaries ('|') between characters and at the start/end
    private char[] addBoundaries(char[] cs) {
        if (cs == null || cs.length == 0) {
            return "||".toCharArray();
        }

        char[] cs2 = new char[cs.length * 2 + 1];
        for (int i = 0; i < cs2.length - 1; i += 2) {
            cs2[i] = '|'; // Boundary character
            cs2[i + 1] = cs[i / 2]; // Original character
        }
        cs2[cs2.length - 1] = '|'; // Ending boundary
        return cs2;
    }

    // Removes boundary characters from the final extracted palindrome
    private char[] removeBoundaries(char[] cs) {
        if (cs == null || cs.length < 3) {
            return "".toCharArray();
        }

        char[] cs2 = new char[(cs.length - 1) / 2];
        for (int i = 0; i < cs2.length; i++) {
            cs2[i] = cs[i * 2 + 1]; // Skip boundaries
        }
        return cs2;
    }
}

import java.util.Arrays;

class Solution {
    public String longestPalindrome(String s) {
        // Edge case: If string is empty, return empty string.
        if (s == null || s.length() == 0) {
            return "";
        }

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
    }
}

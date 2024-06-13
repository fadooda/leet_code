class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        
        StringBuilder result = new StringBuilder("1");
        
        for (int i = 1; i < n; i++) {
            StringBuilder next = new StringBuilder(result.length() * 2); // Pre-allocate space
            int count = 1;
            
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    next.append(count).append(result.charAt(j - 1));
                    count = 1;
                }
            }
            
            next.append(count).append(result.charAt(result.length() - 1));
            result = next; // Reuse reference instead of `.toString()`
        }

        return result.toString();
    }
}

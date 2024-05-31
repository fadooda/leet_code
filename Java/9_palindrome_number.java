import java.util.*; 
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
        String orig = Integer.toString(x);
        String palstr= new StringBuilder(orig).reverse().toString();
        if(orig.equals(palstr))
        {
            return true;
        }
        return false;
    }
}
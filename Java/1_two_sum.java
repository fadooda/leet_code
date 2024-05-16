import java.lang.reflect.Array;
class Solution {
    public int[] twoSum(int[] nums, int target) {
    	HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    	int x=0;
    	for(int elm : nums)
    	{
    		hmap.put(elm,x);
    		x++;
    	}
}
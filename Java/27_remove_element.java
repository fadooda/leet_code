class Solution {
    public int removeElement(int[] nums, int val) {
        int length=nums.length;
        for (int i=0; i<length;i++)
        {
        //System.out.println(nums[i]);   
            if (nums[i]==val)
            {   
                //System.out.println(nums[i]);
                length--;
          //System.out.println("at index " + i + " is " + nums[i]);  
                if (length > 0 )
                {
                    System.out.println(length);
                    while( length > 0 && i !=length && nums[length]==val )
                    {
                        //System.out.println(length);
                        length--;
                    }
                    nums[i]=nums[length];
                    nums[length]= val; 
                }
                     //System.out.println("at index " + i + " is " + nums[i]);      
            }
        //System.out.println("at index " + i + " is " + nums[i]);            
        }
        return length;
    }
}
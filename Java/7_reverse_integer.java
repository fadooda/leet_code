class Solution {
    public static int reverse(int x) {
        String reversednumber = String.valueOf(x);
        long reversenum=0;
        String hold=new StringBuilder(reversednumber).reverse().toString();
        int ispositive=1;
        if (x< 0)
        {
            ispositive=-1;
            reversenum = Long.parseLong(hold.substring(0,hold.length()-1));
        }    
        else{
            reversenum = Long.parseLong(hold);   
        }

        if (reversenum> Integer.MAX_VALUE || reversenum< Integer.MIN_VALUE)
        {
            return 0;
        }
        return ispositive * (int)reversenum;
    }
}
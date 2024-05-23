class Solution {
    public String longestPalindrome(String s) {
        //possible to use hash map for faster index processing *also there could be alot of index collisions*...
        String longestPal="";
        for(int i=0; i<s.length(); i++)
        {
            int nextchar=s.length();
            boolean foundPal=false;
           // int nextind=s.length();
            while (i!=nextchar && foundPal==false)
            {
                nextchar=s.lastIndexOf(s.charAt(i),nextchar-1);
                //System.out.println(nextchar);  
                //nextind=nextchar-1;
                //nextind++;
                if(nextchar!=-1)
                {
                    //System.out.println(nextchar);  
                    String orig= s.substring(i,nextchar+1);
                    //System.out.println(orig);   
                    String checkPal = new StringBuilder(orig).reverse().toString();
                   // System.out.println(checkPal);
                    if (orig.equals(checkPal))
                    {
                        foundPal=true;
                        //System.out.println(checkPal
                        //System.out.println(checkPal);
                        longestPal=(longestPal.length() < checkPal.length() )? checkPal: longestPal;
                        //System.out.println(longestPal);
                    }
                }
               // break;
            }
            
        }
        if (longestPal.length()==0)
        {
            if(s.length()==0)
            {
                return s;
            }
            Character test = s.charAt(0);
            return test.toString();
        }
         return longestPal; 
    }
}
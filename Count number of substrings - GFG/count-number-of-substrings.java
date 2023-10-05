//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
        public long countAtMostK(String s, int k) {
        long cnt = 0;
        int[] freq = new int[26];
        int i = 0, diff = 0;

        for (int j = 0; j < s.length(); ++j) {
            if (freq[s.charAt(j) - 'a'] == 0)
                ++diff;
            ++freq[s.charAt(j) - 'a'];

            while (diff > k && i <= j) {
                --freq[s.charAt(i) - 'a'];
                if (freq[s.charAt(i) - 'a'] == 0)
                    --diff;
                ++i;
            }
            cnt += j - i + 1;
        }

        return cnt;
    }

    public long substrCount(String s, int k) {
        return countAtMostK(s, k) - countAtMostK(s, k - 1);
    }
}
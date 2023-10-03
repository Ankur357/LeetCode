//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*; 
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
    		System.out.println (new Solution().colName (n));
        }
        
    }
}

// Contributed By: Pranay Bansal 

// } Driver Code Ends


//User function Template for Java

class Solution
{
    String colName (long n)
    {
        // your code here
        StringBuilder out = new StringBuilder();
        char[] code = new char[26];
        for (int i = 1; i < 26; ++i)
            code[i] = (char)('A' + i - 1);
        code[0] = 'Z';

        while (n > 0) {
            out.append(code[(int) (n % 26)]);
            if (n % 26 == 0)
                --n;
            n /= 26;
        }

        return out.reverse().toString();
    }
}
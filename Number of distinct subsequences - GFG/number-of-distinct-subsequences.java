//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.distinctSubsequences(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int distinctSubsequences(String s) {
        // code here
        int n = s.length();
        int mod = 1000000007;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] * 2;
            int lastOccur = last[s.charAt(i - 1) - 'a'];

            if (lastOccur != -1) {
                dp[i] -= dp[lastOccur];
                if (dp[i] < 0)
                    dp[i] += mod;
            }
            dp[i] %= mod;
            last[s.charAt(i - 1) - 'a'] = i - 1;
        }
        return (int) dp[n];
    }
}
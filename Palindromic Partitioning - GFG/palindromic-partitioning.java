//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String str)
    {
        // code here
        int n = str.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        check(0, n - 1, str, dp);
        return check(0, n - 1, str, dp);
    }
    static int check(int i, int j, String s, int[][] dp) {
        if (i >= j)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (isPalin(i, j, s))
            return dp[i][j] = 0;

        int out = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            if (isPalin(i, k, s)) {
                out = Math.min(out, 1 + check(k + 1, j, s, dp));
            }
        }
        return dp[i][j] = out;
    }
    static boolean isPalin(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] A = new int[N];
            
            for(int i=0 ; i<N ; i++){
                A[i] = Integer.parseInt(S[i]);
            }
            int target = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.findTargetSumWays(A,N, target));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int findTargetSumWays(int[] A , int N, int target) {
        // code here
        int sum=0;
        int mod = 1000000007;
        for(int i: A) sum+=i;
        if((sum+target)%2!=0) return 0;
        int s1 = (sum+target)/2;
        int[][] dp = new int[N+1][s1+1];
        for(int i=0;i<=s1;i++){
            dp[0][i] =0;
        }
        dp[0][0] = 1;
        
        for(int i=1;i<=N;i++){
            for(int j=0;j<=s1;j++){
                if(A[i-1]<=j){
                    dp[i][j] = (dp[i-1][j-A[i-1]] + dp[i-1][j])%mod;
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[N][s1];
    }
};
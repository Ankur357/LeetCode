class Solution {
    public int findTargetSumWays(int[] A, int target) {
        int sum=0;
        int N = A.length;
        for(int i: A) sum+=i;
        if (target > sum || target < -sum) return 0; 
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
                    dp[i][j] = dp[i-1][j-A[i-1]] + dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[N][s1];
    }
}
class Solution {
    public int coinChange(int[] coins, int sum) {
        int N = coins.length;
        int[][] dp = new int[N+1][sum+1];
        for(int i=0;i<=N;i++){
            for(int j=0;j<=sum;j++){
                if(j==0) dp[i][j] = 0;
                if(i==0) dp[i][j] = Integer.MAX_VALUE-1;
            }
        }
        for(int i=1;i<=sum;i++){
            if(i%coins[0]==0){
                dp[1][i] = i/coins[0];
            }
            else dp[1][i] = Integer.MAX_VALUE-1;
        }
        
        for(int i=2;i<=N;i++){
            for(int j=1;j<=sum;j++){
                if(coins[i-1]<=j){
                    dp[i][j] = Math.min(1+dp[i][j-coins[i-1]] , dp[i-1][j]);
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        if(dp[N][sum]==Integer.MAX_VALUE-1) return -1;
        return dp[N][sum];
    }
}
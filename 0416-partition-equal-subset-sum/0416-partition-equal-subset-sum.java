class Solution {
    public boolean canPartition(int[] arr) {
        int sum=0;
        for(int i:arr) sum+=i;
        if(sum%2!=0) return false;
        return subsetSum(arr,sum/2,arr.length);
    }
    static boolean subsetSum(int[] arr , int sum, int n){
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<sum+1;j++){
                if(i==0) dp[i][j] = false;
                if(j==0) dp[i][j] = true;
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
}
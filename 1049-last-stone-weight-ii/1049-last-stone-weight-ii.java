class Solution {
    public int lastStoneWeightII(int[] arr) {
        int sum=0;
        int n = arr.length;
	    for(int i:arr) sum+=i;
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
	    int min = Integer.MAX_VALUE;
	    for(int i=0;i<=sum/2;i++){
	        if(dp[n][i]){
	            min = Math.min(min,sum-2*i);
	        }
	    }
	    return min;
    }
}
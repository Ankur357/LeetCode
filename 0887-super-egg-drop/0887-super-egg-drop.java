class Solution {
    public int superEggDrop(int k, int n) {
        Integer[][] dp = new Integer[k+1][n+1];
	    return solve(k,n,dp);   
    }
    static int solve(int n, int k, Integer[][] dp){
	    if(dp[n][k]!=null) return dp[n][k];
	    if(k==0 || k==1) return k;
	    if(n==1) return k;
	    int min = Integer.MAX_VALUE;
        int l=1,h=k;
	    while(l<=h){
            int mid=(h+l)/2;
            int left=solve(n-1,mid-1,dp);
            int right=solve(n,k-mid,dp);
            int temp=1+Math.max(left,right);
            if(left<right) l=mid+1;
            else h=mid-1;
            min=Math.min(min,temp);
        }

	    return dp[n][k]= min;
	}
}
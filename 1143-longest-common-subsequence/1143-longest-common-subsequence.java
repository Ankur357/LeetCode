class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int x = text1.length();
        int y = text2.length();
        int[][] dp = new int[x+1][y+1];
        for(int i=0;i<=x;i++){
            for(int j=0;j<=y;j++){
                if(x==0 || y==0) dp[x][y] = 0;
            }
        }
        for(int i=1;i<=x;i++){
            for(int j=1;j<=y;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)) dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[x][y];
    }
}
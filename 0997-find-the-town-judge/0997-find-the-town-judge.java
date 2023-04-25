class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length<n-1) return -1;
        int[] trustedby = new int[n+1];
        int[] trusts = new int[n+1];
        for(int[] rel : trust){
            trusts[rel[0]]++;
            trustedby[rel[1]]++;
        }
        for(int i=1;i<n+1;i++){
            if(trusts[i]==0 && trustedby[i]==n-1) return i;
        }
        return -1;
    }
}
class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length+1;
        int[] count = new int[n+1];
        for(int[] edge: edges){
            int x = edge[0];
            int y = edge[1];
            count[x]++;
            count[y]++;
            if(count[x]>1) return x;
            if(count[y]>1) return y;
        }
        return -1;
    }
}
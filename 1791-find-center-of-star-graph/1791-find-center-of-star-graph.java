class Solution {
    public int findCenter(int[][] edges) {
        // int n = edges.length+1;
        // int[] count = new int[n+1];
        // for(int[] edge: edges){
        //     int x = edge[0];
        //     int y = edge[1];
        //     count[x]++;
        //     count[y]++;
        //     if(count[x]>1) return x;
        //     if(count[y]>1) return y;
        // }
        // return -1;
        
        Set<Integer> set = new HashSet<>();
        for(int[] edge : edges){
            if(set.contains(edge[0])) return edge[0];
            set.add(edge[0]);
            if(set.contains(edge[1])) return edge[1];
            set.add(edge[1]);
        }
        return -1;
        
    }
}
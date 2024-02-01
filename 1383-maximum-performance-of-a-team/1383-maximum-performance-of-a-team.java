class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] perf = new int[n][2];
        for(int i=0;i<n;i++){
            perf[i][0] = speed[i];
            perf[i][1] = efficiency[i];
        }
        Arrays.sort(perf, (a,b)-> b[1]-a[1]);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        long sum=0;
        long res=0;
        for(int i=0;i<n;i++){
            sum+=perf[i][0];
            min.add(perf[i][0]);
            res = Math.max(res,sum*perf[i][1]);
            if(min.size()==k){
                sum-=min.poll();
            }
        }
        return (int)(res%1000000007);
    }
}
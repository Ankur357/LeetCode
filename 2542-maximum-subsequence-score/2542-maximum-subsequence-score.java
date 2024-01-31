class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] res = new int[n][2];
        for(int i=0; i<n; i++){
            res[i] = new int[]{nums1[i], nums2[i]};
        }

        Arrays.sort(res, (a, b) -> b[1] - a[1]);

        long ans=0;
        long sum=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<n; i++){
            sum += res[i][0];
            pq.offer(res[i][0]);
            if(pq.size() == k){
                ans = Math.max(ans, sum*res[i][1]);
                sum -= pq.poll();
            }
        }
        return ans;
    }
}

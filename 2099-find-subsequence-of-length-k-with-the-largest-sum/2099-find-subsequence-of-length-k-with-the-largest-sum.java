class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> max = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        PriorityQueue<int[]> min = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(int i=0;i<nums.length;i++){
            max.add(new int[]{nums[i],i});
        }
        int[] res =new int[k];
        for(int i=0;i<k;i++){
            min.add(max.poll());
        }
        for(int i=0;i<k;i++) res[i] = min.poll()[0];
        return res;
    }
}
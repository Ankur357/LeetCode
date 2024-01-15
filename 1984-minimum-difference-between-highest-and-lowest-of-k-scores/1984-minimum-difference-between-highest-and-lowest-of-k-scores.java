class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        if(k==1) return 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n-k+1;i++){
            int diff = Math.abs(nums[i]-nums[i+k-1]);
            min = Math.min(min,diff);
        }
        return min;
    }
}
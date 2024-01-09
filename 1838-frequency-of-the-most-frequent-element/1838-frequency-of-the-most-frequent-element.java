class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0;
        int j=0;
        long sum=0;
        int max = 0;
        while(j<nums.length){
            sum+=nums[j];
            while((long)nums[j]*(j-i+1)-sum>k){
                sum-=nums[i];
                i++;
            }
            max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
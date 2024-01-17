class Solution {
    public int[] rearrangeArray(int[] nums) {
        for(int i=1;i<nums.length-1;i++){
            if((nums[i-1]>nums[i])&&(nums[i]>nums[i+1]) || 
               (nums[i-1]<nums[i])&&(nums[i]<nums[i+1])){
                int tmp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] =tmp;
            }
        }
        return nums;
    }
}
class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<=nums.length;i++){
            if(i==nums.length) return nums.length;
            if(nums[i]!=i) return i;
        }
        return -1;
    }
}
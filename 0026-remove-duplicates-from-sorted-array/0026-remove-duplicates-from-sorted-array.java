class Solution {
    public int removeDuplicates(int[] nums) {
        int nextDup = 1;
        for(int i=1;i<nums.length;i++){
            if(nums[nextDup-1]!=nums[i]){
                nums[nextDup] = nums[i];
                nextDup++;
            }
        }
        return nextDup;
    }
}
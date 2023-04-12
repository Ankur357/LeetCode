class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int max = nums[0];
        for(int num: nums){
            if(count==0){
                count++;
                max=num;
            }
            else if(max==num) count++;
            else count--;
        }
        return max;
    }
}
class Solution {
    public int minOperations(int[] nums, int x) {
        int target = -x;
        for(int num: nums) target+=num;
        if(target==0) return nums.length;
        int i=0, j=0, sum=0, max=-1;
        while(j<nums.length){
            sum+=nums[j];
            while(i<=j && sum>target){
                sum-=nums[i];
                i++;
            }
            if(sum==target){
                max = Math.max(max,j-i+1);
            }
            j++;
        }
        return max==-1?-1:nums.length-max;
    }
}
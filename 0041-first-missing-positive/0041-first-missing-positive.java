class Solution {
    public int firstMissingPositive(int[] nums) {
        for(int i=0 ; i<nums.length; ) {
			if(nums[i]<=0 || nums[i]>=nums.length || nums[i]-1== i || nums[i]==nums[nums[i]-1] )i++;
			else {
				int index= nums[i]-1; 
			    int temp = nums[index]; 
				nums[index]= nums[i];
				nums[i]= temp;
			}
		}
		for(int i=0 ; i<nums.length ; i++) {
			if(nums[i]-1!=i) {
				return i+1;
			}
		}
		return nums.length+1;
    }
}
class Solution {
    public int removeDuplicates(int[] nums) {
        // int i=0;
        // int j=0;
        // while(j<nums.length){
        //     int count=1;
        //     while(j+1<nums.length && nums[j]==nums[j+1]){
        //         j++;
        //         count++;
        //     }
        //     int min = Math.min(2,count);
        //     for(int k=0;k<min;k++){
        //         nums[i]=nums[j];
        //         i++;
        //     }
        //     j++;
        // }
        // return i;
        
        
        //for remove k duplicates replace 2 by k
        int i = 0;
        for (int n : nums)
        if (i < 2 || n > nums[i-2])
            nums[i++] = n;
        return i;
    }
}
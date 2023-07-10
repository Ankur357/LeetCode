class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int c = 0, lastSmall = Integer.MIN_VALUE, longestSeq = 1;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(lastSmall + 1 != nums[i] && lastSmall != nums[i]) {
                c = 1;
                lastSmall = nums[i];
            } 
            if(lastSmall + 1 == nums[i]) {
                c++;
                lastSmall = nums[i];
            }

            longestSeq = Math.max(longestSeq, c);
        }
        return longestSeq;
    }
}
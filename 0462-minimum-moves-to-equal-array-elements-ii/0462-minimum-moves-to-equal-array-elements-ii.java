class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid=nums.length/2;
        int sum=0;
        for(int num: nums){
            sum+=Math.abs(nums[mid]-num);
        }
        return sum;
    }
}
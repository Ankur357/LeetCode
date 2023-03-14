class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int i=0;
        int j = nums.length-1;
        int idx=j;
        while(i<=j){
            if(nums[i]*nums[i]>nums[j]*nums[j]){
                arr[idx--] = nums[i]*nums[i];
                i++;
            }
            else{
                arr[idx--] = nums[j]*nums[j];
                j--;
            }
        }
        return arr;
    }
}
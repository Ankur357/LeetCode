class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int n = nums.length;
        int low= 1;
        int high =n-2;
        while(low<=high){
            int mid = (low+high)/2;
            if((nums[mid]>nums[mid-1]) && nums[mid]>nums[mid+1]) return mid;
            if(nums[mid]>nums[mid-1]) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}
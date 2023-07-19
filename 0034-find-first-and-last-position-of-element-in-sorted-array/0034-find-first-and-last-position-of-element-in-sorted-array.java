class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{first(nums,target),second(nums,target)};
    }
    static int first(int[] nums, int target){
        int l = 0;
        int h =nums.length-1;
        int ans = -1;
        while(l<=h){
            int m = l + (h-l)/2;
            if(nums[m]==target){
                ans = m;
                h = m-1;
            }
            else if(nums[m]<target) l = m+1;
            else h = m-1;
        }
        return ans;
    }
    static int second(int[] nums, int target){
        int l = 0;
        int h =nums.length-1;
        int ans = -1;
        while(l<=h){
            int m = l + (h-l)/2;
            if(nums[m]==target){
                ans = m;
                l = m+1;
            }
            else if(nums[m]<target) l = m+1;
            else h = m-1;
        }
        return ans;
    }
}
class Solution {
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }
    static int binarySearch(int[] arr , int low , int high, int target){
        if(low>high) return -1;
        int mid = low + (high-low)/2;
        if(arr[mid]==target) return mid;
        else if(target>arr[mid]){
            return binarySearch(arr,mid+1,high,target);
        }
        return binarySearch(arr,low,mid-1,target);
    }
}
class Solution {
    public static int sumD(int[] nums ,int k){
        int sum=0;
        for(int num:nums){
            sum += Math.ceil((double)num/(double)k);
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            max = Math.max(max,num);
        }
        int low=1;
        int high = max;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(sumD(nums,mid)<=threshold){
                high = mid-1;
            }
            else low = mid+1;
        }
        return low;
    }
}
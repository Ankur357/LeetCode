class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int smallDiff = Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++){
            int l = i+1;
            int r= n-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(Math.abs(target-sum)<Math.abs(target-smallDiff)){
                    smallDiff = sum;
                }
                if(sum>target) r--;
                else l++;
            }
        }
        return smallDiff;
    }
}
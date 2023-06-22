class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int product=1;
        for(int i=0;i<nums.length;i++){
            product*=nums[i];
            max= Math.max(max,product);
            if(nums[i]==0){
                product=1;
            }
        }
        product=1;
        for(int i=nums.length-1;i>=0;i--){
            product*=nums[i];
            max = Math.max(max,product);
            if(nums[i]==0) product=1;
        }
        return max;
    }
}
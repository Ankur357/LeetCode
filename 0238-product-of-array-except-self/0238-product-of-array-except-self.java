class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        int tmp=1;
        
        //storing product of left elements
        for(int i=0;i<nums.length;i++){
            arr[i] = tmp;
            tmp *=nums[i];
        }
        tmp=1;
        
        //storing product of right elements
        for(int i= nums.length-1;i>=0;i--){
            arr[i] = arr[i]*tmp;
            tmp*=nums[i];
        }
        return arr;
    }
}
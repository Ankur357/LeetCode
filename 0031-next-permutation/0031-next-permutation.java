class Solution {
    public void nextPermutation(int[] nums) {
        int index=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1){
            reverse(nums,0,nums.length-1);
            return;
        }
        
        for(int i=nums.length-1;i>0;i--){
            if(nums[index]<nums[i]){
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
                break;
            }
        }
        reverse(nums,index+1,nums.length-1);
    }
    
    public static void reverse(int[] arr, int s , int e){
        while(s<e){
            int tmp = arr[s];
            arr[s] = arr[e];
            arr[e] = tmp;
            s++;
            e--;
        }
    }
}
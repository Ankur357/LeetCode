class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int secondMax = Integer.MIN_VALUE;
        for(int i = nums.length-1;i>=0;i--){
            if(nums[i]<secondMax) return true;
            while(!st.isEmpty() && st.peek()<nums[i]){
                secondMax = Math.max(st.pop(),secondMax);
            }
            st.push(nums[i]);
        }
        return false;
    }
}
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] res = new int[n];
        for(int i=2*n-1;i>=0;i--){
            if(st.isEmpty()) res[i%n] = -1;
            else if(!st.isEmpty() && st.peek()>nums[i%n]) res[i%n] = st.peek();
            else if(!st.isEmpty() && st.peek()<=nums[i%n]){
                while(!st.isEmpty() && st.peek()<=nums[i%n]) st.pop();
                if(st.isEmpty()) res[i%n] =-1;
                else res[i%n] = st.peek();
            }
            st.push(nums[i%n]);
        }
        return res;
    }
}
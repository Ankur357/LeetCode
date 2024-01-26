class Solution {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]) st.pop();
            leftSmaller[i] = st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]) st.pop();
            rightSmaller[i] = st.isEmpty()?n:st.peek();
            st.push(i);
        }
        int mod = (int) 1e9 + 7;
        long answer = 0;
      
        for (int i = 0; i <n; ++i) {
            answer += (long) (i - leftSmaller[i]) * (rightSmaller[i] - i) % mod * arr[i] % mod;
            answer %= mod;
        }
      
        return (int) answer;
    }
}
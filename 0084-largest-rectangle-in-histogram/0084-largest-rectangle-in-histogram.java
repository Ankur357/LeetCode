class Solution {
    public int largestRectangleArea(int[] heights) {
       int n = heights.length;
        int[] left = nsl(heights,n);
        int[] right = nsr(heights,n);
        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int area = (right[i]-left[i]-1)*heights[i];
            maxArea = Math.max(maxArea,area);
        }
        return maxArea; 
    }
    static int[] nsl(int arr[], int n){
        Stack<int[]> st = new Stack<>();
        int idx=-1;
        int[] left = new int[n];
        for(int i=0;i<n;i++){
            if(st.isEmpty()) left[i] = idx;
            else if(!st.isEmpty() && st.peek()[0]<arr[i]) 
                left[i] = st.peek()[1];
            else if(!st.isEmpty() && st.peek()[0]>=arr[i]){
                while(!st.isEmpty() && st.peek()[0]>=arr[i]) st.pop();
                if(st.isEmpty()) left[i] = idx;
                else left[i] = st.peek()[1];
            }
            st.push(new int[]{arr[i],i});
        }
        return left;
    }
    static int[] nsr(int arr[], int n){
        Stack<int[]> st = new Stack<>();
        int idx=n;
        int[] right = new int[n];
        for(int i=n-1;i>=0;i--){
            if(st.isEmpty()) right[i] = idx;
            else if(!st.isEmpty() && st.peek()[0]<arr[i]) 
                right[i] = st.peek()[1];
            else if(!st.isEmpty() && st.peek()[0]>=arr[i]){
                while(!st.isEmpty() && st.peek()[0]>=arr[i]) st.pop();
                if(st.isEmpty()) right[i] = idx;
                else right[i] = st.peek()[1];
            }
            st.push(new int []{arr[i],i});
        }
        return right;
    } 
}
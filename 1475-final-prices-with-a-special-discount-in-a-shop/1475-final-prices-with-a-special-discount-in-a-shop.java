class Solution {
    public int[] finalPrices(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
	    Stack<Integer> st = new Stack<>();
	    for(int i=n-1;i>=0;i--){
	        if(st.isEmpty()) res[i] = arr[i];
	        else if(!st.isEmpty() && arr[i]>=st.peek()) res[i] = arr[i]-st.peek();
	        else if(!st.isEmpty() && arr[i]<st.peek()){
	            while(!st.isEmpty() && arr[i]<st.peek()) st.pop();
	            if(st.isEmpty()) res[i] = arr[i];
	            else res[i] = arr[i]-st.peek();
	        }
	        st.push(arr[i]);
	    }
	    return res;  
    }
}
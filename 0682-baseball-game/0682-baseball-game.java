class Solution {
    public int calPoints(String[] operations) {
        int sum=0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<operations.length;i++){
            String s = operations[i];
            if(s.equals("C")){
                sum-=st.pop();
            } 
            else if(s.equals("D")){
                int d = st.peek();
                st.push(2*d);
                sum+=2*d;
            }
            else if(s.equals("+")){
                int v1 = st.pop();
                int v2 = st.pop();
                st.push(v2);
                st.push(v1);
                st.push(v1+v2);
                sum+=v1+v2;
            }
            else{
                sum+=Integer.parseInt(s);
                st.push(Integer.parseInt(s));
            }
        }
        return sum;
    }
}
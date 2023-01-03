class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String str: tokens){
            if("+-/*".contains(str)){
                st.push(helper(st.pop(),st.pop(),str));
            }
            else st.push(Integer.parseInt(str));
        }
        return st.pop();
    }
    private int helper(int b, int a, String oper){
        if("+".equals(oper)) return a+b;
        else if("-".equals(oper)) return a-b;
        else if("/".equals(oper)) return a/b;
        else return a*b;
    }
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<char[]> st = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(!st.isEmpty() && st.peek()[0]==ch) st.peek()[1]++;
            else st.push(new char[]{ch,1});
            if(st.peek()[1]==k) st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            char[] pair = st.pop();
            sb.append(String.valueOf(pair[0]).repeat(pair[1]));
        }
        return sb.reverse().toString();
    }
}
class Solution {
    public String decodeString(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(char ch: s.toCharArray()){
            if(ch!=']') st.push(ch);
            else{
                while(!st.isEmpty() && Character.isLetter(st.peek())){
                    sb.insert(0,st.pop());
                }
                String sub = sb.toString();
                st.pop(); //for'['
                
                sb = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek())){
                    sb.insert(0,st.pop());
                }
                int count = Integer.valueOf(sb.toString());
                 sb= new StringBuilder();
                while(count>0){
                    for(char c: sub.toCharArray()){
                        st.push(c);
                    }
                    count--;
                }
            }
        }
        sb= new StringBuilder();
        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        return sb.toString();
    }
}
class FreqStack {
    HashMap<Integer,Integer> map;
    HashMap<Integer,Stack> st;
    int maxFreq;
    public FreqStack() {
        map = new HashMap<>();
        st = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        map.put(val,map.getOrDefault(val,0)+1);
        int freq = map.get(val);
        if(freq>maxFreq) maxFreq = freq;
        Stack<Integer> s = new Stack<>();
        if(st.containsKey(freq)) s = st.get(freq);
        s.push(val);
        st.put(freq,s);
    }
    
    public int pop() {
        Stack<Integer> s = st.get(maxFreq);
        int ans = s.pop();
        map.put(ans,map.get(ans)-1);
        if(st.get(maxFreq).size()==0){
            st.remove(maxFreq);
            maxFreq--;
        }
        return ans;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
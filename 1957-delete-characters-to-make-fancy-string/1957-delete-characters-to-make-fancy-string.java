class Solution {
    public String makeFancyString(String s) {
        int n= s.length();
        StringBuilder str = new StringBuilder();
        str.append(s.charAt(0));
        int count=1;
        char prev = s.charAt(0);
        for(int i=1;i<n;i++){
            char c = s.charAt(i);
            if(c==s.charAt(i-1)) count++;
            else{
                prev=c;
                count=1;
            }
            if(count<3) str.append(c);
        }
        return str.toString();
    }
}
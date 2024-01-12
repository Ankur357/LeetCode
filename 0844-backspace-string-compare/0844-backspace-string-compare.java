class Solution {
    public boolean backspaceCompare(String s, String t) {
        String s1 = check(s);
        String s2 = check(t);
        return s1.equals(s2);
    }
    public static String check(String s){
        StringBuilder sb= new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='#') sb.append(s.charAt(i));
            else if(sb.length()!=0) sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}
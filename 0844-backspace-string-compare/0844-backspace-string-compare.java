class Solution {
    public boolean backspaceCompare(String s, String t) {
        int index1 = s.length()-1;
        int index2 = t.length()-1;
        while(index1>=0 || index2>=0){
            int n1 = checkCharIndex(s,index1);
            int n2 = checkCharIndex(t,index2);
            if(n1<0 && n2<0) return true;
            if(n1<0 || n2<0) return false;
            if(s.charAt(n1)!=t.charAt(n2)) return false;
            index1 = n1-1;
            index2 = n2-1;
        }
        return true;
    }
    static int checkCharIndex(String str, int index){
        int count=0;
        while(index>=0){
            if(str.charAt(index)=='#') count++;
            else if(count>0) count--;
            else break;
            index--;
        }
        return index;
    }
}
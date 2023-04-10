class Solution {
    public boolean rotateString(String s, String goal) {
      if(s.length()!=goal.length()) return false;
        if((s+s).indexOf(goal)>-1) return true;
        return false;
    }
}
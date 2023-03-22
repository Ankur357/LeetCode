class Solution {
    public int longestContinuousSubstring(String s) {
        int max=1;
        int count=1;
        for(int i=0;i<s.length()-1;i++){
            if((int)s.charAt(i)+1==(int)s.charAt(i+1)){
                count++;
                max = Math.max(max,count);
            }
            else count=1;
        }
        return max;
    }
}
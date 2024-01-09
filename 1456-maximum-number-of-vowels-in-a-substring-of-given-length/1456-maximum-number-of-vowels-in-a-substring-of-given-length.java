class Solution {
    public int maxVowels(String s, int k) {
        int count=0;
        int i=0;
        int j=0;
        int max = 0;
        while(j<s.length()){
            if(s.charAt(j)=='a' || s.charAt(j)=='e' || s.charAt(j)=='i' || 
               s.charAt(j)=='o' || s.charAt(j)=='u') count++;
            if(j-i+1==k){
                max = Math.max(max,count);
                if(s.charAt(i)=='a' || s.charAt(i)=='e' || s.charAt(i)=='i' || 
               s.charAt(i)=='o' || s.charAt(i)=='u') count--;
                i++;
            }
            j++;
        }
        return max;
    }
}
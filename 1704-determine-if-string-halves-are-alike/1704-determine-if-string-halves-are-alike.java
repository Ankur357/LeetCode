class Solution {
    public boolean halvesAreAlike(String s) {
        String str = s.toLowerCase();
        int n= s.length();
        int count1=0;
        int count2=0;
        for(int i=0;i<n;i++){
            if(i<n/2){
                if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u') count1++;
            }
            else{
                if(str.charAt(i)=='a' || str.charAt(i)=='e' || str.charAt(i)=='i' || str.charAt(i)=='o' || str.charAt(i)=='u') count2++;
            }
        }
        return count1==count2;
    }
}
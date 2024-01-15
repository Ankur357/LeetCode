class Solution {
    public String mergeAlternately(String word1, String word2) {
        int n = word1.length()>word2.length()?word1.length():word2.length();
        int i=0;
        int j=0;
        StringBuilder sb = new StringBuilder();
        for(int k=0;k<n;k++){
            if(i<word1.length()) sb.append(word1.charAt(i++));
            if(j<word2.length()) sb.append(word2.charAt(j++));
        }
        return sb.toString();
    }
}
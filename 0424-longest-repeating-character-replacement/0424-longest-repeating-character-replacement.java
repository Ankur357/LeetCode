class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int max = 0;
        int maxCnt = 0;
        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            maxCnt = Math.max(maxCnt,map.get(s.charAt(j)));
            if(j-i+1-maxCnt>k){
                map.put(s.charAt(i),map.get(s.charAt(i))-1);
                i++;
            }
            max = Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}
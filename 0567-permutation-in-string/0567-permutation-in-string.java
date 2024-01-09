class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }
        int i=0;
        int j=0;
        int count= map.size();
        while(j<s2.length()){
            if(map.containsKey(s2.charAt(j))){
                map.put(s2.charAt(j),map.get(s2.charAt(j))-1);
                if(map.get(s2.charAt(j))==0) count--;;
           }
            if(j-i+1==s1.length()){
                if(count==0) return true;
                if(map.containsKey(s2.charAt(i))){
                    map.put(s2.charAt(i),map.get(s2.charAt(i))+1);
                    if(map.get(s2.charAt(i))==1) count++;
                }
                i++;
            }
            j++;
        }
        return false;
    }
}
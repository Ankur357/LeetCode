class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr1 = new int[26];
        for(int i=0;i<s1.length();i++){
            arr1[s1.charAt(i)-'a']++;
        }
        int[] arr2 = new int[26];
        for(int i=0;i<s2.length();i++){
            arr2[s2.charAt(i)-'a']++;
            if(i>=s1.length()){
                arr2[s2.charAt(i-s1.length())-'a']--;
            }
            if(Arrays.equals(arr1,arr2)) return true;
        }
        return false;
    }
}
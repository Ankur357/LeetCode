class Solution {
    public List<Integer> findAnagrams(String txt, String pat) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i=0;i<pat.length();i++){
            map.put(pat.charAt(i), map.getOrDefault(pat.charAt(i),0)+1);
        }
        int i=0;
        int j=0;
        int cnt = map.size();
        int k = pat.length();
        int n =txt.length();
        List<Integer> list  = new ArrayList<>();
        while (j < n) {
        if (map.containsKey(txt.charAt(j))) {
            int val = map.get(txt.charAt(j));
            map.put(txt.charAt(j), val - 1);
            if (val == 1) {
                cnt--;
            }
        }
        if (j - i + 1 < k) {
            j++;
        } else if (j - i + 1 == k) {
            if (cnt == 0) {
                list.add(i);
            }
            if (map.containsKey(txt.charAt(i))) {
                int v = map.get(txt.charAt(i));
                if (v == 0) {
                    cnt++;
                }
                map.put(txt.charAt(i), v + 1);
            }
            i++;
            j++;
        }
    }
        return list;
    }
}
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> map =new HashMap<>();
        for(String word: words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        List<Integer> res= new ArrayList<>();
        int wordLength= words[0].length();
        int totalWords = words.length;
        for(int i=0;i<=s.length()-wordLength*totalWords;i++){
            HashMap<String,Integer> seenWord = new HashMap<>();
            int j=0;
            while(j<totalWords){
                int nextWord = i + j*wordLength;
                String word = s.substring(nextWord,nextWord+wordLength);
                if(!map.containsKey(word)) break;
                seenWord.put(word,seenWord.getOrDefault(word,0)+1);
                if(seenWord.get(word)>map.get(word)) break;
                j++;
            }
            if(j==totalWords) res.add(i);
        }
        return res;
    }
}
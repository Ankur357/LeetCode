class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch: s.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);
        PriorityQueue<Character> max = new PriorityQueue<>((a,b) -> map.get(b)-map.get(a));
        max.addAll(map.keySet());
        StringBuilder sb = new StringBuilder();
        while(max.size()>1){
            char c1 = max.poll();
            char c2 = max.poll();
            sb.append(c1);
            sb.append(c2);
            map.put(c1,map.get(c1)-1);
            map.put(c2,map.get(c2)-1);
            if(map.get(c1)>0) max.add(c1);
            if(map.get(c2)>0) max.add(c2);
        }
        if(!max.isEmpty()){
            char c = max.poll();
            if(map.get(c)>1) return "";
            sb.append(c);
        }
        return sb.toString();
    }
}
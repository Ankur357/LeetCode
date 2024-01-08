class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int j=0;
        int i=0;
        while(j<cards.length){
            if(!map.containsKey(cards[j])){
                map.put(cards[j],map.getOrDefault(cards[j],0)+1);
            }
            else{
                while(cards[i]!=cards[j]){
                    map.remove(cards[i]);
                    i++;
                }
                min = Math.min(min,j-i+1);
                map.put(cards[j],j);
                i++;
            }
            j++;
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
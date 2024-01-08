class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int j=0;
        while(j<cards.length){
            if(map.get(cards[j])!=null){
                min = Math.min(min,j-map.get(cards[j])+1);
            }
            map.put(cards[j],j);
            j++;
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}
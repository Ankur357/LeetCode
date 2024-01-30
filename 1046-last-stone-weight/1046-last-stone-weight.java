class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone: stones) max.add(stone);
        while(!max.isEmpty()){
            if(max.size()==1) return max.peek();
            int x =max.poll();
            int y = max.poll();
            if(x!=y) max.offer(Math.abs(x-y));
        }
        return 0;
    }
}
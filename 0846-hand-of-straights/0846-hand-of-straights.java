class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int i: hand) min.add(i);
        while(!min.isEmpty()){
            int start = min.poll();
            for(int i=1;i<groupSize;i++){
                if(min.remove(start+i)) continue;
                else return false;
            }
        }
        return true;
    }
}
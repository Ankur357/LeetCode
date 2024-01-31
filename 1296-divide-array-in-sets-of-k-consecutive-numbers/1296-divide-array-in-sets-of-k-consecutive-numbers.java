class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
      PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int i: nums) min.add(i);
        while(!min.isEmpty()){
            int start = min.poll();
            for(int i=1;i<k;i++){
                if(min.remove(start+i)) continue;
                else return false;
            }
        }
        return true;  
    }
}
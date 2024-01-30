class KthLargest {
    final PriorityQueue<Integer> min= new PriorityQueue<>();
    final int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int num: nums) add(num);
    }
    
    public int add(int val) {
        if(min.size()<k) min.offer(val);
        else if(val>min.peek()){
            min.poll();
            min.offer(val);
        }
        return min.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
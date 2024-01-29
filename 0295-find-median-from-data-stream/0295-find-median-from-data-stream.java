class MedianFinder {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>((a,b) -> a-b);
        max = new PriorityQueue<>((a,b) -> b-a);
    }
    
    public void addNum(int num) {
        if(max.size()==0 || max.peek()>=num) max.add(num);
        else min.add(num);
        
        if(max.size()>min.size()+1) min.add(max.poll());
        if(max.size()<min.size()) max.add(min.poll());
    }
    
    public double findMedian() {
        if(max.size()==min.size()) return max.peek()/2.0 +min.peek()/2.0;
        else return max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
class SeatManager {
    PriorityQueue<Integer> min;
    public SeatManager(int n) {
        min = new PriorityQueue<>();
        for(int i=1;i<=n;i++) min.add(i);
    }
    
    public int reserve() {
        return min.poll();
    }
    
    public void unreserve(int seatNumber) {
        min.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
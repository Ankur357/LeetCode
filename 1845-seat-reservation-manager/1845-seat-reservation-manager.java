class SeatManager {
    PriorityQueue<Integer> min;
    int marker;
    public SeatManager(int n) {
        min = new PriorityQueue<>();
        marker=1;
    }
    
    public int reserve() {
        if(!min.isEmpty())
            return min.poll();
        int seat = marker++;
        return seat;
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
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
         Arrays.sort(trips, (trip1, trip2) -> trip1[1] - trip2[1]);
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (arr1, arr2) -> arr1[0] - arr2[0]);
        
        for(int i = 0 ; i < trips.length ; i++) {
            int numPassengers = trips[i][0];
            int from = trips[i][1];
            int to = trips[i][2];

            if(heap.size() > 0 && heap.peek()[0] <= from) {
                while(heap.size() > 0 && heap.peek()[0] <= from) {
                    int[] prev = heap.poll();
                    capacity += prev[1];
                }
            }
            capacity -= numPassengers;
            if(capacity < 0) return false;
            heap.add(new int[]{to, numPassengers});
        }        
        return true;
    }
}
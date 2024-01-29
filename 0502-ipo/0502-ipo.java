class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> max = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        PriorityQueue<int[]> min = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for(int i=0;i<profits.length;i++){
            min.add(new int[]{capital[i],profits[i]});
        }
        for(int i=0;i<k;i++){
            while(!min.isEmpty() && min.peek()[0]<=w){
                max.add(min.poll());
            }
            if(max.size()==0) break;
            w+=max.poll()[1];
        }
        return w;
    }
}
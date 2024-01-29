class Solution {
    public int[] findRightInterval(int[][] intervals) {
        PriorityQueue<int[]> minEnd = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        PriorityQueue<int[]> minStart = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int[] res  =new int[intervals.length];
        Arrays.fill(res,-1);
        for(int i=0;i<intervals.length;i++){
            minEnd.add(new int[]{intervals[i][1],i});
            minStart.add(new int[]{intervals[i][0],i});
        }
        while(!minEnd.isEmpty()){
            int[] end = minEnd.poll();
            while(!minStart.isEmpty() && end[0]>minStart.peek()[0]) minStart.poll();
            if(minStart.size()==0) return res;
            res[end[1]] = minStart.peek()[1];
        }
        return res;
    }
}

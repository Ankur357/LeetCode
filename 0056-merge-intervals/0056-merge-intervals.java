class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> list = new ArrayList<>();
        int[] current = intervals[0];
        list.add(current);
        for(int[] next:intervals){
            if(current[1]>=next[0]) current[1] = Math.max(current[1],next[1]);
            else{
                current=next;
                list.add(current);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}
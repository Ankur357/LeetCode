class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0) return tasks.length;
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> q = new LinkedList<>();
        int[] arr = new int[26];
        for(char task:tasks){
            arr[task-'A']++;
        }
        for(int i:arr) if(i>0) max.add(i);
        int time=0;
        while(!max.isEmpty() || !q.isEmpty()){
            time++;
            if(!max.isEmpty()){
                int val = max.poll();
                val--;
                if(val>0) q.offer(new int[]{val,time+n});
            }
            if(!q.isEmpty() && q.peek()[1]==time) max.add(q.poll()[0]);
        }
        return time;
    }
}
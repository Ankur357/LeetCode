class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] sortedTasks = new int[tasks.length][3];
        for(int i=0;i<tasks.length;i++){
            sortedTasks[i][0] = tasks[i][0]; //enqueue time
            sortedTasks[i][1] = tasks[i][1]; //processing time
            sortedTasks[i][2] = i; //index
        }
        Arrays.sort(sortedTasks, (a,b) -> Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) ->
        a[1]!=b[1]?a[1]-b[1]:a[2]-b[2]);
        
        int[] res = new int[tasks.length];
        int currTime=0;
        int taskIndex=0;
        int ansIndex=0;
          while (taskIndex < tasks.length || !pq.isEmpty()) {
            if (pq.isEmpty() && currTime < sortedTasks[taskIndex][0]) {
                currTime = sortedTasks[taskIndex][0];
            }
            while (taskIndex < tasks.length && currTime >= sortedTasks[taskIndex][0]) { 
                pq.add(sortedTasks[taskIndex]);
                ++taskIndex;
            }
            int[] temp = pq.poll();
            currTime += temp[1]; 
            res[ansIndex++] = temp[2];
        }
        return res;
    }
}
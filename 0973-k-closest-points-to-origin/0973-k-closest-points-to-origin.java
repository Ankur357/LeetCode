class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> max = new PriorityQueue<>((a,b) -> b.key-a.key);
        for(int i=0;i<points.length;i++){
            max.add(new Pair(points[i][0]*points[i][0]+points[i][1]*points[i][1],
                             points[i][0],points[i][1]));
            if(max.size()>k) max.poll();
        }
        int[][] res = new int[k][2];
        int i=0;
        while(max.size()>0){
            res[i][0] = max.peek().x;
            res[i][1] = max.peek().y;
            max.poll();
            i++;
        }
        return res;
    }
}
class Pair{
        int key;
        int x;
        int y;
        Pair(int key, int x, int y){
            this.key=key;
            this.x=x;
            this.y=y;
        }
}
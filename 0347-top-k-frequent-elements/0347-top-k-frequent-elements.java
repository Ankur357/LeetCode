class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer> map =new HashMap<>();
        for(int num: nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<int[]> min = new PriorityQueue<>((a,b) -> 
        Integer.compare(a[1],b[1]));
        for(Map.Entry<Integer,Integer> m: map.entrySet()){
            min.add(new int[]{m.getKey(),m.getValue()});
            if(min.size()>k) min.poll();
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = min.poll()[0];
        }
        return res;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Pair<Integer,Integer>> pq=new PriorityQueue<>((a,b)-> b.getKey()!=a.getKey()?b.getKey()-a.getKey():b.getValue()-a.getValue());
        for(int i=0;i<arr.length;i++){
            pq.add(new Pair <>(Math.abs(x-arr[i]),arr[i]));
        }
        while(pq.size()>k){
            pq.remove();
        }
        LinkedList<Integer> list=new LinkedList<>();
        while(!pq.isEmpty()){
            list.addFirst(pq.remove().getValue());
        }
        Collections.sort(list);
        return list;
    }
}
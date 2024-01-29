class Solution {
    public int[] frequencySort(int[] arr) {
       int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        PriorityQueue<Pair> min = new PriorityQueue<>((a,b) -> 
        (a.value!=b.value)?(a.value-b.value):(b.key-a.key));
        
        for(Map.Entry<Integer,Integer> m: map.entrySet()){
            min.add(new Pair(m.getKey(),m.getValue()));
        }
        int[] res= new int[n];
        int k=0;
        while(min.size()>0){
            int key = min.peek().key;
            int value = min.poll().value;
            while(value>0){
                res[k++] = key;
                value--;
            }
        }
        return res; 
    }
}
class Pair{
        int key;
        int value;
        Pair(int key, int value){
            this.key=key;
            this.value=value;
    }
}
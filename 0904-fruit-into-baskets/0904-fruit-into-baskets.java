class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i=0;
        int j=0;
        int max=1;
        while(j<fruits.length){
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            if(map.size()<=2){
                max = Math.max(max,j-i+1);
            }
            else if(map.size()>2){
                while(map.size()>2){
                    map.put(fruits[i],map.get(fruits[i])-1);
                    if(map.get(fruits[i])==0) map.remove(fruits[i]);
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}
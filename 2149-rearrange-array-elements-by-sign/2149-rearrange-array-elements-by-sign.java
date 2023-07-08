class Solution {
    public int[] rearrangeArray(int[] arr) {
         int[] positive = new int[arr.length/2];
        int[] negative = new int[arr.length/2];
        int p=0,ne=0;
        for(int i:arr){
            if(i<0){
              negative[p]=i;
              p++;
            } 
            else{
              positive[ne] = i;
              ne++;
            } 
        }
        for(int i=0;i<arr.length/2;i++){
            arr[2*i] = positive[i];
            arr[2*i+1] = negative[i];
        }
        return arr;
    }
}
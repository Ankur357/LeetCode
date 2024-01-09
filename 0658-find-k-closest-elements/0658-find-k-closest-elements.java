class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int i=0;
        int j=arr.length-1;
        while(j-i+1>k){
            if(Math.abs(arr[i]-x)>Math.abs(arr[j]-x)) i++;
            else j--;
        }
        List<Integer> list = new ArrayList<>();
        for(int a=i;a<=j;a++){
            list.add(arr[a]);
        }
        return list;
    }
}
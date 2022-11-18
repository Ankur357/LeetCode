class Solution {
    public int averageValue(int[] arr) {
        int sum =0;
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
            if(arr[i]%3==0){
                sum+=arr[i];
                count++;
            }
        }
        }
        if(count==0) return 0;
        return Math.round(sum/count);
    }
}
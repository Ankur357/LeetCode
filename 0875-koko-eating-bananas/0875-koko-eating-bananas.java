class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxNum = Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            if(maxNum<piles[i]) maxNum = piles[i];
        }
        
        int low =1, high = maxNum;
        while(low<=high){
            int mid = low + (high-low)/2;
            int totalhour = minTime(piles,mid);
            if(totalhour<=h){
                high = mid-1;
            }
            else low = mid+1;
        }
        return low;
        
    }
    static int minTime(int[] arr, int time){
        int total = 0;
        for(int i=0;i<arr.length;i++){
            total += Math.ceil((double)arr[i]/(double)time);
        }
        return total;
    }
}
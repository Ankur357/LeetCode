class Solution {
    public int arrangeCoins(int n) {
        long l=0;
        long r=n;
        long ans=0;
        while(l<=r){
            long mid = l+(r-l)/2;
            ans = mid*(mid+1)/2;
            if(ans==n) return (int)mid;
            else if(ans>n) r=mid-1;
            else l=mid+1;
            
        }
        return (int)r;
    }
}
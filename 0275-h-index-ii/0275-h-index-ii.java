class Solution {
    public int hIndex(int[] citations) {
        int l = 0;
        int r = citations.length;
        int n= citations.length;
        int ans=0;
        while(l<r){
            int mid = l + (r-l)/2;
            
            if((n-mid)<=citations[mid]){
                ans = Math.max(ans,n-mid);
                r=mid;
            }
            else l= mid+1;
        }
        return ans;
    }
}
//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int N, int[] piles, int h) {
        // code here
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
        

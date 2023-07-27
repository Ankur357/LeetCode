//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            int K;
            K = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.smallestDivisor(nums, K);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int smallestDivisor(int[] nums, int K) {
        int max = Integer.MIN_VALUE;
        for(int num:nums){
            max = Math.max(max,num);
        }
        int low=1;
        int high = max;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(sumD(nums,mid)<=K){
                high = mid-1;
            }
            else low = mid+1;
        }
        return low;
    }
    public static int sumD(int[] nums ,int k){
        int sum=0;
        for(int num:nums){
            sum += Math.ceil((double)num/(double)k);
        }
        return sum;
    }
}
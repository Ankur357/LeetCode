//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findKRotation(int nums[], int n) {
        // code here
        int low =0;
        int high = nums.length-1;
        int ans = Integer.MAX_VALUE;
        int index=-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[low]<=nums[mid]){
                if(nums[low]<ans){
                    index = low;
                    ans = nums[low];
                }
                low = mid+1;
            }
            else{
                high = mid-1;
                if(nums[mid]<ans){
                    index = mid;
                    ans = nums[mid];
                }
            }
        }
        return index;
    }
}
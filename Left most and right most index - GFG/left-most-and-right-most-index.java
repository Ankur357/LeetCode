//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            // long getAnswer[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            long k = Long.parseLong(br.readLine().trim());
            
            Solution obj = new Solution();
            pair ans = obj.indexes(a, k);
            if (ans.first == -1 && ans.second == -1)
                System.out.println(-1);
            else
                System.out.println(ans.first+" "+ans.second);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

/*
class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}
*/

class Solution {
    
    public pair indexes(long v[], long x)
    {
        // Your code goes here
        int f = first(v,x);
        int s = second(v,x);
        pair p = new pair(f,s);
        return p;
    }
    static int first(long[] nums, long target){
        int l = 0;
        int h =nums.length-1;
        int ans = -1;
        while(l<=h){
            int m = l + (h-l)/2;
            if(nums[m]==target){
                ans = m;
                h = m-1;
            }
            else if(nums[m]<target) l = m+1;
            else h = m-1;
        }
        return ans;
    }
    static int second(long[] nums, long target){
        int l = 0;
        int h =nums.length-1;
        int ans = -1;
        while(l<=h){
            int m = l + (h-l)/2;
            if(nums[m]==target){
                ans = m;
                l = m+1;
            }
            else if(nums[m]<target) l = m+1;
            else h = m-1;
        }
        return ans;
    }
}
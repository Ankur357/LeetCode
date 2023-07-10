//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int nums[]){
        // code here
        List<Integer> list= new ArrayList<>();
        for(int i=0;i<N;i++){
            list.add(nums[i]);
        }
        int index=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                index=i;
                break;
            }
        }
        if(index==-1){
            Collections.reverse(list);
            return list;
        }
        
        for(int i=nums.length-1;i>0;i--){
            if(nums[index]<nums[i]){
                int tmp = nums[index];
                nums[index] = nums[i];
                nums[i] = tmp;
                break;
            }
        }
        reverse(nums,index+1,nums.length-1);
        List<Integer> list1= new ArrayList<>();
        for(int i=0;i<N;i++){
            list1.add(nums[i]);
        }
        return list1;
    }
     public static void reverse(int[] arr, int s , int e){
        while(s<e){
            int tmp = arr[s];
            arr[s] = arr[e];
            arr[e] = tmp;
            s++;
            e--;
        }
    }
}
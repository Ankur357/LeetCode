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
            int num[] = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    Vector<Integer> generateNextPalindrome(int num[], int n) {
        // code here
        Vector<Integer> out = new Vector<>(n);
        for (int digit : num) {
            out.add(digit);
        }
        int i = 0, j = n - 1;
        while (i < j) {  
            out.set(j, out.get(i));
            ++i;
            --j;
        }

        boolean isBig = false;
        for (int it = n / 2; it < n; ++it) {  
            if (out.get(it) > num[it]) {
                isBig = true;
                break;
            }
            if (out.get(it) < num[it])
                break;
        }
        if (isBig)  
            return out;

        i = (n % 2) != 0 ? n / 2 : (n / 2 - 1);  
        j = n / 2;

        while (i >= 0) {  
            if (out.get(i) < 9) {
                out.set(i, out.get(i) + 1);
                out.set(j, out.get(i));
                return out;
            }
            out.set(i, 0);
            out.set(j, 0);
            --i;
            ++j;
        }
        out.set(0, 1);
        out.add(1);
        return out;
    }
}
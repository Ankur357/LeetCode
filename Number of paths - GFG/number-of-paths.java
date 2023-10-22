//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int M = Integer.parseInt(inputLine[0]);
		    int N = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(M, N));
		}
	}
}




// } Driver Code Ends


class Solution{
    private final int mod = 1000000007;

    private long modInv(long a, long b) {
        return a > 1 ? (b - modInv(b % a, a) * b / a) : 1;
    }
    long numberOfPaths(int m, int n) {
        // Code Here
         long out = 1;

        for (int i = 0; i < m - 1; i++) {
            long inverse = modInv(i + 1, mod);
            out = (out * (i + n)) % mod;
            out = (out * inverse) % mod;
        }

        return out;
    }
    
}
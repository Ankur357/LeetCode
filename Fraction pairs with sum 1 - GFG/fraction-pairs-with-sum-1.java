//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] numerator = IntArray.input(br, n);
            
            
            int[] denominator = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.countFractions(n, numerator, denominator);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countFractions(int n, int[] numerator, int[] denominator) {
        // code here
        int count = 0;
        Map<String, Integer> fractionFrequency = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int gcd = calculateGCD(numerator[i], denominator[i]);
            int simplifiedNumerator = numerator[i] / gcd;
            int simplifiedDenominator = denominator[i] / gcd;

            int complementNumerator = simplifiedDenominator - simplifiedNumerator;
            int complementDenominator = simplifiedDenominator;

            String fractionKey = complementNumerator + "/" + complementDenominator;
            if (fractionFrequency.containsKey(fractionKey)) {
                count += fractionFrequency.get(fractionKey);
            }

            String currentFractionKey = simplifiedNumerator + "/" + simplifiedDenominator;
            fractionFrequency.put(currentFractionKey, fractionFrequency.getOrDefault(currentFractionKey, 0) + 1);
        }

        return count;
    }
    public static int calculateGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return calculateGCD(b, a % b);
    }
}
        

//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        
        List<Boolean> safe = new ArrayList<>(V);
        List<Boolean> vis = new ArrayList<>(V);
        
        for (int i = 0; i < V; i++) {
            safe.add(false);
            vis.add(false);
        }

        for (int i = 0; i < V; i++) {
            if (!vis.get(i)) {
                dfs(i, adj, vis, safe);
            }
        }

        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (safe.get(i)) {
                out.add(i);
            }
        }

        return out;
    }
     private void dfs(int i, List<List<Integer>> adj, List<Boolean> vis, List<Boolean> safe) {
        if (safe.get(i)) {
            return;
        }
        if (vis.get(i)) {
            return;
        }
        vis.set(i, true);

        boolean isSafe = true;
        for (int edge : adj.get(i)) {
            dfs(edge, adj, vis, safe);
            isSafe &= safe.get(edge);
        }

        safe.set(i, isSafe);
    }
}


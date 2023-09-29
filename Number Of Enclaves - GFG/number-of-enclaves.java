//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int rows = grid.length;
    int cols = grid[0].length;

    // Mark all land cells connected to the boundary
    for (int i = 0; i < rows; i++) {
        if (grid[i][0] == 1) {
            dfs(grid, i, 0);
        }
        if (grid[i][cols - 1] == 1) {
            dfs(grid, i, cols - 1);
        }
    }

    for (int j = 0; j < cols; j++) {
        if (grid[0][j] == 1) {
            dfs(grid, 0, j);
        }
        if (grid[rows - 1][j] == 1) {
            dfs(grid, rows - 1, j);
        }
    }

    // Count the remaining land cells (enclaves)
    int count = 0;
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            if (grid[i][j] == 1) {
                count++;
            }
        }
    }

    return count;

    }
    private void dfs(int[][] grid, int row, int col) {
    int rows = grid.length;
    int cols = grid[0].length;

    if (row < 0 || col < 0 || row >= rows || col >= cols || grid[row][col] != 1) {
        return;
    }

    // Mark the current cell as visited
    grid[row][col] = 0;

    // Visit adjacent land cells
    dfs(grid, row + 1, col);
    dfs(grid, row - 1, col);
    dfs(grid, row, col + 1);
    dfs(grid, row, col - 1);
}

}
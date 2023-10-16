//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
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
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution{
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int largestIsland(int N,int[][] grid) 
    {
        // code here
                int n = grid.length;
        int maxSize = 0;

        // Helper array to track island sizes
        int[][] islandSizes = new int[n][n];

        int islandCount = 2; // Starting from 2, as 0 and 1 are used for water and land.
        Map<Integer, Integer> islandSizeMap = new HashMap<>(); // Mapping island ID to its size.

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, islandCount, islandSizes);
                    islandSizeMap.put(islandCount, size);
                    maxSize = Math.max(maxSize, size);
                    islandCount++;
                }
            }
        }

        // Try changing 0 to 1 and find the maximum island size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighborIslands = new HashSet<>();
                    int size = 1;
                    for (int[] dir : directions) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                            int neighborIsland = grid[ni][nj];
                            if (neighborIsland > 1) {
                                neighborIslands.add(neighborIsland);
                            }
                        }
                    }
                    for (int island : neighborIslands) {
                        size += islandSizeMap.get(island);
                    }
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        return maxSize;
    }

    private int dfs(int[][] grid, int i, int j, int islandId, int[][] islandSizes) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = islandId;
        int size = 1;

        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            size += dfs(grid, ni, nj, islandId, islandSizes);
        }

        islandSizes[i][j] = size;
        return size;
    }
}


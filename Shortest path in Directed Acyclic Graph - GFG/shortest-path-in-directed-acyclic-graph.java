//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int distance = edge[2];
            adjList.get(from).add(new int[]{to, distance});
        }

        int[] distances = new int[N];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{0, 0});

        while (!minHeap.isEmpty()) {
            int[] curr = minHeap.poll();
            int currVertex = curr[0];
            int currDistance = curr[1];

            if (currDistance > distances[currVertex]) {
                continue;
            }

            for (int[] neighbor : adjList.get(currVertex)) {
                int nextVertex = neighbor[0];
                int nextDistance = currDistance + neighbor[1];
                if (nextDistance < distances[nextVertex]) {
                    distances[nextVertex] = nextDistance;
                    minHeap.offer(new int[]{nextVertex, nextDistance});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                distances[i] = -1;
            }
        }

        return distances;
	}
}
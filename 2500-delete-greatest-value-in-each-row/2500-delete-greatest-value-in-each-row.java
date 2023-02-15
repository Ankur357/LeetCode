class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            Arrays.sort(grid[i]);
        }
        int sum=0;
        int max = Integer.MIN_VALUE;
        for(int i=grid[0].length-1;i>=0;i--){
            for(int j=0;j<grid.length;j++){
            max = Math.max(grid[j][i],max);
        }
            sum+=max;
            max = Integer.MIN_VALUE;
            
        }
        return sum;
    }
}
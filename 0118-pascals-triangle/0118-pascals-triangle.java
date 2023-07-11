class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int r=1;r<=numRows;r++){
            List<Integer> list = new ArrayList<>();
            for(int c=1;c<=r;c++){
                list.add(nCr(r-1,c-1));
            }
            ans.add(list);
        }
        return ans;
    }
    public static int nCr(int n,int r){
        long res =1;
        for(int i=0;i<r;i++){
            res*=(n-i);
            res/=(i+1);
        }
        return (int)res;
    }
}
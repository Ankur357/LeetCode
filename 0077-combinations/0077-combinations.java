class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(result, new ArrayList<Integer>(),1,n,k );
        return result;
    }
    private void backtrace(List<List<Integer>> result, ArrayList<Integer> comb,int start,int n,int k){
        if(k==0){
            result.add(new ArrayList<>(comb));
            return;
        }
        for(int i= start;i<=n;i++){
            comb.add(i);
            backtrace(result,comb,i+1,n,k-1);
            comb.remove(comb.size()-1);
        }
    }
}
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrace(ans,new ArrayList<Integer>(),candidates,target,0);
        return ans;
    }
   private void backtrace(List<List<Integer>> ans, ArrayList<Integer> list,int[] candidates,int target,int start){
        if(target==0){
            ans.add(new ArrayList<Integer>(list));
            return;
        }
        else if(target<0) return;
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1]) continue;
            list.add(candidates[i]);
            backtrace(ans,list,candidates,target-candidates[i],i+1);
            list.remove(list.size()-1);
        }
    }
}
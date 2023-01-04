class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(result,new ArrayList<Integer>(),nums);
        return result;
    }
    private void backtrace(List<List<Integer>>result, ArrayList<Integer> list,int[]nums){
        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtrace(result,list,nums);
            list.remove(list.size()-1);
        }
    }
}
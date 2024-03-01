class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0,nums,res,new ArrayList<>());
        return res;
    }
    public void backtrack(int idx,int[] arr, List<List<Integer>> res, List<Integer> list){
        res.add(new ArrayList<>(list));
        for(int i=idx;i<arr.length;i++){
            if(i!=idx && arr[i]==arr[i-1]) continue;
            list.add(arr[i]);
            backtrack(i+1,arr,res,list);
            list.remove(list.size()-1);
        }
    }
}